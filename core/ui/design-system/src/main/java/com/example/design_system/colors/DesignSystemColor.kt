package com.example.design_system.colors

import androidx.compose.runtime.Immutable
import androidx.compose.ui.graphics.Color

@Immutable
data class DesignSystemColor(
    // Theme - Brand
    val BrandPrimary100: Color = Color.Unspecified,
    val BrandPrimary80: Color = Color.Unspecified,
    val BrandPrimary60: Color = Color.Unspecified,
    val BrandPrimary40: Color = Color.Unspecified,
    val BrandPrimary20: Color = Color.Unspecified,
    val BrandPrimary10: Color = Color.Unspecified,
    val BrandSecondary100: Color = Color.Unspecified,
    val BrandSecondary80: Color = Color.Unspecified,
    val BrandSecondary90: Color = Color.Unspecified,

    // Theme - Background
    val BackgroundPrimary: Color = Color.Unspecified,
    val BackgroundSecondary: Color = Color.Unspecified,
    val BackgroundPrimaryAlternate: Color = Color.Unspecified,
    val BackgroundSecondaryAlternate: Color = Color.Unspecified,
    val BackgroundTertiary: Color = Color.Unspecified,
    val BackgorundWhite: Color = Color.Unspecified,
    val BackgorundBlack: Color = Color.Unspecified,
    val BackgorundAccent: Color = Color.Unspecified,
    val BackgroundSpecial1: Color = Color.Unspecified,
    val BackgroundSpecial2: Color = Color.Unspecified,
    val BackgroundSpecial3: Color = Color.Unspecified,

    // Theme - Fill
    val FillPrimary100: Color = Color.Unspecified,
    val FillSecondary: Color = Color.Unspecified,
    val FillTertiary: Color = Color.Unspecified,
    val FillAlternate: Color = Color.Unspecified,
    val FillPrimary95: Color = Color.Unspecified,
    val FillPrimary80: Color = Color.Unspecified,
    val FillPrimary60: Color = Color.Unspecified,
    val FillPrimary40: Color = Color.Unspecified,
    val FillPrimary20: Color = Color.Unspecified,
    val FillPrimary10: Color = Color.Unspecified,
    val FillPrimary5: Color = Color.Unspecified,
    val FillWhite: Color = Color.Unspecified,
    val FillBlack: Color = Color.Unspecified,
    val FillIconPrimary: Color = Color.Unspecified,
    val FillAlpha80: Color = Color.Unspecified,
    val FillAlpha40: Color = Color.Unspecified,
    val FillAlpha20: Color = Color.Unspecified,
    val FillAlpha10: Color = Color.Unspecified,
    val FillAlpha5: Color = Color.Unspecified,

    // Theme - Text
    val TextPrimary: Color = Color.Unspecified,
    val TextSecondary: Color = Color.Unspecified,
    val TextTertiary: Color = Color.Unspecified,
    val TextAlternate: Color = Color.Unspecified,
    val TextWhite: Color = Color.Unspecified,
    val TextBlack: Color = Color.Unspecified,
    val TextBrand: Color = Color.Unspecified,

    // Theme - Button States
    val ButtonPrimaryDefault: Color = Color.Unspecified,
    val ButtonPrimaryHover: Color = Color.Unspecified,
    val ButtonPrimaryHoverAlt: Color = Color.Unspecified,
    val ButtonPrimaryActive: Color = Color.Unspecified,
    val ButtonPrimaryFocused: Color = Color.Unspecified,
    val ButtonPrimaryOutlineBg: Color = Color.Unspecified,

    val ButtonSecondaryDefault: Color = Color.Unspecified,
    val ButtonSecondaryHover: Color = Color.Unspecified,
    val ButtonSecondaryHoverAlt: Color = Color.Unspecified,
    val ButtonSecondaryActive: Color = Color.Unspecified,
    val ButtonSecondaryFocused: Color = Color.Unspecified,
    val ButtonSecondaryOutlineBg: Color = Color.Unspecified,

    val ButtonTertiaryDefault: Color = Color.Unspecified,
    val ButtonTertiaryHover: Color = Color.Unspecified,
    val ButtonTertiaryHoverAlt: Color = Color.Unspecified,
    val ButtonTertiaryActive: Color = Color.Unspecified,
    val ButtonTertiaryFocused: Color = Color.Unspecified,
    val ButtonTertiaryOutlineBg: Color = Color.Unspecified,

    val ButtonWarningDefault: Color = Color.Unspecified,
    val ButtonWarningHover: Color = Color.Unspecified,
    val ButtonWarningHoverAlt: Color = Color.Unspecified,
    val ButtonWarningActive: Color = Color.Unspecified,
    val ButtonWarningFocused: Color = Color.Unspecified,
    val ButtonWarningOutlineBg: Color = Color.Unspecified,
    val ButtonDisabled: Color = Color.Unspecified,

    val ButtonBrandColorDefault: Color = Color.Unspecified,
    val ButtonBrandColorPressed: Color = Color.Unspecified,
    val ButtonBrandColorOutlineBg: Color = Color.Unspecified,
    val ButtonGreyDefault: Color = Color.Unspecified,
    val ButtonGreyPressed: Color = Color.Unspecified,
    val ButtonGreyOutlineBg: Color = Color.Unspecified,
    val ButtonGlassDefault: Color = Color.Unspecified,
    val ButtonGlassPressed: Color = Color.Unspecified,

    // Theme - Toggle Button
    val ToggleButtonSelectedColor: Color = Color.Unspecified,
    val ToggleButtonSelectedWhiteColor: Color = Color.Unspecified,
    val ToggleButtonPressedWhiteColor: Color = Color.Unspecified,
    val ToggleButtonUnselectedColor: Color = Color.Unspecified,
    val ToggleButtonSelectedTextColor: Color = Color.Unspecified,
    val ToggleButtonSelectedTextBlackColor: Color = Color.Unspecified,
    val ToggleButtonUnselectedTextColor: Color = Color.Unspecified,

    // Theme - Button Text
    val ButtonTextBranding: Color = Color.Unspecified,
    val ButtonTextPrimary: Color = Color.Unspecified,
    val ButtonTextSecondary: Color = Color.Unspecified,
    val ButtonTextAlternate: Color = Color.Unspecified,
    val ButtonTextTertiary: Color = Color.Unspecified,
    val ButtonTextBlack: Color = Color.Unspecified,
    val ButtonTextDisabled: Color = Color.Unspecified,
    val ButtonTextWarning: Color = Color.Unspecified,
    val ButtonTextDestructive: Color = Color.Unspecified,

    // Theme - Status
    val SuccessPrimary: Color = Color.Unspecified,
    val SuccessSecondary: Color = Color.Unspecified,
    val WarningPrimary: Color = Color.Unspecified,
    val WarningSecondary: Color = Color.Unspecified,
    val WarningTertiary: Color = Color.Unspecified,
    val ErrorPrimary: Color = Color.Unspecified,
    val ErrorSecondary: Color = Color.Unspecified,
    val ErrorTertiary: Color = Color.Unspecified,
    val ErrorQuaternary: Color = Color.Unspecified
) : BaseColor() {
    companion object {
        val baseColor = BaseColor()

        val defaultColor = DesignSystemColor(
            TextPrimary = baseColor.PureBlackAlpha100,
            TextSecondary = baseColor.PureBlackAlpha70,
            TextTertiary = baseColor.PureBlackAlpha50
        )


        val lightThemeColor = DesignSystemColor(
            // Theme - Brand
            BrandPrimary100 = baseColor.Azure100,
            BrandPrimary80 = baseColor.Azure90,
            BrandPrimary60 = baseColor.Cloud70,
            BrandPrimary40 = baseColor.Cloud80,
            BrandPrimary20 = baseColor.Cloud90,
            BrandPrimary10 = baseColor.Cloud100,
            BrandSecondary100 = baseColor.Neutral50,
            BrandSecondary80 = baseColor.Neutral30,
            BrandSecondary90 = baseColor.Neutral40,

            // Theme - Background
            BackgroundPrimary = baseColor.Cloud100,
            BackgroundSecondary = baseColor.Cloud90,
            BackgroundPrimaryAlternate = baseColor.Cloud90,
            BackgroundSecondaryAlternate = baseColor.Cloud100,
            BackgroundTertiary = baseColor.Neutral20,
            BackgorundWhite = baseColor.Neutral0,
            BackgorundBlack = baseColor.Neutral100,
            BackgorundAccent = baseColor.Cloud70,
            BackgroundSpecial1 = baseColor.AmberGold70,
            BackgroundSpecial2 = baseColor.Cloud80,
            BackgroundSpecial3 = baseColor.Neutral10,

            // Theme - Fill
            FillPrimary100 = baseColor.Azure100,
            FillSecondary = baseColor.Cloud90,
            FillTertiary = baseColor.Neutral20,
            FillAlternate = baseColor.Cloud80,
            FillPrimary95 = baseColor.Cloud90,
            FillPrimary80 = baseColor.Cloud80,
            FillPrimary60 = baseColor.Cloud70,
            FillPrimary40 = baseColor.Neutral30,
            FillPrimary20 = baseColor.Neutral20,
            FillPrimary10 = baseColor.Neutral10,
            FillPrimary5 = baseColor.Cloud100,
            FillWhite = baseColor.Neutral0,
            FillBlack = baseColor.Neutral100,
            FillIconPrimary = baseColor.Azure100,

            // Theme - Text
            TextPrimary = baseColor.Neutral100,
            TextSecondary = baseColor.Neutral50,
            TextTertiary = baseColor.Neutral30,
            TextAlternate = baseColor.Azure100,
            TextWhite = baseColor.Neutral0,
            TextBlack = baseColor.Neutral100,
            TextBrand = baseColor.Azure100,

            // Theme - Button States
            ButtonPrimaryDefault = baseColor.Azure100,
            ButtonPrimaryHover = baseColor.Azure90,
            ButtonPrimaryActive = baseColor.Azure90,
            ButtonSecondaryDefault = baseColor.Cloud80,
            ButtonSecondaryHover = baseColor.Neutral20,
            ButtonTertiaryDefault = baseColor.Neutral10,
            ButtonWarningDefault = baseColor.UrgentRed90,
            ButtonDisabled = baseColor.Neutral20,

            // Theme - Toggle Button
            ToggleButtonSelectedColor = baseColor.Azure100,
            ToggleButtonUnselectedColor = baseColor.Cloud90,
            ToggleButtonSelectedTextColor = baseColor.Neutral0,
            ToggleButtonUnselectedTextColor = baseColor.Neutral50,

            // Theme - Status
            SuccessPrimary = baseColor.GreenAlpha100, // Derived from industry standards for light
            WarningPrimary = baseColor.AmberGold90,
            ErrorPrimary = baseColor.UrgentRed90
        )

        val darkThemeColor = DesignSystemColor(
            // Theme - Brand
            BrandPrimary100 = baseColor.CyanFlare100,
            BrandPrimary80 = baseColor.CyanFlare90,
            BrandPrimary60 = baseColor.CyanFlare80,
            BrandPrimary40 = baseColor.CyanFlare70,
            BrandPrimary20 = baseColor.CyanFlare10,
            BrandPrimary10 = baseColor.Neutral100,
            BrandSecondary100 = baseColor.SlateBlue100,
            BrandSecondary80 = baseColor.SlateBlue50,
            BrandSecondary90 = baseColor.SlateBlue70,

            // Theme - Background
            BackgroundPrimary = baseColor.Neutral95,
            BackgroundSecondary = baseColor.Neutral90,
            BackgroundPrimaryAlternate = baseColor.Neutral100,
            BackgroundSecondaryAlternate = baseColor.Neutral80,
            BackgroundTertiary = baseColor.Neutral60,
            BackgorundWhite = baseColor.Neutral10,
            BackgorundBlack = baseColor.Neutral100,
            BackgorundAccent = baseColor.CyanFlare100,
            BackgroundSpecial1 = baseColor.SlateBlue60,
            BackgroundSpecial2 = baseColor.Neutral70,
            BackgroundSpecial3 = baseColor.Neutral100,

            // Theme - Fill
            FillPrimary100 = baseColor.CyanFlare100,
            FillSecondary = baseColor.Neutral90,
            FillTertiary = baseColor.Neutral70,
            FillAlternate = baseColor.Neutral60,
            FillPrimary95 = baseColor.Neutral95,
            FillPrimary80 = baseColor.Neutral80,
            FillPrimary60 = baseColor.Neutral60,
            FillPrimary40 = baseColor.Neutral40,
            FillPrimary20 = baseColor.Neutral20,
            FillPrimary10 = baseColor.Neutral10,
            FillPrimary5 = baseColor.Neutral100,
            FillWhite = baseColor.Neutral10,
            FillBlack = baseColor.Neutral100,
            FillIconPrimary = baseColor.CyanFlare100,

            // Theme - Text
            TextPrimary = baseColor.Neutral10,
            TextSecondary = baseColor.Neutral20,
            TextTertiary = baseColor.Neutral30,
            TextAlternate = baseColor.CyanFlare100,
            TextWhite = baseColor.Neutral10,
            TextBlack = baseColor.Neutral100,
            TextBrand = baseColor.CyanFlare100,

            // Theme - Button States
            ButtonPrimaryDefault = baseColor.CyanFlare100,
            ButtonPrimaryHover = baseColor.CyanFlare90,
            ButtonPrimaryActive = baseColor.CyanFlare90,
            ButtonSecondaryDefault = baseColor.SlateBlue100,
            ButtonSecondaryHover = baseColor.SlateBlue70,
            ButtonTertiaryDefault = baseColor.Transparent,
            ButtonWarningDefault = baseColor.UrgentRed100,
            ButtonDisabled = baseColor.Neutral60,

            // Theme - Toggle Button
            ToggleButtonSelectedColor = baseColor.CyanFlare100,
            ToggleButtonUnselectedColor = baseColor.Neutral90,
            ToggleButtonSelectedTextColor = baseColor.Neutral100,
            ToggleButtonUnselectedTextColor = baseColor.Neutral20,

            // Theme - Status
            SuccessPrimary = baseColor.GreenAlpha100, // Derived for dark high-viz
            WarningPrimary = baseColor.AmberGold100,
            ErrorPrimary = baseColor.UrgentRed100
        )
        val newThemeCustomColor = defaultColor
    }
}
