package com.atitto.mviflowarch.utils

import androidx.compose.animation.core.FastOutLinearInEasing
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.tween
import androidx.compose.runtime.Composable
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color

@Composable
fun loadingShimmerEffect(
    duration: Int = 2000,
    color: Color = Color.LightGray,
): Brush {

    val gradient = listOf(
        color.copy(alpha = 0.8f), // color with 80% opacity - darker
        color.copy(alpha = 0.35f), // color with 35% opacity - lighter
        color.copy(alpha = 0.8f)
    )

    // animate infinite times
    val transition = rememberInfiniteTransition()

    //animate the transition
    val translateAnimation = transition.animateFloat(
        initialValue = 0f,
        targetValue = 2000f,
        animationSpec = infiniteRepeatable(
            animation = tween(
                durationMillis = duration,
                easing = FastOutLinearInEasing
            )
        )
    )

    return Brush.linearGradient(
        colors = gradient,
        start = Offset(250f, 250f),
        end = Offset(
            x = translateAnimation.value,
            y = translateAnimation.value
        )
    )
}
