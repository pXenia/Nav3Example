package com.example.featuretwo.impl.navigation

import androidx.navigation3.runtime.EntryProviderScope
import androidx.navigation3.runtime.NavKey
import com.example.featuretwo.api.SelectColorScreenNavKey
import com.example.featuretwo.impl.presentation.SelectColorScreen

fun EntryProviderScope<NavKey>.selectColorEntryBuilder() {
    entry<SelectColorScreenNavKey> {
        SelectColorScreen()
    }
}
