package com.longkd.multimodulesampleapp.main

import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.longkd.feature.message.ui.MessageRoute

/**
 * @Author: longkd
 * @Since: 17:13 - 28/04/2024
 */

@Composable
fun MainNavigation() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = "main") {
        composable("main") {
            MessageRoute(modifier = Modifier.padding(16.dp))
        }
    }
}