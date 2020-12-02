package com.example.android.navigationadvancedsample

import android.view.Menu
import androidx.annotation.DrawableRes
import androidx.annotation.IdRes
import androidx.annotation.StringRes
import com.example.android.navigationadvancedsample.BottomNavItem.Others
import com.google.android.material.bottomnavigation.BottomNavigationView

const val MAX_ITEMS_BOTTOM_NAV_BAR = 5

fun BottomNavigationView.setupItems(): MutableList<Int> {
    val addedNavGraphIds = mutableListOf<Int>()
    var position = 1 // TODO: make position configurable
    BottomNavItem.values().forEach {
        if (position < MAX_ITEMS_BOTTOM_NAV_BAR && it != Others && it.isFeatureEnabled) {
            addBottomNavigationItem(it, position, addedNavGraphIds)
            position++
        }
    }
    // TODO: add an overflow item (maybe we can use menu.addSubMenu?)
    //  addBottomNavigationItem(Others, position, navGraphIds)
    return addedNavGraphIds
}

private fun BottomNavigationView.addBottomNavigationItem(item: BottomNavItem, position: Int, navGraphIds: MutableList<Int>) {
    menu.add(Menu.NONE, item.navGraphId, position, item.textRes).setIcon(item.iconRes)
    navGraphIds.add(item.navGraphLayoutId)
}

enum class BottomNavItem(
    @StringRes val textRes: Int,
    @DrawableRes val iconRes: Int,
    @IdRes val navGraphLayoutId: Int,
    @IdRes val navGraphId: Int,
    val isFeatureEnabled: Boolean = true
) { // The order of enums is the default order in which they are shown (when the  order isn't configured), apart from hidden items etc.
    Home(R.string.title_home, R.drawable.ic_home, R.navigation.home, R.id.home),
    List(R.string.title_list, R.drawable.ic_list, R.navigation.list, R.id.list),
    Form(R.string.title_register, R.drawable.ic_feedback, R.navigation.form, R.id.form),
    Disabled(R.string.title_disabled, R.drawable.ic_home, R.navigation.home, R.id.home, false), // testing a disabled item (should not be added to the bottomNavBar)
    Others(R.string.title_others, R.drawable.ic_list, R.navigation.list, R.id.list); // TODO: create an overflow item

    val id = ordinal // Ordinal is a unique id
}
