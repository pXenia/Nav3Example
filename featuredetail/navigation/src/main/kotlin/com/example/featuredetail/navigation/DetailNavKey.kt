package com.example.featuredetail.navigation

import androidx.navigation3.runtime.NavKey
import com.example.core.navigation.Navigator
import kotlinx.serialization.Serializable

@Serializable
data class DetailNavKey(val id: String) : NavKey

fun Navigator.navigateToDetail(id: String) {
    navigate(DetailNavKey(id))
}
