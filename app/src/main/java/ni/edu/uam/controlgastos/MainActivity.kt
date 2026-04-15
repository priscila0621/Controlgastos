package ni.edu.uam.controlgastos

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import ni.edu.uam.controlgastos.ui.screens.GastoScreen
import ni.edu.uam.controlgastos.ui.theme.AppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            AppTheme {
                GastoScreen()
            }
        }
    }
}