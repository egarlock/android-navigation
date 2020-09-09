package com.egarlock.androidnavigation.application

import android.app.Application
import androidx.lifecycle.ViewModelStore
import androidx.lifecycle.ViewModelStoreOwner

class App: Application(), ViewModelStoreOwner {

    private val store: ViewModelStore by lazy { ViewModelStore() }

    override fun getViewModelStore(): ViewModelStore = store

}