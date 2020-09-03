package com.egarlock.androidnavigation.ui.main

import android.content.Context
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter
import androidx.viewpager.widget.ViewPager
import com.egarlock.androidnavigation.ui.one.OneFragment
import com.egarlock.androidnavigation.ui.three.ThreeFragment
import com.egarlock.androidnavigation.ui.two.TwoFragment


class MainActivityAdapter(
    context: Context,
    fragmentManager: FragmentManager
) : FragmentStatePagerAdapter(fragmentManager, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT) {

    // region - Variables
    companion object {
        fun fragmentCount(): Int = MainActivityViewModel.CurrentFragment.values().count()
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
            MainActivityViewModel.CurrentFragment.ONE.ordinal -> OneFragment()
            MainActivityViewModel.CurrentFragment.TWO.ordinal -> TwoFragment()
            MainActivityViewModel.CurrentFragment.THREE.ordinal -> ThreeFragment()
            else -> OneFragment()
        }
    }
    // endregion


}