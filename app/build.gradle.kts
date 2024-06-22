plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.jetbrains.kotlin.android)
    alias(libs.plugins.compose.compiler)
    alias(libs.plugins.hilt.android.gradle.plugin)
    kotlin("kapt")
}

android {
    namespace = "com.arjun.project_serotonin"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.arjun.project_serotonin"
        minSdk = 29
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        vectorDrawables {
            useSupportLibrary = true
        }
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
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
    buildFeatures {
        compose = true
    }
    packaging {
        resources.excludes.apply {
            add("META-INF/jersey-module-version")
        }
    }
}

dependencies {

    implementation(project(":app:data"))
    implementation(project(":app:domain"))
    implementation(project(":app:presentation"))

    implementation(libs.hilt.core)
    implementation(libs.hilt.android)
    kapt(libs.hilt.android.compiler)

    implementation(libs.androidx.runtime)
}