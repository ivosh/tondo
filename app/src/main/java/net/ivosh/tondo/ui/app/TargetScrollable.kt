package net.ivosh.tondo.ui.app

import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.Orientation
import androidx.compose.foundation.gestures.rememberScrollableState
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.toSize
import net.ivosh.tondo.ui.theme.TondoTheme

@Composable
fun TargetScrollable(
    onValueChange: (value: Float) -> Unit,
    modifier: Modifier = Modifier,
    displayRatio: Boolean = false,
) {
    val arrowColor = TondoTheme.colors.sliderBarArrow
    val backgroundColor = TondoTheme.colors.sliderBarBackground

    var ratio by remember { mutableStateOf(0f) }
    var size by remember { mutableStateOf(Size.Zero) }

    Box {
        Box(
            modifier
                .fillMaxWidth()
                .height(50.dp)
                .background(backgroundColor)
                .onGloballyPositioned { coordinates ->
                    size = coordinates.size.toSize()
                }
                .scrollable(
                    orientation = Orientation.Horizontal,
                    state = rememberScrollableState { delta ->
                        ratio = delta / size.width
                        onValueChange.invoke(ratio)
                        delta
                    }
                )
        )
        if (displayRatio) {
            Text(text = "$ratio", modifier = Modifier.background(arrowColor))
        }
    }
}

@Preview(showBackground = true)
@Composable
fun TargetScrollablePreview() {
    TondoTheme {
        TargetScrollable(onValueChange = { }, displayRatio = true)
    }
}
