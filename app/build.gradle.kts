plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)
    alias(libs.plugins.kotlin.compose)
    alias(libs.plugins.daggerHilt)
    alias(libs.plugins.kotlin.serialization)
    kotlin("kapt")
}

android {
    namespace = "com.sujith.mybooksapidemo"
    compileSdk = 35

    defaultConfig {
        applicationId = "com.sujith.mybooksapidemo"
        minSdk = 24
        targetSdk = 35
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
    kotlinOptions {
        jvmTarget = "11"
    }
    buildFeatures {
        compose = true
    }
}

dependencies {

    implementation(project(":ui"))
    implementation(project(":data"))
    implementation(project(":domain"))
    //Core
    implementation(libs.bundles.core)
    implementation(platform(libs.androidx.compose.bom))
    //Retrofit
    implementation(libs.bundles.retrofit)
    //Hilt
    implementation(libs.bundles.hilt)
    kapt(libs.hilt.compiler)
    //Navigation
    implementation(libs.bundles.navigation)

}