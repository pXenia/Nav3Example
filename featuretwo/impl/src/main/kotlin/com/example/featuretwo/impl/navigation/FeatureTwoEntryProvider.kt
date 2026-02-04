package com.example.featuretwo.impl.navigation

import androidx.navigation3.runtime.EntryProviderScope
import androidx.navigation3.runtime.NavKey
import com.example.core.navigation.Navigator
import com.example.featuretwo.api.FeatureTwoNavKey
import com.example.featuretwo.impl.FeatureTwoScreen

/** Регистрирует сопоставление ключа с соответствующим экраном.*/
fun EntryProviderScope<NavKey>.featureTwoEntryBuilder(navigator: Navigator) {
    entry<FeatureTwoNavKey> {
        FeatureTwoScreen()
    }
}
