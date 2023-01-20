package com.atitto.mviflowarch.theme

import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.CornerBasedShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.shape.ZeroCornerSize
import androidx.compose.material3.Shapes
import androidx.compose.runtime.Immutable
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.unit.dp

@Immutable
class SchectShapes(
    val extraSmall: CornerBasedShape = RoundedCornerShape(size = 2.dp),
    val small: CornerBasedShape = RoundedCornerShape(size = 4.dp),
    val medium: CornerBasedShape = RoundedCornerShape(size = 9.dp),
    val large: CornerBasedShape = RoundedCornerShape(size = 16.dp),
    val extraLarge: CornerBasedShape = RoundedCornerShape(size = 28.dp)
) {

    companion object {
        /** A shape with no rounded corners (a rectangle shape). */
        val None = RoundedCornerShape(ZeroCornerSize)

        /** A shape with fully extended rounded corners (a circular shape). */
        val Full = CircleShape
    }

    /**
     * Returns a copy of this Shapes, optionally overriding some of the values.
     */
    fun copy(
        extraSmall: CornerBasedShape = this.extraSmall,
        small: CornerBasedShape = this.small,
        medium: CornerBasedShape = this.medium,
        large: CornerBasedShape = this.large,
        extraLarge: CornerBasedShape = this.extraLarge
    ): Shapes = Shapes(
        extraSmall = extraSmall,
        small = small,
        medium = medium,
        large = large,
        extraLarge = extraLarge
    )

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other !is Shapes) return false
        if (extraSmall != other.extraSmall) return false
        if (small != other.small) return false
        if (medium != other.medium) return false
        if (large != other.large) return false
        if (extraLarge != other.extraLarge) return false
        return true
    }

    override fun hashCode(): Int {
        var result = extraSmall.hashCode()
        result = 31 * result + small.hashCode()
        result = 31 * result + medium.hashCode()
        result = 31 * result + large.hashCode()
        result = 31 * result + extraLarge.hashCode()
        return result
    }

    override fun toString(): String =
        "Shapes(" +
                "extraSmall=$extraSmall, " +
                "small=$small, " +
                "medium=$medium, " +
                "large=$large, " +
                "extraLarge=$extraLarge)"
}
