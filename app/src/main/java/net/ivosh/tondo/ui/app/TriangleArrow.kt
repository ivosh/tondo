package net.ivosh.tondo.ui.shape

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.GenericShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import net.ivosh.tondo.ui.theme.TondoTheme

@Composable
fun TriangleArrow(pointLeft: Boolean, modifier: Modifier = Modifier) {
    val color = TondoTheme.colors.sliderBarArrow
    Box(
        modifier
            .size(50.dp, 56.dp)
            .padding(horizontal = 10.dp)
            .border(4.dp, color, if (pointLeft) LeftTriangleShape else RightTriangleShape)
    )
}

@Preview
@Composable
fun TriangleArrowPreview() {
    TondoTheme {
        Row(horizontalArrangement = Arrangement.SpaceEvenly) {
            TriangleArrow(pointLeft = true)
            Spacer(modifier = Modifier.width(20.dp))
            TriangleArrow(pointLeft = false)
        }
    }
}

val LeftTriangleShape = GenericShape { size, _ ->
    moveTo(0f, size.height / 2f)
    lineTo(size.width, 0f)
    lineTo(size.width, size.height)
}

val RightTriangleShape = GenericShape { size, _ ->
    moveTo(0f, 0f)
    lineTo(size.width, size.height / 2f)
    lineTo(0f, size.height)
}
