package net.ivosh.tondo

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import net.ivosh.tondo.model.GameState
import net.ivosh.tondo.ui.app.TondoGameScreen
import net.ivosh.tondo.ui.theme.TondoTheme

class MainActivity : ComponentActivity() {
    private val gameState by viewModels<GameState>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TondoTheme {
                Surface(color = MaterialTheme.colors.background) {
                    TondoGameActivity(gameState)
                }
            }
        }
    }
}

@Composable
fun TondoGameActivity(gameState: GameState) {
    TondoGameScreen(
        rotation = gameState.target.rotation,
        updateRotation = gameState.target::updateRotation,
        setPosition = gameState.target::setPosition
    )
}
