package com.egarlock.androidnavigation.ui.main

import android.os.Bundle
import android.os.PersistableBundle
import com.egarlock.androidnavigation.R
import com.egarlock.androidnavigation.ui.base.BaseActivity

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

    }
    // endregion



    // region - Public API
    // endregion

}