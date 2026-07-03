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
    }
}
