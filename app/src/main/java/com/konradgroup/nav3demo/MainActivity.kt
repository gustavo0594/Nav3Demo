package com.konradgroup.nav3demo

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import com.konradgroup.nav3demo.ui.navigation.NavigationRoot
import com.konradgroup.nav3demo.ui.pokemons.list.PokemonListScreen
import com.konradgroup.nav3demo.ui.theme.Nav3DemoTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Nav3DemoTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    NavigationRoot(
                        modifier = Modifier.padding(innerPadding),
                    )
                }
            }
        }
    }
}

