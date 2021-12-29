package net.ivosh.tondo.ui.shape

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.drawscope.rotate
import androidx.compose.ui.tooling.preview.Preview
import net.ivosh.tondo.ui.theme.TondoTheme

@Composable
fun Target(degrees: Float) {
    val colorBlue = TondoTheme.colors.arcBlue
    val colorRed = TondoTheme.colors.arcRed
    val colorYellow = TondoTheme.colors.arcYellow

    Canvas(modifier = Modifier.fillMaxSize()) {
        val arcSize = Size(size.minDimension / 2f, size.minDimension / 2f)

        rotate(degrees = degrees) {
            drawArc(
                color = colorBlue,
                startAngle = 0f,
                sweepAngle = 120f,
                useCenter = true,
                size = arcSize
            )
            drawArc(
                color = colorRed,
                startAngle = 120f,
                sweepAngle = 120f,
                useCenter = true,
                size = arcSize
            )
            drawArc(
                color = colorYellow,
                startAngle = 240f,
                sweepAngle = 120f,
                useCenter = true,
                size = arcSize
            )
        }
    }
}

@Preview(showBackground = true, heightDp = 600)
@Composable
fun DefaultPreview() {
    TondoTheme {
        Target(0.0f)
    }
}
