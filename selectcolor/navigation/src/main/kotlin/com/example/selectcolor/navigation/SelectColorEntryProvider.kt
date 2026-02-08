package com.example.selectcolor.navigation

import androidx.navigation3.runtime.EntryProviderScope
import androidx.navigation3.runtime.NavKey
import com.example.featuretwo.impl.presentation.SelectColorScreen
import com.example.selectcolor.navigation.keys.SelectColorScreenNavKey

fun EntryProviderScope<NavKey>.selectColorEntryBuilder() {
    entry<SelectColorScreenNavKey> {
        SelectColorScreen()
    }
}
