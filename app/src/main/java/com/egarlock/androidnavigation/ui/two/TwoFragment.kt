package com.egarlock.androidnavigation.ui.two

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.egarlock.androidnavigation.R
import com.egarlock.androidnavigation.ui.base.BaseFragment

class TwoFragment : BaseFragment() {

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
        return inflater.inflate(R.layout.fragment_two, container, false)
    }
    // endregion



    // region - Private API
    private fun next(view: View) {

    }
    // endregion



    // region - Public API
    // endregion

}