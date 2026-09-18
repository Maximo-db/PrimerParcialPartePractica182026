package com.uade.pokecompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.uade.pokecompose.ui.PokemonScreen
import com.uade.pokecompose.ui.theme.PokeComposeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            PokeComposeTheme {
                PokemonScreen()
            }
        }
    }
}
