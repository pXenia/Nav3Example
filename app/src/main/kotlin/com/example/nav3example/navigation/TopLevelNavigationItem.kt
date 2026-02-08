package com.example.nav3example.navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Clear
import androidx.compose.material.icons.filled.Done
import androidx.compose.ui.graphics.vector.ImageVector
import com.example.featureone.navigation.keys.TasksListNavKey
import com.example.featuretwo.api.SelectColorScreenNavKey

/**
 * Элементы навигации верхнего уровня.
 * Элементы пользовательского интерфейса для Bottom Navigation.
 */
data class TopLevelNavigationItem(
    val icon: ImageVector,
    val title: String
)

val FEATURE_ONE = TopLevelNavigationItem(
    icon = Icons.Default.Done,
    title = "Feature One",
)

val FEATURE_TWO = TopLevelNavigationItem(
    icon = Icons.Default.Clear,
    title = "Feature Two",
)

val TOP_LEVEL_NAV_ITEMS = mapOf(
    TasksListNavKey to FEATURE_ONE,
    SelectColorScreenNavKey to FEATURE_TWO
)
