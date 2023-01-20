package com.atitto.mviflowarch.theme

import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.graphics.Color

val Midnight = Color(0xFF00143C)
val Biscay = Color(0xFF183060)
val AzureRadiance = Color(0xFF00AFFF)
val Midnight20 = Color(0x2000143C)
val Midnight60 = Color(0x6000143C)
val BermudaGray = Color(0xFF7383A6)
val Melrose = Color(0xFFADC9FF)
val PattensBlue = Color(0xFFD7E3FF)
val Zircon = Color(0xFFEBF1FF)
val ZirconLight = Color(0xFFF3F7FF)
val MalachiteLight = Color(0xFFD6FFEA)
val Malachite = Color(0xFF08D228)
val Yellow = Color(0xFFFAFF05)
val MangoTango = Color(0xFFEB7400)
val MangoTango33 = Color(0x33EB7400)
val Pomegranate = Color(0xFFF23C3E)
val Pomegranate33 = Color(0x33F23C3E)

val White = Color(0xFFFFFFFF)
val Black = Color(0xFF000000)

/**
 *
 * Color schemes
 *
 */
fun schectLightColorScheme (
    primary: Color = Midnight,
    onPrimary: Color = White,
    primaryContainer: Color = Biscay,
    onPrimaryContainer: Color = White,
    inversePrimary: Color = Color.Unspecified,
    secondary: Color = Midnight,
    onSecondary: Color = White,
    secondaryContainer: Color = Melrose,
    onSecondaryContainer: Color = Midnight,
    tertiary: Color = Yellow,
    onTertiary: Color = Black,
    tertiaryContainer: Color = Color.Unspecified,
    onTertiaryContainer: Color = Color.Unspecified,
    quaternary: Color = AzureRadiance,
    onQuaternary: Color = White,
    quaternaryContainer: Color = Color.Unspecified,
    onQuaternaryContainer: Color = Color.Unspecified,
    background: Color = ZirconLight,
    onBackground: Color = Midnight,
    surface: Color = White,
    onSurface: Color = Midnight,
    surfaceVariant: Color = Zircon,
    onSurfaceVariant: Color = Midnight,
    surfaceTint: Color = Midnight,
    inverseSurface: Color = Color.Unspecified,
    inverseOnSurface: Color = Color.Unspecified,
    error: Color = Pomegranate33,
    onError: Color = Pomegranate,
    errorContainer: Color = Pomegranate33,
    onErrorContainer: Color = Pomegranate,
    outline: Color = PattensBlue,
    warning: Color = MangoTango33,
    onWarning: Color = MangoTango,
    warningContainer: Color = MangoTango33,
    onWarningContainer: Color = MangoTango,
    success: Color = MalachiteLight,
    onSuccess: Color = Malachite,
    successContainer: Color = Malachite,
    onSuccessContainer: Color = MalachiteLight,
): SchectColorScheme = SchectColorScheme(
    primary,
    onPrimary,
    primaryContainer,
    onPrimaryContainer,
    inversePrimary,
    secondary,
    onSecondary,
    secondaryContainer,
    onSecondaryContainer,
    tertiary,
    onTertiary,
    tertiaryContainer,
    onTertiaryContainer,
    quaternary,
    onQuaternary,
    quaternaryContainer,
    onQuaternaryContainer,
    background,
    onBackground,
    surface,
    onSurface,
    surfaceVariant,
    onSurfaceVariant,
    surfaceTint,
    inverseSurface,
    inverseOnSurface,
    error,
    onError,
    errorContainer,
    onErrorContainer,
    outline,
    warning,
    onWarning,
    warningContainer,
    onWarningContainer,
    success,
    onSuccess,
    successContainer,
    onSuccessContainer,
)

val LocalReplacementColors = staticCompositionLocalOf { schectLightColorScheme() }
