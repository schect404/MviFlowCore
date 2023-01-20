package com.atitto.mviflowarch.theme

import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider

@Composable
fun SchectTheme(
    colorScheme: SchectColorScheme = SchectTheme.colorScheme,
    typography: SchectTypography = SchectTheme.typography,
    shapes: SchectShapes = SchectTheme.shapes,
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

object SchectTheme {
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
