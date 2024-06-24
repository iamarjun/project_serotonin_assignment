package com.arjun.presentation.regime

import androidx.compose.animation.AnimatedVisibilityScope
import androidx.compose.animation.ExperimentalSharedTransitionApi
import androidx.compose.animation.SharedTransitionScope
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import coil.compose.AsyncImage

@OptIn(ExperimentalSharedTransitionApi::class)
@Composable
fun SharedTransitionScope.SupplementDetail(
    animatedVisibilityScope: AnimatedVisibilityScope,
    code: String?,
    productId: String?,
    viewModel: RegimeViewModel,
    modifier: Modifier = Modifier
) {

    LaunchedEffect(key1 = Unit) {
        viewModel.getProduct(code, productId)
    }

    val state by viewModel.product.collectAsStateWithLifecycle()

    if (state.product != null) {
        Box(
            modifier = modifier
                .fillMaxSize()
                .background(Color(0xFF1A237E))
                .padding(horizontal = 16.dp),
        ) {
            LinearProgressIndicator(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 24.dp),
                progress = { 0.5f }
            )

            val screenWidth = LocalConfiguration.current.screenWidthDp

            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .align(Alignment.Center),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Box(modifier = Modifier) {
                    AsyncImage(
                        modifier = Modifier
                            .sharedElement(
                                state = rememberSharedContentState(key = state.product?.productId!!),
                                animatedVisibilityScope = animatedVisibilityScope
                            )
                            .width((0.50f * screenWidth).dp)
                            .aspectRatio(1f)
                            .clip(CircleShape),
                        model = state.product?.image,
                        contentDescription = ""
                    )
                }
            }
        }
    }
}