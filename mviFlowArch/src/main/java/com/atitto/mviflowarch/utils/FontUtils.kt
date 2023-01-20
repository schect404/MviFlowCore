package com.atitto.mviflowarch.utils

import androidx.annotation.DimenRes
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.sp

@Composable
fun fontSizeOrDefault(fontSizeFloat: Float?, default: Int): TextUnit =
    fontSizeFloat?.sp ?: dimensionResource(id = default).value.sp

@Composable
fun fontSizeFromDimension(@DimenRes dimension: Int): TextUnit =
    dimensionResource(id = dimension).value.sp

