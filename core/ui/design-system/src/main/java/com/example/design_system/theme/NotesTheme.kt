package com.example.design_system.theme

import android.app.Activity
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.platform.LocalView
import androidx.core.view.WindowCompat
import com.example.design_system.colors.DesignSystemColor
import com.example.design_system.colors.Pink40
import com.example.design_system.colors.Pink80
import com.example.design_system.colors.Purple40
import com.example.design_system.colors.Purple80
import com.example.design_system.colors.PurpleGrey40
import com.example.design_system.colors.PurpleGrey80
import com.example.design_system.spacing.rememberDefaultSpacing
import com.example.design_system.text_size.rememberDefaultTextSize
import com.example.design_system.typegraphy.DefaultTypography
import com.example.design_system.typegraphy.Typography

private val DarkColorScheme = darkColorScheme(
    primary = Purple80,
    secondary = PurpleGrey80,
    tertiary = Pink80
)

private val LightColorScheme = lightColorScheme(
    primary = Purple40,
    secondary = PurpleGrey40,
    tertiary = Pink40
)

@Composable
fun NotesDefaultTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {
    val colorScheme = if (darkTheme) {
        DarkColorScheme
    } else {
        LightColorScheme
    }

    val designSystemColor = if (darkTheme) {
        DesignSystemColor.darkThemeColor
    } else {
        DesignSystemColor.lightThemeColor
    }

    val typography = if (darkTheme) {
        DefaultTypography.darkTypography
    } else {
        DefaultTypography.lightTypography
    }

    val view = LocalView.current
    if (!view.isInEditMode) {
        SideEffect {
            val window = (view.context as Activity).window
            val insetsController = WindowCompat.getInsetsController(window, view)
            insetsController.isAppearanceLightStatusBars = !darkTheme
        }
    }

    CompositionLocalProvider(
        LocalDesignSystemColors provides designSystemColor,
        LocalDesignSystemSpacing provides rememberDefaultSpacing(),
        LocalDesignSystemTextSize provides rememberDefaultTextSize(),
        LocalDesignSystemTypography provides typography
    ) {
        MaterialTheme(
            colorScheme = colorScheme, typography = Typography, content = content
        )
    }
}