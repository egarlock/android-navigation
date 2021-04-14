package com.egarlock.androidnavigation.ui

import android.os.Bundle
import android.view.Gravity
import android.view.MenuItem
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.egarlock.androidnavigation.R
import com.egarlock.androidnavigation.application.App
import com.egarlock.androidnavigation.ui.base.BaseActivity
import com.egarlock.androidnavigation.ui.base.NavigationHost
import com.egarlock.androidnavigation.ui.main.MainFragment
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : BaseActivity() {

    // region - Variables
    private lateinit var navController: NavController

    private lateinit var activityViewModel: MainActivityViewModel
    // endregion



    // region - Constructors
    // endregion



    // region - Activity Lifecycle Methods
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)

        // This
        this.title = "Android Navigation"
        this.supportActionBar?.hide()


        // ViewModel
        this.activityViewModel = ViewModelProvider(application as App).get(MainActivityViewModelImpl::class.java)


        // DrawerLayout
        drawer_layout.addDrawerListener(ActionBarDrawerToggle(this, drawer_layout, tool_bar, R.string.navigation_view_open, R.string.navigation_view_close))


        // NavigationView
        navigation_view.setNavigationItemSelectedListener {
            navigationView_ItemSelected(it)
        }


        // NavController
        navController = Navigation.findNavController(this, R.id.nav_host_main)
    }
    // endregion



    // region - Private API
    // Navigation Logic
    private fun navigateToDestinationIfNeeded(resId: Int, args: Bundle? = null) {
        if (navController.currentDestination?.id != resId) {
            navController.navigate(resId, args)
        }
    }

    // UIResponders
    private fun navigationView_ItemSelected(item: MenuItem): Boolean {

        drawer_layout.closeDrawer(Gravity.LEFT)

        when (item.itemId) {
            R.id.navigation_view_menu_item_one -> {
                val resId = R.id.dest_main
                if (navController.currentDestination?.id != resId) {
                    navController.navigate(resId, Bundle().apply {
                        putInt("page", 0)
                    })
                } else {
                    val fragment = (nav_host_main.childFragmentManager.fragments.first() as? MainFragment)
                    fragment?.updatePage(0)
                }
            }
            R.id.navigation_view_menu_item_two -> {
                val resId = R.id.dest_main
                if (navController.currentDestination?.id != resId) {
                    navController.navigate(resId, Bundle().apply {
                        putInt("page", 1)
                    })
                } else {
                    val fragment = (nav_host_main.childFragmentManager.fragments.first() as? MainFragment)
                    fragment?.updatePage(1)
                }
            }
            R.id.navigation_view_menu_item_three -> {
                val resId = R.id.dest_main
                if (navController.currentDestination?.id != resId) {
                    navController.navigate(resId, Bundle().apply {
                        putInt("page", 2)
                    })
                } else {
                    val fragment = (nav_host_main.childFragmentManager.fragments.first() as? MainFragment)
                    fragment?.updatePage(2)
                }
            }
            R.id.navigation_view_menu_item_four -> {
                navigateToDestinationIfNeeded(R.id.dest_four)
            }
            R.id.navigation_view_menu_item_five -> {
                navigateToDestinationIfNeeded(R.id.dest_five)
            }
        }

        return true
    }

    override fun onBackPressed() {

        var didNavigate = false

        if (!didNavigate) didNavigate = (nav_host_main.childFragmentManager.fragments.first() as? NavigationHost)?.onBackPressed() ?: false

        if (!didNavigate) didNavigate = navController.navigateUp()

        if (!didNavigate) super.onBackPressed()
    }
    // endregion



    // region - Public API
    // endregion

}