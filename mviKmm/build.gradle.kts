plugins {
    id("com.android.library")
    kotlin("multiplatform")
    id("org.jetbrains.dokka") version "0.10.0"

}


repositories {
    gradlePluginPortal()
    google()
    jcenter()
    mavenCentral()
}

kotlin {

    targets {
        android()
        iosArm64 {
            binaries {
                framework("MultiPlatformLibrary")
            }
        }
        iosX64 {
            binaries {
                framework("MultiPlatformLibrary")
            }
        }
    }

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

    sourceSets {
        val iosX64Main by sourceSets.getting
        val iosArm64Main by sourceSets.getting
        val iosMain by sourceSets.creating {
            dependsOn(sourceSets["commonMain"])
            iosX64Main.dependsOn(this)
            iosArm64Main.dependsOn(this)
        }
    }

    android {

    }
    iosArm64 {
        compilations["main"].defaultSourceSet {
            dependsOn(sourceSets["iosMain"])
        }

    }

    targets.withType<org.jetbrains.kotlin.gradle.plugin.mpp.KotlinNativeTarget> {
        binaries.framework(listOf(RELEASE))
    }

}

tasks.named<org.jetbrains.dokka.gradle.DokkaTask>("dokka") {
    multiplatform {
        create("kotlinMultiplatform") {
            targets = listOf("Android", "iOS")
            skipEmptyPackages = true
        }
        create("android") {
            targets = listOf("Android")
            platform = "jvm"
            skipEmptyPackages = true
        }
        create("ios") {
            targets = listOf("iOS")
            platform = "native"
            skipEmptyPackages = true
        }
    }
}

//artifactory {
//    setContextUrl("https://atitto.jfrog.io/artifactory/")
////    publish(delegateClosureOf<org.jfrog.gradle.plugin.artifactory.dsl.PublisherConfig> {
////        repository(delegateClosureOf<org.jfrog.gradle.plugin.artifactory.dsl.DoubleDelegateWrapper> {
////            setProperty("repoKey", "MviFlowCore")
////            setProperty("username", "")
////            setProperty("password", "")
////            setProperty("maven", true)
////        })
////        defaults(delegateClosureOf<groovy.lang.GroovyObject> {
////            invokeMethod("publications", arrayOf(
////                "androidDebug", "androidRelease", "ios", "iosArm64", "iosX64", "kotlinMultiplatform", "metadata", "kmm", "native", "multiplatform"
////            ))
////        })
////    })
//}

android {
    compileSdkVersion(32)
    sourceSets["main"].manifest.srcFile("src/androidMain/AndroidManifest.xml")
    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
        }
    }
}
