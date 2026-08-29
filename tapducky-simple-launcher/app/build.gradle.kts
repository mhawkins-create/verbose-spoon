plugins {
    id("com.android.application")
}

android {
    namespace = "com.hawkins.tapducky.launcher"
    compileSdk = 37

    defaultConfig {
        applicationId = "com.hawkins.tapducky.launcher"
        minSdk = 24
        targetSdk = 37
        versionCode = 1
        versionName = "1.0.0"
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }

    buildTypes {
        release {
            isMinifyEnabled = false
        }
    }
}
