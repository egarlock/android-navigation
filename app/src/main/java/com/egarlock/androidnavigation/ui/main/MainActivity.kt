package com.egarlock.androidnavigation.ui.main

import android.os.Bundle
import android.view.Gravity
import android.view.MenuItem
import androidx.appcompat.app.ActionBarDrawerToggle
import com.egarlock.androidnavigation.R
import com.egarlock.androidnavigation.ui.base.BaseActivity
import com.egarlock.androidnavigation.ui.main.MainFragmentViewModel.CurrentFragment
import kotlinx.android.synthetic.main.main_activity.*
import kotlinx.android.synthetic.main.main_fragment.*

class MainActivity : BaseActivity() {

    // region - Variables
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


        // DrawerLayout
        drawer_layout.addDrawerListener(ActionBarDrawerToggle(this, drawer_layout, tool_bar, R.string.navigation_view_open, R.string.navigation_view_close))


        // NavigationView
        navigation_view.setNavigationItemSelectedListener {
            navigationView_ItemSelected(it)
        }

    }

    // UIResponders
    private fun navigationView_ItemSelected(item: MenuItem): Boolean {

//        when (item.itemId) {
//            R.id.navigation_view_menu_item_one -> {
//                drawer_layout.closeDrawer(Gravity.LEFT)
//                bottom_navigation_view.selectedItemId = R.id.menu_item_one
//            }
//            R.id.navigation_view_menu_item_two -> {
//                drawer_layout.closeDrawer(Gravity.LEFT)
//                bottom_navigation_view.selectedItemId = R.id.menu_item_two
//            }
//            R.id.navigation_view_menu_item_three -> {
//                drawer_layout.closeDrawer(Gravity.LEFT)
//                bottom_navigation_view.selectedItemId = R.id.menu_item_three
//            }
//            R.id.navigation_view_menu_item_four -> {
//
//            }
//            R.id.navigation_view_menu_item_five -> {
//
//            }
//        }


        return true
    }

    // endregion



    // region - Public API
    // endregion

}