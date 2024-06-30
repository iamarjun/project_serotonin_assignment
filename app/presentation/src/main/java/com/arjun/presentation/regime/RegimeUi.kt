package com.arjun.presentation.regime

import androidx.compose.animation.AnimatedVisibilityScope
import androidx.compose.animation.ExperimentalSharedTransitionApi
import androidx.compose.animation.SharedTransitionScope
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
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
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.KeyboardArrowRight
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Snackbar
import androidx.compose.material3.SnackbarDuration
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import coil.compose.AsyncImage
import com.arjun.common_ui.SnackbarLayout
import com.arjun.domain.model.ItemsToConsume
import com.arjun.domain.model.Product
import com.arjun.presentation.R
import kotlinx.coroutines.launch
import kotlin.random.Random

@OptIn(ExperimentalLayoutApi::class, ExperimentalSharedTransitionApi::class)
@Composable
fun SharedTransitionScope.RegimeUi(
    animatedVisibilityScope: AnimatedVisibilityScope,
    viewModel: RegimeViewModel,
    modifier: Modifier = Modifier,
    onItemClick: (String, String) -> Unit
) {
    val regimeUiState by viewModel.state.collectAsStateWithLifecycle()
    val scrollState = rememberScrollState()
    val context = LocalContext.current
    val rnd = Random
    val coroutineScope = rememberCoroutineScope()
    val snackState = remember { SnackbarHostState() }
    var currentSelectedProduct by remember { mutableStateOf<Product?>(null) }
    var currentSelecteditemToConsume by remember { mutableStateOf<ItemsToConsume?>(null) }

    SnackbarLayout(
        modifier = Modifier.fillMaxWidth(),
        snackState = snackState,
        content = {
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
                                        .clickable {
                                            coroutineScope.launch {
                                                snackState.showSnackbar(
                                                    message = "",
                                                    duration = SnackbarDuration.Long
                                                )
                                            }
                                            currentSelectedProduct = product
                                            currentSelecteditemToConsume = item
                                        }
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
        },
        snackbarContent = {
            currentSelectedProduct?.let { product ->
                currentSelecteditemToConsume?.let { item ->
                    CustomSnackBar(
                        product = product,
                        item = item,
                        animatedVisibilityScope = animatedVisibilityScope,
                        onItemClick = onItemClick
                    )
                }
            }
        }
    )
}

@OptIn(ExperimentalSharedTransitionApi::class)
@Composable
fun SharedTransitionScope.CustomSnackBar(
    animatedVisibilityScope: AnimatedVisibilityScope,
    product: Product,
    item: ItemsToConsume,
    onItemClick: (String, String) -> Unit
) {
    Snackbar(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp, vertical = 24.dp)
            .clickable {
                onItemClick(item.code, product.productId)
            },
        containerColor = Color(0xFF673AB7),
        shape = RoundedCornerShape(5)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(10.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            AsyncImage(
                modifier = Modifier
                    .size(60.dp)
                    .sharedElement(
                        state = rememberSharedContentState(key = product.productId),
                        animatedVisibilityScope = animatedVisibilityScope
                    ),
                model = product.image,
                contentDescription = product.productId
            )
            Spacer(modifier = Modifier.width(16.dp))
            Column(
                modifier = Modifier.weight(1f)
            ) { // Column to add padding
                Text(
                    text = "Added ${product.name} to your regime",
                    fontSize = 16.sp,
                    modifier = Modifier
                )
                Text(
                    text = "lorem ipsum dolor sit amet, consectetur adipiscing elit. Ut elit tellus, luctus nec ullamcorper mattis, pulvinar dapibus leo.",
                    fontSize = 12.sp,
                    color = Color.White
                )
            }
            Spacer(modifier = Modifier.width(16.dp))
            Image(
                modifier = Modifier
                    .size(24.dp),
                imageVector = Icons.AutoMirrored.Default.KeyboardArrowRight,
                contentDescription = "Close",
                colorFilter = ColorFilter.tint(Color.White)
            )
        }
    }
}