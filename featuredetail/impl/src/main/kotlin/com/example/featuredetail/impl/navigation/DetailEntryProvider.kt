package com.example.featuredetail.impl.navigation

import androidx.navigation3.runtime.EntryProviderScope
import androidx.navigation3.runtime.NavKey
import com.example.core.navigation.Navigator
import com.example.featuredetail.api.DetailNavKey
import com.example.featuredetail.impl.DetailScreen

fun EntryProviderScope<NavKey>.featureDetailEntryBuilder(navigator: Navigator) {
    entry<DetailNavKey> { key ->
        val id = key.id

        DetailScreen(
            id = id,
            onButtonBackClick = { navigator.goBack() }
        )
    }
}
