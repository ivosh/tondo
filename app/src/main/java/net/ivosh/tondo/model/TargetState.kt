package net.ivosh.tondo.model

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

class TargetState() {
    var rotation by mutableStateOf(0.0f)
        private set
    private var position: Offset = Offset.Unspecified
    private var radius = 300.dp

    fun updateRotation(delta: Float) {
        val update = (delta * 360).toInt() % 360.0f
        rotation += update
    }

    fun setPosition(position: Offset, radius: Dp) {
        this.position = position
        this.radius = radius
    }
}
