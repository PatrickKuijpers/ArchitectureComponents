package com.example.android.navigationadvancedsample

import androidx.annotation.DrawableRes
import androidx.annotation.IdRes
import androidx.annotation.StringRes
import com.example.android.navigationadvancedsample.BottomNavItem.Others

const val MAX_ITEMS_BOTTOM_NAV_BAR = 5

fun Array<BottomNavItem>.filterForBottomNavView(): List<IBottomNavItem> {
    val bottomNavItems = mutableListOf<IBottomNavItem>()
    var position = 1 // TODO: make position configurable
    forEach {
        if (position < MAX_ITEMS_BOTTOM_NAV_BAR && it != Others && it.isFeatureEnabled) {
            bottomNavItems.add(it)
            position++
        }
    }
    // TODO: add an overflow item (maybe we can use menu.addSubMenu?)
//    bottomNavItems.add(Others.navGraphLayoutId)
    return bottomNavItems
}

enum class BottomNavItem(
    @StringRes override val titleRes: Int,
    @DrawableRes override val iconRes: Int,
    @IdRes override val navGraphLayoutId: Int,
    val isFeatureEnabled: Boolean = true
) : IBottomNavItem { // The order of enums is the default order in which they are shown (when the  order isn't configured), apart from hidden items etc.
    Home(R.string.title_home, R.drawable.ic_home, R.navigation.home),
    List(R.string.title_list, R.drawable.ic_list, R.navigation.list),
    Form(R.string.title_register, R.drawable.ic_feedback, R.navigation.form),
    Disabled(R.string.title_disabled, R.drawable.ic_home, R.navigation.home, false), // testing a disabled item (should not be added to the bottomNavBar)
    Others(R.string.title_others, R.drawable.ic_list, R.navigation.list); // TODO: create an overflow item
}
