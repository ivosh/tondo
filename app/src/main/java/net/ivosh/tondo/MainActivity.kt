package net.ivosh.tondo

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import net.ivosh.tondo.model.GameViewModel
import net.ivosh.tondo.ui.app.TondoGameScreen
import net.ivosh.tondo.ui.theme.TondoTheme

class MainActivity : ComponentActivity() {
    val gameViewModel by viewModels<GameViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TondoTheme {
                Surface(color = MaterialTheme.colors.background) {
                    TondoGameActivity(gameViewModel)
                }
            }
        }
    }
}

@Composable
fun TondoGameActivity(gameViewModel: GameViewModel) {
    TondoGameScreen(
        rotation = gameViewModel.target.rotation,
        updateRotation = gameViewModel.target::updateRotation,
        setPosition = gameViewModel.target::setPosition
    )
}
