package com.example.androidcustomui

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navigation
import com.example.androidcustomui.model.DockBarItem
import com.example.androidcustomui.model.screen_router.CompanyScreenRouter
import com.example.androidcustomui.model.screen_router.HomeScreenRouter
import com.example.androidcustomui.navigation.nav_graph.addCompanyGraph
import com.example.androidcustomui.navigation.nav_graph.addHomeGraph

/** 화면 */
@Composable
fun WolfAppNavGraph(
    modifier: Modifier = Modifier,
    navController: NavHostController = rememberNavController(),
    startDestination: String = DockBarItem.HOME.route,
    paddingValues: PaddingValues
) {
    NavHost(
        navController = navController,
        startDestination = startDestination,
        modifier = modifier.padding(bottom = paddingValues.calculateBottomPadding())
    ) {
        navigation(
            route = DockBarItem.HOME.route,
            startDestination = HomeScreenRouter.ROOT.route,
        ) {
            addHomeGraph(modifier, navController)
        }

        navigation(
            route = DockBarItem.COMPANY.route,
            startDestination = CompanyScreenRouter.ROOT.route,
        ) {
            addCompanyGraph(modifier, navController)
        }
    }
}