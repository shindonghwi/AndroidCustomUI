package com.example.androidcustomui.model

import androidx.annotation.DrawableRes
import com.example.androidcustomui.R

enum class DockBarItem(
    val route: String,
    @DrawableRes val icon: Int
) {
    HOME("home", R.drawable.ic_dockbar_on_home),
    COMPANY("company", R.drawable.ic_dockbar_on_home),
}