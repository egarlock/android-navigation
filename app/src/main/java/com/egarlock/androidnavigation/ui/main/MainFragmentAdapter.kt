package com.egarlock.androidnavigation.ui.main

import android.content.Context
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter
import com.egarlock.androidnavigation.ui.MainActivityViewModel
import com.egarlock.androidnavigation.ui.one.OneFragment
import com.egarlock.androidnavigation.ui.three.ThreeFragment
import com.egarlock.androidnavigation.ui.two.TwoFragment


class MainFragmentAdapter(
    context: Context,
    fragmentManager: FragmentManager
) : FragmentStatePagerAdapter(fragmentManager, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT) {

    // region - Variables
    companion object {
        fun fragmentCount(): Int = MainActivityViewModel.MainPagerFragent.values().count()
    }
    // endregion



    // region - Constructors
    // endregion



    // region - Private API
    // endregion



    // region - Public API
    // FragmentStatePagerAdapter
    override fun getCount(): Int = fragmentCount()
    override fun getItem(position: Int): Fragment {
        return when(position) {
            MainActivityViewModel.MainPagerFragent.ONE.ordinal -> OneFragment()
            MainActivityViewModel.MainPagerFragent.TWO.ordinal -> TwoFragment()
            MainActivityViewModel.MainPagerFragent.THREE.ordinal -> ThreeFragment()
            else -> OneFragment()
        }
    }
    // endregion


}