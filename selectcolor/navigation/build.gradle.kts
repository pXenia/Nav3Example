plugins {
    alias(libs.plugins.android.library)
    alias(libs.plugins.jetbrains.kotlin.serialization)
    alias(libs.plugins.kotlin.compose)
    alias(libs.plugins.ksp)
    alias(libs.plugins.hilt.android)
}

android {
    namespace = "com.example.selectcolor.navigation"

    compileSdk {
        version = release(36)
    }

    buildFeatures {
        compose = true
    }
}

dependencies {
    implementation(libs.androidx.navigation3.ui)
    implementation(libs.androidx.navigation3.runtime)
    implementation(libs.hilt.android)
    implementation(libs.androidx.hilt.navigation.compose)
    implementation(libs.androidx.lifecycle.viewmodel.navigation3)
    ksp(libs.hilt.compiler)
    implementation(project(":core:navigation"))
    implementation(project(":selectcolor:impl"))
}