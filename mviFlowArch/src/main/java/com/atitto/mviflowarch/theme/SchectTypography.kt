package com.atitto.mviflowarch.theme

import androidx.compose.runtime.Immutable
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp

@Immutable
class SchectTypography(
    val h1: TextStyle = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.SemiBold,
        fontSize = 20.sp,
        lineHeight = 24.sp,
    ),
    val h2: TextStyle = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.SemiBold,
        fontSize = 18.sp,
        lineHeight = 22.sp,
    ),
    val h3: TextStyle = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.SemiBold,
        fontSize = 16.sp,
        lineHeight = 20.sp,
    ),
    val h4: TextStyle = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.SemiBold,
        fontSize = 14.sp,
        lineHeight = 16.sp,
    ),
    val h4Light: TextStyle = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Light,
        fontSize = 14.sp,
        lineHeight = 16.sp,
    ),
    val h4Normal: TextStyle = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Normal,
        fontSize = 14.sp,
        lineHeight = 16.sp,
    ),
    val h5: TextStyle = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.SemiBold,
        fontSize = 12.sp,
        lineHeight = 16.sp,
    ),
    val bodyLarge: TextStyle = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Normal,
        fontSize = 16.sp,
        lineHeight = 18.sp,
    ),
    val bodyStandard: TextStyle = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Normal,
        fontSize = 10.sp,
        lineHeight = 12.sp,
    ),
    val bodySmall: TextStyle = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Normal,
        fontSize = 12.sp,
        lineHeight = 16.sp,
    ),
    val button: TextStyle = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.SemiBold,
        fontSize = 16.sp,
        lineHeight = 20.sp,
    ),
) {

    /**
     * Returns a copy of this UnityTypography, optionally overriding some of the values.
     */
    fun copy(
        h1: TextStyle = this.h1,
        h2: TextStyle = this.h2,
        h3: TextStyle = this.h3,
        h4: TextStyle = this.h4,
        h4Light: TextStyle = this.h4Light,
        h4Normal: TextStyle = this.h4Normal,
        h5: TextStyle = this.h5,
        bodyLarge: TextStyle = this.bodyLarge,
        bodyStandard: TextStyle = this.bodyStandard,
        bodySmall: TextStyle = this.bodySmall,
        button: TextStyle = this.button,
    ): SchectTypography = SchectTypography(
        h1 = h1,
        h2 = h2,
        h3 = h3,
        h4 = h4,
        h4Light = h4Light,
        h4Normal = h4Normal,
        h5 = h5,
        bodyLarge = bodyLarge,
        bodyStandard = bodyStandard,
        bodySmall = bodySmall,
        button = button,
    )

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other !is SchectTypography) return false

        if (h1 != other.h1) return false
        if (h2 != other.h2) return false
        if (h3 != other.h3) return false
        if (h4 != other.h4) return false
        if (h5 != other.h5) return false
        if (h4Light != other.h4Light) return false
        if (h4Normal != other.h4Normal) return false
        if (bodyLarge != other.bodyLarge) return false
        if (bodyStandard != other.bodyStandard) return false
        if (bodySmall != other.bodySmall) return false
        if (button != other.button) return false

        return true
    }

    override fun hashCode(): Int {
        var result = h1.hashCode()
        result = 31 * result + h2.hashCode()
        result = 31 * result + h3.hashCode()
        result = 31 * result + h4.hashCode()
        result = 31 * result + h5.hashCode()
        result = 31 * result + bodyLarge.hashCode()
        result = 31 * result + bodyStandard.hashCode()
        result = 31 * result + bodySmall.hashCode()
        result = 31 * result + button.hashCode()
        return result
    }

    override fun toString(): String {
        return "Typography(h1=$h1, h2=$h2, h3=$h3, h4=$h4, h5=$h5, " +
                "bodyLarge=$bodyLarge, bodyStandard=$bodyStandard, +" +
                "bodySmall=$bodySmall, button=$button)"
    }
}
