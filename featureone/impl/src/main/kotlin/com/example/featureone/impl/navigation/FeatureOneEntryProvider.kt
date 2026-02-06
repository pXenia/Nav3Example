package com.example.featureone.impl.navigation

import androidx.navigation3.runtime.EntryProviderScope
import androidx.navigation3.runtime.NavKey
import com.example.core.navigation.Navigator
import com.example.featuredetail.navigation.navigateToTaskDetail
import com.example.featureone.api.FeatureOneNavKey
import com.example.featureone.impl.presentation.FeatureOneScreen

/** Регистрирует сопоставление ключа с соответствующим экраном.*/
fun EntryProviderScope<NavKey>.featureOneEntryBuilder(navigator: Navigator) {
    entry<FeatureOneNavKey> {
        FeatureOneScreen(
            onItemClick = navigator::navigateToTaskDetail,
        )
    }
}
