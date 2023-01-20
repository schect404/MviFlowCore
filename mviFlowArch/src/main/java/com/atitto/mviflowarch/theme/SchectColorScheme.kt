package com.atitto.mviflowarch.theme

import androidx.compose.material3.LocalContentColor
import androidx.compose.runtime.Composable
import androidx.compose.runtime.Immutable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.runtime.structuralEqualityPolicy
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.isSpecified

@Immutable
class SchectColorScheme(
    primary: Color,
    onPrimary: Color,
    primaryContainer: Color,
    onPrimaryContainer: Color,
    inversePrimary: Color,
    secondary: Color,
    onSecondary: Color,
    secondaryContainer: Color,
    onSecondaryContainer: Color,
    tertiary: Color,
    onTertiary: Color,
    tertiaryContainer: Color,
    onTertiaryContainer: Color,
    quaternary: Color,
    onQuaternary: Color,
    quaternaryContainer: Color,
    onQuaternaryContainer: Color,
    background: Color,
    onBackground: Color,
    surface: Color,
    onSurface: Color,
    surfaceVariant: Color,
    onSurfaceVariant: Color,
    surfaceTint: Color,
    inverseSurface: Color,
    inverseOnSurface: Color,
    error: Color,
    onError: Color,
    errorContainer: Color,
    onErrorContainer: Color,
    outline: Color,
    warning: Color,
    onWarning: Color,
    warningContainer: Color,
    onWarningContainer: Color,
    success: Color,
    onSuccess: Color,
    successContainer: Color,
    onSuccessContainer: Color,
) {
    var primary by mutableStateOf(primary, structuralEqualityPolicy())
        internal set
    var onPrimary by mutableStateOf(onPrimary, structuralEqualityPolicy())
        internal set
    var primaryContainer by mutableStateOf(primaryContainer, structuralEqualityPolicy())
        internal set
    var onPrimaryContainer by mutableStateOf(onPrimaryContainer, structuralEqualityPolicy())
        internal set
    var inversePrimary by mutableStateOf(inversePrimary, structuralEqualityPolicy())
        internal set
    var secondary by mutableStateOf(secondary, structuralEqualityPolicy())
        internal set
    var onSecondary by mutableStateOf(onSecondary, structuralEqualityPolicy())
        internal set
    var secondaryContainer by mutableStateOf(secondaryContainer, structuralEqualityPolicy())
        internal set
    var onSecondaryContainer by mutableStateOf(onSecondaryContainer, structuralEqualityPolicy())
        internal set
    var tertiary by mutableStateOf(tertiary, structuralEqualityPolicy())
        internal set
    var onTertiary by mutableStateOf(onTertiary, structuralEqualityPolicy())
        internal set
    var tertiaryContainer by mutableStateOf(tertiaryContainer, structuralEqualityPolicy())
        internal set
    var onTertiaryContainer by mutableStateOf(onTertiaryContainer, structuralEqualityPolicy())
        internal set
    var quaternary by mutableStateOf(quaternary, structuralEqualityPolicy())
        internal set
    var onQuaternary by mutableStateOf(onQuaternary, structuralEqualityPolicy())
        internal set
    var quaternaryContainer by mutableStateOf(quaternaryContainer, structuralEqualityPolicy())
        internal set
    var onQuaternaryContainer by mutableStateOf(onQuaternaryContainer, structuralEqualityPolicy())
        internal set
    var background by mutableStateOf(background, structuralEqualityPolicy())
        internal set
    var onBackground by mutableStateOf(onBackground, structuralEqualityPolicy())
        internal set
    var surface by mutableStateOf(surface, structuralEqualityPolicy())
        internal set
    var onSurface by mutableStateOf(onSurface, structuralEqualityPolicy())
        internal set
    var surfaceVariant by mutableStateOf(surfaceVariant, structuralEqualityPolicy())
        internal set
    var onSurfaceVariant by mutableStateOf(onSurfaceVariant, structuralEqualityPolicy())
        internal set
    var surfaceTint by mutableStateOf(surfaceTint, structuralEqualityPolicy())
        internal set
    var inverseSurface by mutableStateOf(inverseSurface, structuralEqualityPolicy())
        internal set
    var inverseOnSurface by mutableStateOf(inverseOnSurface, structuralEqualityPolicy())
        internal set
    var error by mutableStateOf(error, structuralEqualityPolicy())
        internal set
    var onError by mutableStateOf(onError, structuralEqualityPolicy())
        internal set
    var errorContainer by mutableStateOf(errorContainer, structuralEqualityPolicy())
        internal set
    var onErrorContainer by mutableStateOf(onErrorContainer, structuralEqualityPolicy())
        internal set
    var outline by mutableStateOf(outline, structuralEqualityPolicy())
        internal set
    var warning by mutableStateOf(warning, structuralEqualityPolicy())
        internal set
    var onWarning by mutableStateOf(onWarning, structuralEqualityPolicy())
        internal set
    var warningContainer by mutableStateOf(warningContainer, structuralEqualityPolicy())
        internal set
    var onWarningContainer by mutableStateOf(onWarningContainer, structuralEqualityPolicy())
        internal set
    var success by mutableStateOf(success, structuralEqualityPolicy())
        internal set
    var onSuccess by mutableStateOf(onSuccess, structuralEqualityPolicy())
        internal set
    var successContainer by mutableStateOf(successContainer, structuralEqualityPolicy())
        internal set
    var onSuccessContainer by mutableStateOf(onSuccessContainer, structuralEqualityPolicy())
        internal set

    fun copy(
        primary: Color = this.primary,
        onPrimary: Color = this.onPrimary,
        primaryContainer: Color = this.primaryContainer,
        onPrimaryContainer: Color = this.onPrimaryContainer,
        inversePrimary: Color = this.inversePrimary,
        secondary: Color = this.secondary,
        onSecondary: Color = this.onSecondary,
        secondaryContainer: Color = this.secondaryContainer,
        onSecondaryContainer: Color = this.onSecondaryContainer,
        tertiary: Color = this.tertiary,
        onTertiary: Color = this.onTertiary,
        tertiaryContainer: Color = this.tertiaryContainer,
        onTertiaryContainer: Color = this.onTertiaryContainer,
        quaternary: Color = this.quaternary,
        onQuaternary: Color = this.onQuaternary,
        quaternaryContainer: Color = this.quaternaryContainer,
        onQuaternaryContainer: Color = this.onQuaternaryContainer,
        background: Color = this.background,
        onBackground: Color = this.onBackground,
        surface: Color = this.surface,
        onSurface: Color = this.onSurface,
        surfaceVariant: Color = this.surfaceVariant,
        onSurfaceVariant: Color = this.onSurfaceVariant,
        surfaceTint: Color = this.surfaceTint,
        inverseSurface: Color = this.inverseSurface,
        inverseOnSurface: Color = this.inverseOnSurface,
        error: Color = this.error,
        onError: Color = this.onError,
        errorContainer: Color = this.errorContainer,
        onErrorContainer: Color = this.onErrorContainer,
        outline: Color = this.outline,
        warning: Color = this.warning,
        onWarning: Color = this.onWarning,
        warningContainer: Color = this.warningContainer,
        onWarningContainer: Color = this.onWarningContainer,
        success: Color = this.success,
        onSuccess: Color = this.onSuccess,
        successContainer: Color = this.successContainer,
        onSuccessContainer: Color = this.onSuccessContainer,
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
}

internal fun SchectColorScheme.updateColorSchemeFrom(other: SchectColorScheme) {
    primary = other.primary
    onPrimary = other.onPrimary
    primaryContainer = other.primaryContainer
    onPrimaryContainer = other.onPrimaryContainer
    inversePrimary = other.inversePrimary
    secondary = other.secondary
    onSecondary = other.onSecondary
    secondaryContainer = other.secondaryContainer
    onSecondaryContainer = other.onSecondaryContainer
    tertiary = other.tertiary
    onTertiary = other.onTertiary
    tertiaryContainer = other.tertiaryContainer
    onTertiaryContainer = other.onTertiaryContainer
    quaternary = other.quaternary
    onQuaternary = other.onQuaternary
    quaternaryContainer = other.quaternaryContainer
    onQuaternaryContainer = other.onQuaternaryContainer
    background = other.background
    onBackground = other.onBackground
    surface = other.surface
    onSurface = other.onSurface
    surfaceVariant = other.surfaceVariant
    onSurfaceVariant = other.onSurfaceVariant
    surfaceTint = other.surfaceTint
    inverseSurface = other.inverseSurface
    inverseOnSurface = other.inverseOnSurface
    error = other.error
    onError = other.onError
    errorContainer = other.errorContainer
    onErrorContainer = other.onErrorContainer
    outline = other.outline
    warning = other.warning
    onWarning = other.onWarning
    warningContainer = other.warningContainer
    onWarningContainer = other.onWarningContainer
    success = other.success
    onSuccess = other.onSuccess
    successContainer = other.successContainer
    onSuccessContainer = other.onSuccessContainer
}

fun SchectColorScheme.contentColorFor(backgroundColor: Color): Color {
    return when (backgroundColor) {
        primary -> onPrimary
        primaryContainer -> onPrimaryContainer
        secondary -> onSecondary
        secondaryContainer -> onSecondaryContainer
        tertiary -> onTertiary
        tertiaryContainer -> onTertiaryContainer
        quaternary -> onQuaternary
        quaternaryContainer -> onQuaternaryContainer
        background -> onBackground
        surface -> onSurface
        surfaceVariant -> onSurfaceVariant
        inverseSurface -> inverseOnSurface
        error -> onError
        errorContainer -> onErrorContainer
        warning -> onWarning
        warningContainer -> onWarningContainer
        success -> onSuccess
        successContainer -> onSuccessContainer
        else -> Color.Unspecified
    }
}

@Composable
fun contentColorFor(backgroundColor: Color): Color {
    val color = UnityTheme.colorScheme.contentColorFor(backgroundColor)
    return if (color.isSpecified) color else LocalContentColor.current
}
