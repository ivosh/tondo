package net.ivosh.tondo.model

import androidx.lifecycle.ViewModel

class GameState : ViewModel() {
    val target: TargetState = TargetState()
}
