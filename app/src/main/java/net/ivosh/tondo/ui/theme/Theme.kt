package net.ivosh.tondo.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.MaterialTheme
import androidx.compose.material.darkColors
import androidx.compose.material.lightColors
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.Immutable
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.graphics.Color

@Immutable
data class TondoColors(
    val arcBlue: Color,
    val arcRed: Color,
    val arcYellow: Color,
    val sliderBarArrow: Color,
    val sliderBarBackground: Color
)

val LocalTondoColors = staticCompositionLocalOf {
    TondoColors(
        arcBlue = Color.Unspecified,
        arcRed = Color.Unspecified,
        arcYellow = Color.Unspecified,
        sliderBarArrow = Color.Unspecified,
        sliderBarBackground = Color.Unspecified
    )
}

private val lightColorPalette = lightColors(
    background = Background
)
private val darkColorPalette = darkColors()

private val tondoColorPalette = TondoColors(
    arcBlue = ArcBlue,
    arcRed = ArcRed,
    arcYellow = ArcYellow,
    sliderBarArrow = SliderBarArrow,
    sliderBarBackground = SliderBarBackground
)

@Composable
fun TondoTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {
    CompositionLocalProvider(LocalTondoColors provides tondoColorPalette) {
        MaterialTheme(
            colors = if (darkTheme) darkColorPalette else lightColorPalette,
            typography = typography,
            shapes = shapes,
            content = content
        )
    }
}

object TondoTheme {
    val colors: TondoColors
        @Composable
        get() = LocalTondoColors.current
}
