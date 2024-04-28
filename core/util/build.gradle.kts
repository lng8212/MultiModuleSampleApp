plugins {
    alias(libs.plugins.androidLibrary)
    alias(libs.plugins.jetbrainsKotlinAndroid)
    alias(libs.plugins.kotlinKapt)
    alias(libs.plugins.hiltGradle)
}

android {
    namespace = "com.longkd.core.util"
    compileSdk = 34

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
    composeOptions {
        kotlinCompilerExtensionVersion = "1.5.1"
    }
    buildFeatures {
        compose = true
    }
}

dependencies {
    implementation(libs.hilt.android)
    kapt(libs.hilt.compiler)
    implementation(libs.androidx.activity.compose)
    implementation(platform(libs.androidx.compose.bom))
}