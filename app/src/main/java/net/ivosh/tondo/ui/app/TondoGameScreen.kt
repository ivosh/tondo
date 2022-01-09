package net.ivosh.tondo.ui.app

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.layout.positionInParent
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import net.ivosh.tondo.ui.theme.TondoTheme

@Composable
fun TondoGameScreen(
    rotation: Float,
    updateRotation: (delta: Float) -> Unit,
    setPosition: (position: Offset, radius: Dp) -> Unit
) {
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceBetween
    ) {
        Box {}
        BoxWithConstraints {
            val targetWidth = maxWidth / 2
            Target(
                rotation,
                modifier = Modifier
                    .width(targetWidth)
                    .height(targetWidth)
                    .onGloballyPositioned { coordinates ->
                        setPosition.invoke(coordinates.positionInParent(), targetWidth / 4)
                    }
            )
        }
        TargetScrollable(onValueChange = { updateRotation(it) })
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewTondoGameScreen() {
    TondoTheme {
        var rotation by remember { mutableStateOf(125.0f) }
        TondoGameScreen(
            rotation = rotation,
            updateRotation = { rotation = it },
            setPosition = { _, _ -> run {} }
        )
    }
}
