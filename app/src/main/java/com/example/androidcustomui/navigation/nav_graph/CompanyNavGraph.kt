package com.example.androidcustomui.navigation.nav_graph

import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.example.androidcustomui.model.screen_router.CompanyScreenRouter
import com.example.androidcustomui.ui.screen.TabCustomView

fun NavGraphBuilder.addCompanyGraph(
    modifier: Modifier = Modifier,
    navController: NavController
) {
    composable(CompanyScreenRouter.ROOT.route) {
        TabCustomView {
            navController.navigate(CompanyScreenRouter.DETAIL.route)
        }
    }
//    composable(CompanyScreenRouter.DETAIL.route) {
//        DetailScreen(from = CompanyScreenRouter.DETAIL.route) {
//            Button(onClick = {
//                navController.navigate(CompanyScreenRouter.DETAIL2.route)
//            }) {
//                Text("Move To Detail 2")
//            }
//        }
//    }

//    composable(CompanyScreenRouter.DETAIL2.route) {
//        DetailScreen(from = CompanyScreenRouter.DETAIL.route + "2")
//    }
}