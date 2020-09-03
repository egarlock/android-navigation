package com.egarlock.androidnavigation.ui.three

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.egarlock.androidnavigation.R
import com.egarlock.androidnavigation.ui.base.BaseFragment

class ThreeFragment : BaseFragment() {

    // region - Variables
    // endregion



    // region - Constructors
    // endregion



    // region - Fragment Lifecycle Methods
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.three_fragment, container, false)
    }
    // endregion



    // region - Private API
    // endregion



    // region - Public API
    // endregion

}