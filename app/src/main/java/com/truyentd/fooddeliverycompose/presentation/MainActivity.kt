package com.truyentd.fooddeliverycompose.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.core.view.WindowCompat
import com.truyentd.fooddeliverycompose.navigation.FoodDeliveryNavHost
import com.truyentd.fooddeliverycompose.ui.theme.FoodDeliveryComposeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        WindowCompat.setDecorFitsSystemWindows(window, false)
        setContent {
            FoodDeliveryComposeTheme {
                FoodDeliveryNavHost()
            }
        }
    }
}
