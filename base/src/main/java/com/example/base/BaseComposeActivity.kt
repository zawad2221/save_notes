package com.example.base

import android.graphics.Color
import androidx.activity.SystemBarStyle
import androidx.activity.enableEdgeToEdge
import androidx.fragment.app.FragmentActivity
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
open class BaseComposeActivity : FragmentActivity() {

    protected fun enableFullScreenView(isDark: Boolean = true) {
        val style =
            if (isDark) SystemBarStyle.dark(Color.TRANSPARENT)
            else SystemBarStyle.light(Color.TRANSPARENT, Color.TRANSPARENT)

        enableEdgeToEdge(
            statusBarStyle = style,
            navigationBarStyle = style
        )
    }
}