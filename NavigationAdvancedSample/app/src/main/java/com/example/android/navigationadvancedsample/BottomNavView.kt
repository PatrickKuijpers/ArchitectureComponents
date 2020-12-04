package com.example.android.navigationadvancedsample

import androidx.annotation.DrawableRes
import androidx.annotation.IdRes
import androidx.annotation.StringRes
import com.example.android.navigationadvancedsample.Feature.Others

const val MAX_ITEMS_BOTTOM_NAV_BAR = 5

fun Array<Feature>.filterForBottomNavView(): List<BottomNavItem> {
    val bottomNavItems = mutableListOf<BottomNavItem>()
    forEachIndexed { index, feature ->
        val position = index - 1
        if (position < MAX_ITEMS_BOTTOM_NAV_BAR && feature != Others && feature.isFeatureEnabled) {
            bottomNavItems.add(feature.toBottomNavItem())
        }
    }
    // TODO: add an overflow item (maybe we can use menu.addSubMenu?)
    // bottomNavItems.add(Others.toBottomNavItem())
    return bottomNavItems
}

enum class Feature(
    @IdRes val navGraphLayoutId: Int,
    @StringRes val titleRes: Int,
    @DrawableRes val iconRes: Int,
    val isFeatureEnabled: Boolean = true
) { // The order of enums is the default order in which they are shown (when the  order isn't configured), apart from hidden items etc.
    Home(R.navigation.home, R.string.title_home, R.drawable.ic_home),
    List(R.navigation.person, R.string.title_list, R.drawable.ic_list),
    Form(R.navigation.form, R.string.title_register, R.drawable.ic_feedback),
    DynamicModule(R.navigation.dynamiclist, R.string.title_dynamicfeature1, R.drawable.ic_list),
    Disabled(R.navigation.home, R.string.title_disabled, R.drawable.ic_home, false), // testing a disabled item (should not be added to the bottomNavBar)
    Others(R.navigation.person, R.string.title_others, R.drawable.ic_list); // TODO: create an overflow item

    fun toBottomNavItem() = BottomNavItem(navGraphLayoutId, titleRes, iconRes)
}
