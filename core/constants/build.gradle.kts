plugins {
    alias(libs.plugins.android.library)
}

android {
    namespace = "com.example.core.constants"
    compileSdk = libs.versions.compileSdk.get().toInt()

    defaultConfig {
        minSdk = libs.versions.minSdk.get().toInt()
    }
}
