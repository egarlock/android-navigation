package com.egarlock.androidnavigation.ui.main

import android.os.Bundle
import android.os.PersistableBundle
import android.view.MenuItem
import android.widget.Toolbar
import androidx.appcompat.app.ActionBarDrawerToggle
import com.egarlock.androidnavigation.R
import com.egarlock.androidnavigation.ui.base.BaseActivity
import com.egarlock.androidnavigation.ui.main.MainActivityViewModel.CurrentFragment
import com.google.android.material.bottomnavigation.BottomNavigationView
import kotlinx.android.synthetic.main.main_activity.*

class MainActivity : BaseActivity() {

    // region - Variables
    private val viewModel: MainActivityViewModel = MainActivityViewModelImpl()
    // endregion



    // region - Constructors
    // endregion



    // region - Activity Lifecycle Methods
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.main_activity)

        // Setup
        setupMainActivity()
    }
    // endregion



    // region - Private API
    private fun setupMainActivity() {

        // This
        this.title = "Android Navigation"
        this.supportActionBar?.hide()


        // Pager
        view_pager.offscreenPageLimit = MainActivityAdapter.fragmentCount()
        view_pager.adapter = MainActivityAdapter(this, supportFragmentManager)


        // BottomNavigationView
        bottom_navigation_view.setOnNavigationItemSelectedListener {
            BottomNavigationView_ItemSelected(it)
        }


        // DrawerLayout
        drawer_layout.addDrawerListener(ActionBarDrawerToggle(this, drawer_layout, tool_bar, R.string.navigation_view_open, R.string.navigation_view_close))


        // NavigationView
        navigation_view.setNavigationItemSelectedListener {
            NavigationView_ItemSelected(it)
        }

    }

    // UIResponders
    private fun BottomNavigationView_ItemSelected(item: MenuItem): Boolean {

        var currentFragment = when (item.itemId) {
            R.id.menu_item_one -> CurrentFragment.ONE
            R.id.menu_item_two -> CurrentFragment.TWO
            R.id.menu_item_three -> CurrentFragment.THREE
            else -> CurrentFragment.ONE
        }

        viewModel.currentFragment = currentFragment
        view_pager.setCurrentItem(currentFragment.ordinal, false)

        return true
    }
    private fun NavigationView_ItemSelected(item: MenuItem): Boolean {

        when (item.itemId) {
            R.id.navigation_view_menu_item_one -> {

            }
            R.id.navigation_view_menu_item_two -> {

            }
            R.id.navigation_view_menu_item_three -> {

            }
            R.id.navigation_view_menu_item_four -> {

            }
            R.id.navigation_view_menu_item_five -> {

            }
        }


        return true
    }

    // endregion



    // region - Public API
    // endregion

}