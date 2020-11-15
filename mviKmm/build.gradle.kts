plugins {
    id("com.android.library")
    kotlin("multiplatform")
    id("kotlin-android-extensions")
}

repositories {
    gradlePluginPortal()
    google()
    jcenter()
    mavenCentral()
    maven {
        url = uri("https://dl.bintray.com/kotlin/kotlin-eap")
    }
}
kotlin {
    android()

    sourceSets["commonMain"].dependencies {
        api("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.4.0")
    }

    sourceSets["androidMain"].dependencies {
        implementation("androidx.core:core-ktx:1.3.2")
        api("androidx.viewpager2:viewpager2:1.0.0")
        api("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.4.0")
        api("org.jetbrains.kotlinx:kotlinx-coroutines-android:1.3.9")
        api("androidx.lifecycle:lifecycle-viewmodel-ktx:2.3.0-beta01")
        api("androidx.lifecycle:lifecycle-runtime-ktx:2.3.0-beta01")
        api("androidx.lifecycle:lifecycle-extensions:2.2.0")
        api("xyz.peridy.shimmer:shimmerlayout:1.1")
        api("com.github.nitrico.lastadapter:lastadapter:2.3.0")
        api("com.github.bumptech.glide:glide:4.9.0")
        api("androidx.appcompat:appcompat:1.2.0")
    }

}
android {
    compileSdkVersion(30)
    sourceSets["main"].manifest.srcFile("src/androidMain/AndroidManifest.xml")
    defaultConfig {
        minSdkVersion(23)
        targetSdkVersion(30)
        versionCode = 1
        versionName = "1.0"
    }
    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
        }
    }
}