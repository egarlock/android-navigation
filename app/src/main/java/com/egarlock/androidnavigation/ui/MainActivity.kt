package com.egarlock.androidnavigation.ui

import android.os.Bundle
import android.view.Gravity
import android.view.MenuItem
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.core.os.bundleOf
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.egarlock.androidnavigation.R
import com.egarlock.androidnavigation.ui.base.BaseActivity
import com.egarlock.androidnavigation.ui.main.MainFragment
import kotlinx.android.synthetic.main.main_activity.*

class MainActivity : BaseActivity() {

    // region - Variables
    private lateinit var navController: NavController
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


        // NavController
        navController = Navigation.findNavController(this, R.id.navigation_fragment)

    }

    // UIResponders
    private fun navigationView_ItemSelected(item: MenuItem): Boolean {

        drawer_layout.closeDrawer(Gravity.LEFT)

        when (item.itemId) {
            R.id.navigation_view_menu_item_one -> {
                var args = bundleOf("defaultMenuItemId" to R.id.menu_item_one)
                navController.navigate(R.id.navigation_fragment_main, args)
            }
            R.id.navigation_view_menu_item_two -> {
                var args = bundleOf("defaultMenuItemId" to R.id.menu_item_two)
                navController.navigate(R.id.navigation_fragment_main, args)
            }
            R.id.navigation_view_menu_item_three -> {
                var args = bundleOf("defaultMenuItemId" to R.id.menu_item_three)
                navController.navigate(R.id.navigation_fragment_main, args)
            }
            R.id.navigation_view_menu_item_four -> {
                navController.navigate(R.id.navigation_fragment_four)
            }
            R.id.navigation_view_menu_item_five -> {
                navController.navigate(R.id.navigation_fragment_five)
            }
        }

        return true
    }

    override fun onSupportNavigateUp(): Boolean {
        return  Navigation.findNavController(this, R.id.navigation_fragment).navigateUp() || super.onSupportNavigateUp()
    }
    // endregion



    // region - Public API
    // endregion

}