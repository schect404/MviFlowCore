package com.atitto.mviflowarch.theme

import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.unit.dp

val schectShapes = SchectShapes(
    extraSmall = RoundedCornerShape(size = 2.dp),
    small = RoundedCornerShape(size = 4.dp),
    medium = RoundedCornerShape(size = 9.dp),
    large = RoundedCornerShape(size = 16.dp),
    extraLarge = RoundedCornerShape(size = 28.dp),
)

val LocalReplacementShapes = staticCompositionLocalOf { schectShapes }
