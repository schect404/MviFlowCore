package com.atitto.mviflowarch.utils

import android.content.Context
import androidx.annotation.DrawableRes
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import coil.compose.rememberAsyncImagePainter
import coil.compose.rememberImagePainter
import coil.request.ImageRequest
import coil.size.Scale

@Composable
fun pictureOrDefault(
    context: Context,
    @DrawableRes defaultPicture: Int,
    pictureUrl: String?,
    scale: Scale = Scale.FIT,
): Painter =
    pictureUrl?.let { url ->
        rememberAsyncImagePainter(
            model = ImageRequest.Builder(context)
                .data(url)
                .crossfade(true)
                .placeholder(defaultPicture)
                .scale(scale)
        )
    } ?: painterResource(id = defaultPicture)