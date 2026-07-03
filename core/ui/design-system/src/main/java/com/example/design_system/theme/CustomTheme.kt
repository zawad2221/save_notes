package com.example.design_system.theme

import androidx.compose.runtime.Composable
import androidx.compose.runtime.staticCompositionLocalOf
import com.example.design_system.colors.DesignSystemColor
import com.example.design_system.spacing.DefaultSpacing
import com.example.design_system.text_size.DefaultTextSize
import com.example.design_system.typegraphy.DefaultTypography

val LocalDesignSystemColors = staticCompositionLocalOf {
    DesignSystemColor()
}

val LocalDesignSystemSpacing = staticCompositionLocalOf {
    DefaultSpacing()
}

val LocalDesignSystemTextSize = staticCompositionLocalOf {
    DefaultTextSize()
}

val LocalDesignSystemTypography = staticCompositionLocalOf {
    DefaultTypography()
}


object CustomTheme {
    val colors: DesignSystemColor
        @Composable get() = LocalDesignSystemColors.current

    val typography: DefaultTypography
        @Composable get() = LocalDesignSystemTypography.current

    val spacing: DefaultSpacing
        @Composable get() = LocalDesignSystemSpacing.current

    val textSize: DefaultTextSize
        @Composable get() = LocalDesignSystemTextSize.current
}