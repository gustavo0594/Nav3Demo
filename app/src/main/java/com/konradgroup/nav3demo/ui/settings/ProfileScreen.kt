package com.konradgroup.nav3demo.ui.settings

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier

@Composable
fun ProfileScreen(
    modifier: Modifier= Modifier,
) {
    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Gustavo Quesada",
            style = MaterialTheme.typography.headlineLarge
        )
        Text(
            text = "Android Developer",
            style = MaterialTheme.typography.bodyMedium
        )
    }
}