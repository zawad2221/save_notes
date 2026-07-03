package com.example.design_system.colors

import androidx.compose.runtime.Immutable
import androidx.compose.ui.graphics.Color

@Immutable
data class DesignSystemColor(
    // Text
    val TextPrimary: Color = Color.Unspecified,
    val TextSecondary: Color = Color.Unspecified,
    val TextTertiary: Color = Color.Unspecified,
) : BaseColor() {
    companion object {
        val baseColor = BaseColor()

        val defaultColor = DesignSystemColor(
            TextPrimary = baseColor.PureBlackAlpha100,
            TextSecondary = baseColor.PureBlackAlpha70,
            TextTertiary = baseColor.PureBlackAlpha50
        )

        val newThemeCustomColor = defaultColor
    }
}
