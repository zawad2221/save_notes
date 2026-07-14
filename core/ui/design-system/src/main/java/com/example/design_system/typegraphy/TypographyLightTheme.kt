package com.example.design_system.typegraphy

import androidx.compose.runtime.Composable
import androidx.compose.ui.text.PlatformTextStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import com.example.core.ui.dimens.R as DimenR
import com.example.design_system.colors.DesignSystemColor
import com.example.design_system.utils.textSizeResource

class TypographyLightTheme {
    companion object {
        val H1: TextStyle
            @Composable
            get() = TextStyle(
                fontSize = textSizeResource(DimenR.dimen.app_theme_text_headings_h1),
                fontFamily = OpenSansFontFamily,
                fontWeight = FontWeight.SemiBold,
                color = DesignSystemColor.lightThemeColor.TextPrimary,
                platformStyle = PlatformTextStyle(includeFontPadding = false)
            )

        val H2: TextStyle
            @Composable
            get() = H1.copy(fontSize = textSizeResource(DimenR.dimen.app_theme_text_headings_h2))

        val H3: TextStyle
            @Composable
            get() = H1.copy(fontSize = textSizeResource(DimenR.dimen.app_theme_text_headings_h3))

        val H4: TextStyle
            @Composable
            get() = H1.copy(fontSize = textSizeResource(DimenR.dimen.app_theme_text_headings_h4))

        val H5: TextStyle
            @Composable
            get() = H1.copy(fontSize = textSizeResource(DimenR.dimen.app_theme_text_headings_h5))

        val H6: TextStyle
            @Composable
            get() = H1.copy(fontSize = textSizeResource(DimenR.dimen.app_theme_text_headings_h6))

        val TitleHeader: TextStyle
            @Composable
            get() = TextStyle(
                fontSize = textSizeResource(DimenR.dimen.app_theme_text_headings_title_header),
                fontFamily = OpenSansFontFamily,
                fontWeight = FontWeight.SemiBold,
                color = DesignSystemColor.lightThemeColor.TextPrimary,
                platformStyle = PlatformTextStyle(includeFontPadding = false)
            )

        val Subhead1: TextStyle
            @Composable
            get() = TextStyle(
                fontSize = textSizeResource(DimenR.dimen.app_theme_text_body_subhead1),
                fontFamily = OpenSansFontFamily,
                fontWeight = FontWeight.SemiBold,
                color = DesignSystemColor.lightThemeColor.TextPrimary,
                platformStyle = PlatformTextStyle(includeFontPadding = false)
            )

        val Subhead2: TextStyle
            @Composable
            get() = Subhead1.copy(fontSize = textSizeResource(DimenR.dimen.app_theme_text_alt_body_subhead2))

        val Subhead3: TextStyle
            @Composable
            get() = Subhead1.copy(fontSize = textSizeResource(DimenR.dimen.app_theme_text_alt_body_subhead3))

        val Body1: TextStyle
            @Composable
            get() = TextStyle(
                fontSize = textSizeResource(DimenR.dimen.app_theme_text_body_body1),
                fontFamily = OpenSansFontFamily,
                fontWeight = FontWeight.Normal,
                color = DesignSystemColor.lightThemeColor.TextPrimary,
                platformStyle = PlatformTextStyle(includeFontPadding = false)
            )

        val Body2: TextStyle
            @Composable
            get() = Body1.copy(fontSize = textSizeResource(DimenR.dimen.app_theme_text_body_body2))

        val Body3: TextStyle
            @Composable
            get() = Body1.copy(fontSize = textSizeResource(DimenR.dimen.app_theme_text_body_body3))
    }
}
