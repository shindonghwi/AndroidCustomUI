package com.example.androidcustomui.navigation.nav_graph

import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.example.androidcustomui.model.screen_router.HomeScreenRouter

fun NavGraphBuilder.addHomeGraph(
    modifier: Modifier = Modifier,
    navController: NavController
) {
    composable(HomeScreenRouter.ROOT.route) {
//        HomeScreen {
//            navController.navigate(HomeScreenRouter.DETAIL.route)
//        }
    }
    composable(HomeScreenRouter.DETAIL.route) {
//        DetailScreen(from = HomeScreenRouter.DETAIL.route)
    }
}