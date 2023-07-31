package com.truyentd.fooddeliverycompose.navigation

import androidx.compose.animation.AnimatedContentTransitionScope
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.truyentd.fooddeliverycompose.presentation.DemoScreen
import com.truyentd.fooddeliverycompose.presentation.cart.CartScreen
import com.truyentd.fooddeliverycompose.presentation.detail.RestaurantDetailScreen
import com.truyentd.fooddeliverycompose.presentation.home.HomeScreen

@Composable
fun FoodDeliveryNavHost(
    navController: NavHostController = rememberNavController(),
    startDestination: String = "demo",
) {
    NavHost(
        navController = navController,
        startDestination = startDestination,
        enterTransition = {
            slideIntoContainer(
                towards = AnimatedContentTransitionScope.SlideDirection.Left,
                animationSpec = tween(400),
                initialOffset = { fullWidth ->
                    fullWidth / 2
                }
            ).plus(fadeIn(tween(400)))
        },
        exitTransition = {
            slideOutOfContainer(
                towards = AnimatedContentTransitionScope.SlideDirection.Left,
                animationSpec = tween(400),
                targetOffset = { fullWidth -> fullWidth / 2 }
            ).plus(fadeOut(tween(400)))
        },
        popEnterTransition = {
            slideIntoContainer(
                towards = AnimatedContentTransitionScope.SlideDirection.Right,
                animationSpec = tween(400),
                initialOffset = { fullWidth -> fullWidth / 2 }
            ).plus(fadeIn(tween(400)))
        },
        popExitTransition = {
            slideOutOfContainer(
                towards = AnimatedContentTransitionScope.SlideDirection.Right,
                animationSpec = tween(400),
                targetOffset = { fullWidth -> fullWidth / 2 }
            ).plus(fadeOut(tween(400)))
        }
    ) {
        composable(route = "home") {
            HomeScreen {
                navController.navigate("restaurant")
            }
        }
        composable("cart") { CartScreen() }
        composable(
            route = "restaurant",
        ) {
            RestaurantDetailScreen {
                navController.navigateUp()
            }
        }
        composable("demo") { DemoScreen() }
    }
}
