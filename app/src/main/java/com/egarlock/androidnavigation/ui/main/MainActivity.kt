package com.egarlock.androidnavigation.ui.main

import android.os.Bundle
import android.util.Log
import android.view.Gravity
import android.view.MenuItem
import androidx.appcompat.app.ActionBarDrawerToggle
import com.egarlock.androidnavigation.R
import com.egarlock.androidnavigation.ui.base.BaseActivity
import com.egarlock.androidnavigation.ui.main.MainActivityViewModel.CurrentFragment
import com.egarlock.androidnavigation.util.onMainThread
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
            bottomNavigationView_ItemSelected(it)
        }


        // DrawerLayout
        drawer_layout.addDrawerListener(ActionBarDrawerToggle(this, drawer_layout, tool_bar, R.string.navigation_view_open, R.string.navigation_view_close))


        // NavigationView
        navigation_view.setNavigationItemSelectedListener {
            navigationView_ItemSelected(it)
        }

    }

    // UIResponders
    private fun bottomNavigationView_ItemSelected(item: MenuItem): Boolean {

        when (item.itemId) {
            R.id.menu_item_one -> {
                viewModel.currentFragment = CurrentFragment.ONE
                view_pager.currentItem = CurrentFragment.ONE.ordinal
            }
            R.id.menu_item_two -> {
                viewModel.currentFragment = CurrentFragment.TWO
                view_pager.currentItem = CurrentFragment.TWO.ordinal
            }
            R.id.menu_item_three -> {
                viewModel.currentFragment = CurrentFragment.THREE
                view_pager.currentItem = CurrentFragment.THREE.ordinal
            }
        }

        return true
    }
    private fun navigationView_ItemSelected(item: MenuItem): Boolean {

        when (item.itemId) {
            R.id.navigation_view_menu_item_one -> {
                drawer_layout.closeDrawer(Gravity.LEFT)
                bottom_navigation_view.selectedItemId = R.id.menu_item_one
            }
            R.id.navigation_view_menu_item_two -> {
                drawer_layout.closeDrawer(Gravity.LEFT)
                bottom_navigation_view.selectedItemId = R.id.menu_item_two
            }
            R.id.navigation_view_menu_item_three -> {
                drawer_layout.closeDrawer(Gravity.LEFT)
                bottom_navigation_view.selectedItemId = R.id.menu_item_three
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