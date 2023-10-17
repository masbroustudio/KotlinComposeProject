package com.yudhae.submissioncompose.core.components

import androidx.compose.foundation.layout.Row
import androidx.compose.material.Icon
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Star
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import com.yudhae.submissioncompose.R
import kotlin.math.ceil
import kotlin.math.floor


@Composable
fun RatingBar(
    modifier: Modifier = Modifier,
    rating: Double = 0.0,
    stars: Int = 5,
    starsColor: Color = Color.Yellow,
) {
    val ratingbarHalfStar = rating / 2.0
    val filledStars = floor(ratingbarHalfStar).toInt()
    val unfilledStars = (stars - ceil(ratingbarHalfStar)).toInt()
    val halfStar = !(ratingbarHalfStar.rem(1).equals(0.0))

    Row(modifier = modifier) {
        repeat(filledStars) {
            Icon(imageVector = Icons.Outlined.Star, contentDescription = null, tint = starsColor)
        }

        if (halfStar) {
            Icon(
                imageVector = ImageVector.vectorResource(id = R.drawable.baseline_star_half),
                contentDescription = null,
                tint = starsColor
            )
        }

        repeat(unfilledStars) {
            Icon(
                imageVector = ImageVector.vectorResource(id = R.drawable.baseline_star_outline_24),
                contentDescription = null,
                tint = starsColor
            )
        }
    }
}