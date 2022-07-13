package com.example.androidcustomui

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.androidcustomui.model.DockBarItem
import com.example.androidcustomui.navigation.BottomNavigationBar
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun WolfApp() {
    val navController = rememberNavController()
    val bottomBarState = rememberSaveable { (mutableStateOf(true)) }

    BottomNavigationVisibleState(navController = navController, bottomBarState = bottomBarState)

    Scaffold(
        bottomBar = {
            BottomNavigationBar(
                navController = navController,
                bottomBarState = bottomBarState
            )
        }
    ) { innerPadding ->
        WolfAppNavGraph(navController = navController, paddingValues = innerPadding)
    }
}

@Composable
private fun BottomNavigationVisibleState(
    navController: NavHostController,
    bottomBarState: MutableState<Boolean>
) {
    val scope = rememberCoroutineScope()

    navController.currentBackStackEntryFlow.let { backStackFlow ->
        LaunchedEffect(backStackFlow) {
            scope.launch {
                backStackFlow.collect {
                    when (it.destination.route.toString().replace("/", "")) {
                        DockBarItem.HOME.route,
                        DockBarItem.COMPANY.route -> {
                            println("If -> HOME || COMPANY CLICK")
                        }
                        else -> {
                            println("Else -> HOME || COMPANY CLICK")
                        }
                    }
                }
            }
        }
    }
}