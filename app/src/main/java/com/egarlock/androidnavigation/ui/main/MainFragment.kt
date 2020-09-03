package com.egarlock.androidnavigation.ui.main

import android.os.Bundle
import android.view.*
import androidx.navigation.fragment.navArgs
import com.egarlock.androidnavigation.R
import com.egarlock.androidnavigation.ui.base.BaseFragment
import kotlinx.android.synthetic.main.main_activity.*
import kotlinx.android.synthetic.main.main_fragment.*

class MainFragment : BaseFragment() {

    // region - Variables
    private val viewModel: MainFragmentViewModel = MainFragmentViewModelImpl()

    private val args: MainFragmentArgs by navArgs<MainFragmentArgs>()
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


        // Pager
        view_pager.offscreenPageLimit = MainFragmentAdapter.fragmentCount()
        view_pager.adapter = MainFragmentAdapter(this.requireContext(), this.childFragmentManager)


        // BottomNavigationView
        bottom_navigation_view.setOnNavigationItemSelectedListener {
            bottomNavigationView_ItemSelected(it)
        }


        // Default MenuItem / Fragment
        if (args.defaultMenuItemId != 0) {
            bottom_navigation_view.selectedItemId = args.defaultMenuItemId
        }

    }

    // UIResponders
    private fun bottomNavigationView_ItemSelected(item: MenuItem): Boolean {

        when (item.itemId) {
            R.id.menu_item_one -> {
                viewModel.currentFragment = MainFragmentViewModel.CurrentFragment.ONE
                view_pager.currentItem = MainFragmentViewModel.CurrentFragment.ONE.ordinal
            }
            R.id.menu_item_two -> {
                viewModel.currentFragment = MainFragmentViewModel.CurrentFragment.TWO
                view_pager.currentItem = MainFragmentViewModel.CurrentFragment.TWO.ordinal
            }
            R.id.menu_item_three -> {
                viewModel.currentFragment = MainFragmentViewModel.CurrentFragment.THREE
                view_pager.currentItem = MainFragmentViewModel.CurrentFragment.THREE.ordinal
            }
        }

        return true
    }
    // endregion



    // region - Public API
    // endregion

}