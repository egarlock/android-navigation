package com.egarlock.androidnavigation.ui.view.viewpager

import android.content.Context
import android.util.AttributeSet
import android.view.MotionEvent
import androidx.viewpager.widget.ViewPager

class NoScrollViewPager : ViewPager {

    // region - Variables
    // endregion



    // region - Constructors
    constructor(context: Context) : super(context)
    constructor(context: Context, attrs: AttributeSet) : super(context, attrs)
    // endregion



    // region - ViewPager Lifecycle  Methods
    // endregion



    // region - Private API
    override fun onTouchEvent(ev: MotionEvent?): Boolean {
        return false
    }
    override fun onInterceptTouchEvent(ev: MotionEvent?): Boolean {
        return false
    }
    // endregion



    // region - Public API
    // endregion

}