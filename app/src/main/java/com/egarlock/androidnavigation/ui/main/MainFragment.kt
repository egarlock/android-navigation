package com.egarlock.androidnavigation.ui.main

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.*
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.viewpager.widget.ViewPager
import com.egarlock.androidnavigation.R
import com.egarlock.androidnavigation.application.App
import com.egarlock.androidnavigation.ui.MainActivityViewModel
import com.egarlock.androidnavigation.ui.MainActivityViewModelImpl
import com.egarlock.androidnavigation.ui.base.BaseFragment
import com.egarlock.androidnavigation.ui.base.NavigationHost
import com.egarlock.androidnavigation.ui.base.NavigationHostFragment
import com.google.android.material.bottomnavigation.BottomNavigationView
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.fragment_main.*
import java.util.*

class MainFragment : BaseFragment(), NavigationHost,
    BottomNavigationView.OnNavigationItemSelectedListener,
    BottomNavigationView.OnNavigationItemReselectedListener, ViewPager.OnPageChangeListener {

    // region - Variables
    private val viewModel: MainFragmentViewModel = MainFragmentViewModelImpl()

    private lateinit var activityViewModel: MainActivityViewModel

    private var initial: Int? = null
    private val backStack = Stack<Int>()

    private val fragments = listOf(
        NavigationHostFragment.create(R.layout.fragment_host_one, R.id.tool_bar, R.id.nav_host_one),
        NavigationHostFragment.create(R.layout.fragment_host_two, R.id.tool_bar, R.id.nav_host_two),
        NavigationHostFragment.create(R.layout.fragment_host_three, R.id.tool_bar, R.id.nav_host_three)
    )
    private val indexToPage = mapOf(
        0 to R.id.menu_item_one,
        1 to R.id.menu_item_two,
        2 to R.id.menu_item_three
    )
    // endregion


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        arguments?.apply {
            initial = getInt("page")
        }
    }
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_main, container, false)
    }
    override fun onStart() {
        super.onStart()

        // ViewModel
        this.activityViewModel = activity?.let {
            ViewModelProvider(it.application as App).get(MainActivityViewModelImpl::class.java)
        } ?: throw Exception("Invalid Activity")


        // Pager
        view_pager.adapter = ViewPagerAdapter(childFragmentManager)
        view_pager.offscreenPageLimit = fragments.size
        view_pager.addOnPageChangeListener(this)


        // BottomNavigationView
        bottom_navigation_view.setOnNavigationItemSelectedListener(this)
        bottom_navigation_view.setOnNavigationItemReselectedListener(this)

        if (backStack.isEmpty()) setItem(initial ?: 0)
    }
    // endregion



    // region - Fragment Lifecycle Methods
    // endregion



    // region - Private API
    // Helpers
    private fun setItem(position: Int) {
        view_pager.currentItem = position
        backStack.push(position)
    }

    // BottomNavigationView
    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        val position = indexToPage.values.indexOf(item.itemId)
        if (view_pager.currentItem != position) setItem(position)
        return true
    }

    override fun onNavigationItemReselected(item: MenuItem) {
        val position = indexToPage.values.indexOf(item.itemId)
        val fragment = fragments[position] as? NavigationHost
        fragment?.popToRoot()
    }

    // ViewPager
    override fun onPageScrollStateChanged(state: Int) { }

    override fun onPageScrolled(position: Int, positionOffset: Float, positionOffsetPixels: Int) { }

    override fun onPageSelected(page: Int) {
        val itemId = indexToPage[page] ?: R.id.menu_item_one
        if (bottom_navigation_view.selectedItemId != itemId) bottom_navigation_view.selectedItemId = itemId
    }

    // NavigationHost
    override fun onBackPressed(): Boolean {

        var didNavigate = false

        if (!didNavigate) didNavigate = (fragments[view_pager.currentItem] as? NavigationHost)?.onBackPressed() ?: false

        if (!didNavigate) {
            if (backStack.size > 1) {
                backStack.pop()
                view_pager.currentItem = backStack.peek()
                didNavigate = true
            }
        }

        return didNavigate
    }

    override fun popToRoot() { }

    // MainActivity
    fun updatePage(page: Int) {
        if (view_pager.currentItem != page) setItem(page)
    }
    // endregion



    // region - Public API
    // endregion

    inner class ViewPagerAdapter(fragmentManager: FragmentManager) : FragmentStatePagerAdapter(fragmentManager, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT) {

        override fun getItem(position: Int): Fragment = fragments[position]

        override fun getCount(): Int = fragments.size

    }

}