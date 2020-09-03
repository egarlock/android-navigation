package com.egarlock.androidnavigation.ui.main

interface MainActivityViewModel {

    enum class CurrentFragment { ONE, TWO, THREE }

    var currentFragment: CurrentFragment

}