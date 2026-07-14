package com.example.design_system.colors

import androidx.compose.runtime.Immutable
import androidx.compose.ui.graphics.Color

@Immutable
open class BaseColor(

    // Base - Neutral (Dark Theme Night Sky & Slate)
    val Neutral100: Color = Color(0xFF0C0E12), // Surface Lowest
    val Neutral95: Color = Color(0xFF111318),  // Surface / Surface Dim
    val Neutral90: Color = Color(0xFF1A1C20),  // Surface Container Low
    val Neutral80: Color = Color(0xFF1E2024),  // Surface Container
    val Neutral70: Color = Color(0xFF282A2E),  // Surface Container High
    val Neutral60: Color = Color(0xFF333539),  // Surface Container Highest
    val Neutral50: Color = Color(0xFF37393E),  // Surface Bright / Secondary
    val Neutral40: Color = Color(0xFF3B494C),  // Outline Variant
    val Neutral30: Color = Color(0xFF849396),  // Outline
    val Neutral20: Color = Color(0xFFBAC9CC),  // On Surface Variant
    val Neutral10: Color = Color(0xFFE2E2E8),  // On Surface / Background
    val Neutral0: Color = Color(0xFFFCFFFE),   // White/Purest Light

    // Base - Cloud (Light Theme Pure Cloud)
    val Cloud100: Color = Color(0xFFF8FAFB),   // Light Surface
    val Cloud90: Color = Color(0xFFF2F4F5),    // Light Container Low
    val Cloud80: Color = Color(0xFFD8DADB),    // Light Surface Dim
    val Cloud70: Color = Color(0xFFD1E1FF),    // Light Selection / Accent Tint

    // Base - Cyan Flare (Electric Cyan Primary)
    val CyanFlare100: Color = Color(0xFF00E5FF), // Primary / Primary Container
    val CyanFlare90: Color = Color(0xFF00DAF3),  // Surface Tint / Fixed Dim
    val CyanFlare80: Color = Color(0xFF9CF0FF),  // Primary Fixed
    val CyanFlare70: Color = Color(0xFFC3F5FF),  // On Primary
    val CyanFlare10: Color = Color(0xFF001F24),  // On Primary Fixed

    // Base - Azure (Deep Azure - Light Primary)
    val Azure100: Color = Color(0xFF005BBF),    // Light Mode Primary
    val Azure90: Color = Color(0xFF006875),     // Inverse Primary

    // Base - Slate Blue (Secondary)
    val SlateBlue100: Color = Color(0xFF37393E), // Secondary
    val SlateBlue90: Color = Color(0xFF23005B),  // On Secondary Fixed
    val SlateBlue80: Color = Color(0xFF3C0090),  // On Secondary
    val SlateBlue70: Color = Color(0xFF5700C9),  // On Secondary Fixed Variant
    val SlateBlue60: Color = Color(0xFF7000FF),  // Secondary Container
    val SlateBlue50: Color = Color(0xFFD1BCFF),  // Secondary Fixed Dim
    val SlateBlue40: Color = Color(0xFFDDCDFF),  // On Secondary Container
    val SlateBlue30: Color = Color(0xFFE9DDFF),  // Secondary Fixed

    // Base - Warning & Urgent (Red/Gold)
    val UrgentRed100: Color = Color(0xFFFFB4AB), // Error / Urgent Text
    val UrgentRed90: Color = Color(0xFF93000A),  // Error Container
    val UrgentRed10: Color = Color(0xFF690005),  // On Error

    val AmberGold100: Color = Color(0xFFFEC931), // Tertiary Container
    val AmberGold90: Color = Color(0xFFF3BF26),  // Tertiary Fixed Dim
    val AmberGold80: Color = Color(0xFFFFDF96),  // Tertiary Fixed
    val AmberGold70: Color = Color(0xFFFFEAC0),  // Tertiary

    // Base - Success Green
    val GreenAlpha100: Color = Color(0xFF4CAF50),
    val GreenAlpha95: Color = Color(0xF24CAF50),
    val GreenAlpha90: Color = Color(0xE64CAF50),
    val GreenAlpha80: Color = Color(0xCC4CAF50),
    val GreenAlpha70: Color = Color(0xB34CAF50),
    val GreenAlpha60: Color = Color(0x994CAF50),
    val GreenAlpha50: Color = Color(0x804CAF50),
    val GreenAlpha40: Color = Color(0x664CAF50),
    val GreenAlpha30: Color = Color(0x4D4CAF50),
    val GreenAlpha20: Color = Color(0x334CAF50),
    val GreenAlpha10: Color = Color(0x1A4CAF50),
    val GreenAlpha5: Color = Color(0x0D4CAF50),

    // base white
    val WhiteAlpha100: Color = Color(0xFFFDFDFD),
    val WhiteAlpha95: Color = Color(0xF2FDFDFD),
    val WhiteAlpha90: Color = Color(0xE6FDFDFD),
    val WhiteAlpha80: Color = Color(0xCCFDFDFD),
    val WhiteAlpha70: Color = Color(0xB3FDFDFD),
    val WhiteAlpha60: Color = Color(0x99FDFDFD),
    val WhiteAlpha50: Color = Color(0x80FDFDFD),
    val WhiteAlpha40: Color = Color(0x66FDFDFD),
    val WhiteAlpha30: Color = Color(0x4DFDFDFD),
    val WhiteAlpha20: Color = Color(0x33FDFDFD),
    val WhiteAlpha10: Color = Color(0x1AFDFDFD),
    val WhiteAlpha5: Color = Color(0x0DFDFDFD),

    // pure black
    val PureBlackAlpha100: Color = Color(0xFF000000),
    val PureBlackAlpha95: Color = Color(0xF2000000),
    val PureBlackAlpha90: Color = Color(0xE6000000),
    val PureBlackAlpha80: Color = Color(0xCC000000),
    val PureBlackAlpha70: Color = Color(0xB3000000),
    val PureBlackAlpha60: Color = Color(0x99000000),
    val PureBlackAlpha50: Color = Color(0x80000000),
    val PureBlackAlpha40: Color = Color(0x66000000),
    val PureBlackAlpha30: Color = Color(0x4D000000),
    val PureBlackAlpha20: Color = Color(0x33000000),
    val PureBlackAlpha10: Color = Color(0x1A000000),
    val PureBlackAlpha5: Color = Color(0x0D000000),
    val PureBlackAlpha0: Color = Color(0x00000000),

    val Purple80: Color = Color(0xFFD0BCFF),
    val PurpleGrey80: Color = Color(0xFFCCC2DC),
    val Pink80: Color = Color(0xFFEFB8C8),

    val Purple40: Color = Color(0xFF6650a4),
    val PurpleGrey40: Color = Color(0xFF625b71),
    val Pink40: Color = Color(0xFF7D5260),
    val Transparent: Color = Color(0x00FFFFFF),
)
