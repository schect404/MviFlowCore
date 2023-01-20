package com.atitto.mviflowarch.utils

import androidx.annotation.ColorRes
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.core.graphics.toColorInt

@Composable
fun colorOrDefault(colorString: String?, default: Int): Color =
    colorString?.let { Color(it.toColorInt()) } ?: colorResource(id = default)

@Composable
fun colorWhenSelected(
    isSelected: Boolean,
    @ColorRes default: Int,
    @ColorRes selected: Int,
): Color = if (isSelected) colorResource(id = selected) else colorResource(id = default)
