package com.egarlock.androidnavigation.ui.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration

final class NavigationHostFragment : Fragment(), NavigationHost {

    private val defaultInt = -1
    private var layoutRes: Int = -1
    private var toolbarId: Int = -1
    private var navHostId: Int = -1

    private val rootDestinations = emptySet<Int>()
    private val appBarConfig = AppBarConfiguration.Builder(rootDestinations).build()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            layoutRes = it.getInt(KEY_LAYOUT)
            toolbarId = it.getInt(KEY_TOOLBAR)
            navHostId = it.getInt(KEY_NAV_HOST)
        } ?: return
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return if (layoutRes == defaultInt) null
        else inflater.inflate(layoutRes, container, false)
    }

    // NavigationHost
    override fun onBackPressed(): Boolean {
        return requireActivity()
            .findNavController(navHostId)
            .navigateUp()
    }

    override fun popToRoot() {
        val navController = requireActivity()
            .findNavController(navHostId)
        navController.popBackStack(navController.graph.startDestination, false)
    }

    companion object {
        private const val KEY_LAYOUT = "key_layout"
        private const val KEY_TOOLBAR = "key_toolbar"
        private const val KEY_NAV_HOST = "key_nav_host"

        fun create(layoutRes: Int, toolbarId: Int, navHostId: Int) = NavigationHostFragment().apply {
            arguments = Bundle().apply {
                putInt(KEY_LAYOUT, layoutRes)
                putInt(KEY_TOOLBAR, toolbarId)
                putInt(KEY_NAV_HOST, navHostId)
            }
        }
    }

}