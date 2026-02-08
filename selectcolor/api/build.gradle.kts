plugins {
    alias(libs.plugins.android.library)
    alias(libs.plugins.jetbrains.kotlin.serialization)
}

android {
    namespace = "com.example.selectcolor.api"

    compileSdk {
        version = release(36)
    }
}

dependencies {
    implementation(libs.androidx.navigation3.runtime)
}