package net.ivosh.tondo.ui.app

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.tooling.preview.Preview
import net.ivosh.tondo.ui.theme.TondoTheme

@Composable
fun Target(rotation: Float, modifier: Modifier = Modifier) {
    val colorBlue = TondoTheme.colors.arcBlue
    val colorRed = TondoTheme.colors.arcRed
    val colorYellow = TondoTheme.colors.arcYellow

    Canvas(modifier) {
        val arcSize = Size(size.minDimension, size.minDimension)
        val topLeft = Offset(
            (size.width - size.minDimension) / 2,
            (size.height - size.minDimension) / 2
        )
        val startAngle = rotation

        drawArc(
            color = colorBlue,
            startAngle = startAngle,
            sweepAngle = 120f,
            useCenter = true,
            size = arcSize,
            topLeft = topLeft
        )
        drawArc(
            color = colorRed,
            startAngle = startAngle + 120f,
            sweepAngle = 120f,
            useCenter = true,
            size = arcSize,
            topLeft = topLeft
        )
        drawArc(
            color = colorYellow,
            startAngle = startAngle + 240f,
            sweepAngle = 120f,
            useCenter = true,
            size = arcSize,
            topLeft = topLeft
        )
    }
}

@Preview
@Composable
fun TargetPreview() {
    TondoTheme {
        Target(rotation = 125.0f, modifier = Modifier.fillMaxSize())
    }
}
