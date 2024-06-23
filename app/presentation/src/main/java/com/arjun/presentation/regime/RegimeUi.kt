package com.arjun.presentation.regime

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import coil.compose.AsyncImage
import com.arjun.presentation.R
import kotlin.random.Random

@OptIn(ExperimentalLayoutApi::class)
@Composable
fun RegimeUi(
    viewModel: RegimeViewModel,
    modifier: Modifier = Modifier
) {
    val regimeUiState by viewModel.state.collectAsStateWithLifecycle()
    val scrollState = rememberScrollState()
    val rnd = Random

    Column(
        modifier = modifier
            .fillMaxSize()
            .verticalScroll(scrollState)
    ) {
        regimeUiState.regime?.items?.forEach { item ->
            val color = Color(rnd.nextInt(256), rnd.nextInt(256), rnd.nextInt(256), 15)
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(color)
                    .padding(horizontal = 16.dp)
            ) {
                Text(
                    text = item.title,
                    fontSize = 26.sp,
                )
                FlowRow(
                    modifier = modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.spacedBy(8.dp),
                    verticalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    item.products.forEach { product ->
                        Box(
                            modifier = Modifier
                                .clip(RoundedCornerShape(50))
                                .background(Color.White)
                                .padding(10.dp)
                        ) {
                            AsyncImage(
                                modifier = Modifier
                                    .height(150.dp)
                                    .width(50.dp)
                                    .align(Alignment.Center)
                                    .padding(vertical = 15.dp),
                                contentScale = ContentScale.Crop,
                                model = product.image,
                                contentDescription = product.productId
                            )

                            Box(
                                modifier = Modifier
                                    .size(50.dp)
                                    .align(Alignment.BottomCenter)
                                    .clip(CircleShape)
                                    .background(Color.White),
                                contentAlignment = Alignment.Center
                            ) {
                                CircularProgressIndicator(
                                    progress = { 0.74f },
                                    color = Color.Green,
                                    strokeWidth = 3.dp,
                                )
                                Image(
                                    modifier = Modifier
                                        .size(35.dp),
                                    painter = painterResource(id = R.drawable.check),
                                    contentDescription = "",
                                    colorFilter = ColorFilter.tint(Color.Green)
                                )
                            }
                        }
                    }
                }
            }
        }
    }
}