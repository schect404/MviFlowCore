package com.atitto.mviflowarch.theme

import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider

@Composable
fun SchectTheme(
    colorScheme: SchectColorScheme = UnityTheme.colorScheme,
    typography: SchectTypography = UnityTheme.typography,
    shapes: SchectShapes = UnityTheme.shapes,
    content: @Composable () -> Unit,
) {

    CompositionLocalProvider(
        LocalReplacementColors provides colorScheme,
        LocalReplacementTypography provides typography,
        LocalReplacementShapes provides shapes,
    ) {
        MaterialTheme(
            content = content
        )
    }

}

object UnityTheme {
    val colorScheme: SchectColorScheme
        @Composable
        get() = LocalReplacementColors.current
    val typography: SchectTypography
        @Composable
        get() = LocalReplacementTypography.current
    val shapes: SchectShapes
        @Composable
        get() = LocalReplacementShapes.current
}
