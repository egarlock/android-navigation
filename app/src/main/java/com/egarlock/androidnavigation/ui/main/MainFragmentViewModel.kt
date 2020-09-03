package com.egarlock.androidnavigation.ui.main

interface MainFragmentViewModel {

    enum class CurrentFragment { ONE, TWO, THREE }

    var currentFragment: CurrentFragment

}