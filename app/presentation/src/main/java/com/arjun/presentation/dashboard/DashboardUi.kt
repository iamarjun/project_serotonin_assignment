package com.arjun.presentation.dashboard

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import coil.compose.AsyncImage
import com.arjun.domain.model.Product
import com.arjun.presentation.R

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun DashboardUi(
    viewModel: DashboardDtoViewModel,
    modifier: Modifier = Modifier,
    onClick: () -> Unit,
) {

    //hex for dark purple
    //0xFF673AB7
    //darker
    //0xFF311B92
    //darker
    //0xFF1A237E
    //darker
    //0xFF0D47A1

    val state by viewModel.state.collectAsStateWithLifecycle()

    Column(
        modifier = modifier
            .fillMaxSize()
            .background(Color(0xFF1A237E)),
        verticalArrangement = Arrangement.Center
    ) {
        // Display 10 items
        val pagerState = rememberPagerState(
            pageCount = { 2 }
        )
        HorizontalPager(
            modifier = Modifier.fillMaxWidth(),
            state = pagerState
        ) { page ->
            // Our page content
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(500.dp)
            ) {
                SupplementStack(
                    page = page,
                    products = if (page == 0) state.supplements else state.userAddedSupplement,
                    onClick = onClick
                )
            }
        }
    }

}

@Composable
private fun SupplementStack(page: Int, products: List<Product>, onClick: () -> Unit) {
    Card(
        Modifier
            .fillMaxWidth()
            .padding(horizontal = 12.dp),
        shape = RoundedCornerShape(5)

    ) {
        Column(modifier = Modifier.fillMaxWidth()) {
            CurrentSupplement(
                page = page,
                products = if (page == 0)
                    products
                else
                    products + products + Product(
                        id = "1",
                        productId = "1",
                        name = "Clean Hands",
                        status = "Active",
                        image = "https://www.iconsdb.com/icons/preview/purple/plus-4-xxl.png",
                        lastSyncedAt = "2021-02-08",
                        consumed = false,
                        brand = "Dettol"
                    ),
                onClick = onClick
            )
            if (page == 0) {
                UpcomingSupplement(listOf(products.random()))
            }
        }
    }

}

@OptIn(ExperimentalLayoutApi::class)
@Composable
private fun CurrentSupplement(
    page: Int,
    products: List<Product>,
    onClick: () -> Unit
) {
    val itemWidth = LocalConfiguration.current.screenWidthDp / 8
    Column(
        Modifier
            .fillMaxWidth()
            .background(Color.White)
            .padding(8.dp)

    ) {
        if (page > 0) {
            Text(text = "Additional Supplements")
            Spacer(modifier = Modifier.height(16.dp))
        }
        FlowRow(
            modifier = Modifier.fillMaxWidth(),
            verticalArrangement = Arrangement.spacedBy(10.dp)
        ) {
            products.forEach {
                AsyncImage(
                    model = it.image,
                    contentDescription = it.name,
                    modifier = Modifier.size(itemWidth.dp)
                )
            }
        }
        if (page == 0) {
            Spacer(modifier = Modifier.height(16.dp))
            Image(
                modifier = Modifier
                    .size(60.dp)
                    .background(Color(0xFF673AB7), shape = CircleShape)
                    .padding(10.dp)
                    .align(Alignment.End)
                    .clickable { onClick() },
                painter = painterResource(id = R.drawable.clean_hands),
                contentDescription = ""
            )
        }
    }
}

@OptIn(ExperimentalLayoutApi::class)
@Composable
fun UpcomingSupplement(products: List<Product>) {
    val itemWidth = LocalConfiguration.current.screenWidthDp / 8
    Column(
        Modifier
            .fillMaxWidth()
            .background(Color.LightGray.copy(alpha = 0.1f))
            .padding(8.dp)
    ) {
        val annotatedString = buildAnnotatedString {
            withStyle(style = SpanStyle(fontWeight = FontWeight.Bold)) {
                append("Upcoming Supplement ")
            }
            append("dispatching soon")
        }
        Text(text = annotatedString)
        Spacer(modifier = Modifier.height(8.dp))
        FlowRow(
            modifier = Modifier.fillMaxWidth(),
            verticalArrangement = Arrangement.spacedBy(10.dp)
        ) {
            products.forEach {
                AsyncImage(
                    model = it.image,
                    contentDescription = it.name,
                    modifier = Modifier.size(itemWidth.dp)
                )
            }
        }
    }
}


