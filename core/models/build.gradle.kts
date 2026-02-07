plugins {
    alias(libs.plugins.android.library)
}

android {
    namespace = "com.example.core.models"

    compileSdk {
        version = release(36)
    }
}