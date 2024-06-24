package com.arjun.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.animation.ExperimentalSharedTransitionApi
import androidx.compose.animation.SharedTransitionLayout
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.arjun.presentation.dashboard.DashboardUi
import com.arjun.presentation.regime.RegimeUi
import com.arjun.presentation.regime.SupplementDetail
import com.arjun.presentation.theme.ProjectSerotoninTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    @OptIn(ExperimentalSharedTransitionApi::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ProjectSerotoninTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    SharedTransitionLayout {
                        val navController = rememberNavController()
                        NavHost(
                            navController = navController,
                            startDestination = "dashboard"
                        ) {
                            composable("dashboard") {
                                DashboardUi(
                                    viewModel = hiltViewModel(),
                                    modifier = Modifier.padding(innerPadding),
                                    onClick = {
                                        navController.navigate("regime")
                                    }
                                )
                            }

                            composable("regime") {
                                // regime screen
                                RegimeUi(
                                    animatedVisibilityScope = this,
                                    viewModel = hiltViewModel(),
                                    modifier = Modifier.padding(innerPadding),
                                    onItemClick = { code, productId ->
                                        navController.navigate("supplement_detail?code=$code&product_id=$productId")
                                    }
                                )
                            }

                            composable(
                                "supplement_detail?code={code}&product_id={product_id}",
                                arguments = listOf(
                                    navArgument("code") { type = NavType.StringType },
                                    navArgument("product_id") { type = NavType.StringType }
                                )
                            ) {
                                // supplement detail screen
                                val code = it.arguments?.getString("code")
                                val productId = it.arguments?.getString("product_id")
                                SupplementDetail(
                                    animatedVisibilityScope = this,
                                    code = code,
                                    productId = productId,
                                    viewModel = hiltViewModel(),
                                    modifier = Modifier.padding(innerPadding)
                                )
                            }
                        }
                    }
                }
            }
        }
    }
}
