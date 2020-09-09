package com.egarlock.androidnavigation.ui.main

import android.os.Bundle
import android.util.Log
import android.view.*
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.navArgs
import com.egarlock.androidnavigation.R
import com.egarlock.androidnavigation.ui.MainActivityViewModel
import com.egarlock.androidnavigation.ui.MainActivityViewModelImpl
import com.egarlock.androidnavigation.ui.base.BaseFragment
import kotlinx.android.synthetic.main.main_activity.*
import kotlinx.android.synthetic.main.main_fragment.*

class MainFragment : BaseFragment() {

    // region - Variables
    private val viewModel: MainFragmentViewModel = MainFragmentViewModelImpl()

    private lateinit var activityViewModel: MainActivityViewModel
    // endregion



    // region - Constructors
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.main_fragment, container, false)
    }
    override fun onStart() {
        super.onStart()

        // Setup
        setupMainFragment()
    }
    // endregion



    // region - Fragment Lifecycle Methods
    // endregion



    // region - Private API
    private fun setupMainFragment() {

        // This


        // ViewModel
        this.activityViewModel = activity?.let {
            ViewModelProvider(this).get(MainActivityViewModelImpl::class.java)
        } ?: throw Exception("Invalid Activity")


        // Pager
        view_pager.offscreenPageLimit = MainFragmentAdapter.fragmentCount()
        view_pager.adapter = MainFragmentAdapter(this.requireContext(), this.childFragmentManager)


        // BottomNavigationView
        bottom_navigation_view.setOnNavigationItemSelectedListener {
            bottomNavigationView_ItemSelected(it)
        }


        // Default MenuItem / Fragment
//        if (args.defaultMenuItemId != 0) {
//            bottom_navigation_view.selectedItemId = args.defaultMenuItemId
//        }


        // MainPagerFragment
        activityViewModel.mainPagerFragment.observe(this, Observer { mainPagerFragment ->
            view_pager.currentItem = mainPagerFragment.ordinal
        })

        Log.d("HERE", "$activityViewModel")

    }

    // UIResponders
    private fun bottomNavigationView_ItemSelected(item: MenuItem): Boolean {

        when (item.itemId) {
            R.id.menu_item_one -> {
                activityViewModel.mainPagerFragment.value = MainActivityViewModel.MainPagerFragent.ONE
            }
            R.id.menu_item_two -> {
                activityViewModel.mainPagerFragment.value = MainActivityViewModel.MainPagerFragent.TWO
            }
            R.id.menu_item_three -> {
                activityViewModel.mainPagerFragment.value = MainActivityViewModel.MainPagerFragent.THREE
            }
        }

        return true
    }
    // endregion



    // region - Public API
    // endregion

}