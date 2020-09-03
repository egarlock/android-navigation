package com.egarlock.androidnavigation.util

import android.os.Looper

fun onMainThread() = Looper.myLooper() == Looper.getMainLooper()

