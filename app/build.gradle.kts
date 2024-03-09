plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
    id("io.realm.kotlin")
//    id("org.jetbrains.kotlin.plugin.serialization")
    kotlin("plugin.serialization") version "1.9.23"
}

android {
    namespace = "com.example.todo"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.example.todo"
        minSdk = 24
        targetSdk = 34
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
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
    buildFeatures {
        buildConfig = true
        viewBinding = true
    }
}

dependencies {

    implementation("androidx.core:core-ktx:1.12.0")
    implementation("androidx.appcompat:appcompat:1.6.1")
    implementation("com.google.android.material:material:1.11.0")
    implementation("androidx.constraintlayout:constraintlayout:2.1.4")
    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.1.5")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")

    // logger
    implementation("com.jakewharton.timber:timber:5.0.1")


    // lifecycle ---------------------------------------------------------------------------------
    implementation("androidx.lifecycle:lifecycle-viewmodel-ktx:2.7.0")
//    implementation("androidx.lifecycle:lifecycle-livedata-ktx:2.7.0")
//    implementation("androidx.lifecycle:lifecycle-runtime-ktx:2.7.0")
//    implementation("androidx.lifecycle:lifecycle-viewmodel-savedstate:2.7.0")
//    implementation("androidx.lifecycle:lifecycle-common-java8:2.7.0")
    // -------------------------------------------------------------------------------------------

    // Koin for Android
    implementation("io.insert-koin:koin-android:3.5.3")
//    testImplementation("io.insert-koin:koin-test-junit4:3.5.3")

    // MMKV
    implementation("com.tencent:mmkv:1.3.3")

    // realm
    implementation("io.realm.kotlin:library-base:1.11.0")
//    implementation 'io.realm.kotlin:library-sync:1.11.0' // If using Device Sync
//    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.7.0") // If using coroutines with the SDK

    // serialization
    implementation("org.jetbrains.kotlinx:kotlinx-serialization-json:1.6.3")
    implementation("com.jakewharton.retrofit:retrofit2-kotlinx-serialization-converter:1.0.0")
    implementation("com.squareup.okhttp3:okhttp:4.11.0")

}