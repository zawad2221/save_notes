package com.example.design_system.typegraphy

import androidx.compose.runtime.Composable
import androidx.compose.runtime.Immutable
import androidx.compose.ui.text.TextStyle

@Immutable
data class DefaultTypography(
    val h1: TextStyle = TextStyle.Default,
    val h2: TextStyle = TextStyle.Default,
    val h3: TextStyle = TextStyle.Default,
    val h4: TextStyle = TextStyle.Default,
    val titleHeader: TextStyle = TextStyle.Default,
    val subhead1: TextStyle = TextStyle.Default,
    val subhead2: TextStyle = TextStyle.Default,
    val subhead3: TextStyle = TextStyle.Default,
    val body1: TextStyle = TextStyle.Default,
    val body2: TextStyle = TextStyle.Default,
    val body3: TextStyle = TextStyle.Default,
) {
    companion object {
        val defaultTypography: DefaultTypography
            @Composable get() = DefaultTypography(
                h1 = TypographyDefaultTheme.H1,
                h2 = TypographyDefaultTheme.H2,
                h3 = TypographyDefaultTheme.H3,
                h4 = TypographyDefaultTheme.H4,
                titleHeader = TypographyDefaultTheme.TitleHeader,
                subhead1 = TypographyDefaultTheme.Subhead1,
                subhead2 = TypographyDefaultTheme.Subhead2,
                subhead3 = TypographyDefaultTheme.Subhead3,
                body1 = TypographyDefaultTheme.Body1,
                body2 = TypographyDefaultTheme.Body2,
                body3 = TypographyDefaultTheme.Body3,
            )

        val darkTypography: DefaultTypography
            @Composable get() = DefaultTypography(
                h1 = TypographyDarkTheme.H1,
                h2 = TypographyDarkTheme.H2,
                h3 = TypographyDarkTheme.H3,
                h4 = TypographyDarkTheme.H4,
                titleHeader = TypographyDarkTheme.TitleHeader,
                subhead1 = TypographyDarkTheme.Subhead1,
                subhead2 = TypographyDarkTheme.Subhead2,
                subhead3 = TypographyDarkTheme.Subhead3,
                body1 = TypographyDarkTheme.Body1,
                body2 = TypographyDarkTheme.Body2,
                body3 = TypographyDarkTheme.Body3,
            )

        val lightTypography: DefaultTypography
            @Composable get() = DefaultTypography(
                h1 = TypographyLightTheme.H1,
                h2 = TypographyLightTheme.H2,
                h3 = TypographyLightTheme.H3,
                h4 = TypographyLightTheme.H4,
                titleHeader = TypographyLightTheme.TitleHeader,
                subhead1 = TypographyLightTheme.Subhead1,
                subhead2 = TypographyLightTheme.Subhead2,
                subhead3 = TypographyLightTheme.Subhead3,
                body1 = TypographyLightTheme.Body1,
                body2 = TypographyLightTheme.Body2,
                body3 = TypographyLightTheme.Body3,
            )
    }
}
