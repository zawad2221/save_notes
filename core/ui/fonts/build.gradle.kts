plugins {
    alias(libs.plugins.android.library)
}

android {
    namespace = "com.example.core.ui.fonts"
    compileSdk = libs.versions.compileSdk.get().toInt()

    defaultConfig {
        minSdk = libs.versions.minSdk.get().toInt()
        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }
}
