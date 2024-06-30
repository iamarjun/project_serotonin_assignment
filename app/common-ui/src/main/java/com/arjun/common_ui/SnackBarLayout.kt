package com.arjun.common_ui

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.SnackbarData
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier

@Composable
fun SnackbarLayout(
    modifier: Modifier = Modifier,
    snackState: SnackbarHostState,
    content: @Composable () -> Unit,
    snackbarContent: @Composable (SnackbarData) -> Unit
) {

    Box(modifier = modifier.fillMaxSize()) {
        content()
        // Snackbar
        SnackbarHost(
            modifier = Modifier.align(Alignment.BottomStart),
            hostState = snackState
        ) { snackbarData: SnackbarData ->
            snackbarContent(snackbarData)
        }
    }
}