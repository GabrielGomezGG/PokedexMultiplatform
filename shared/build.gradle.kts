plugins {
    kotlin("multiplatform")
    id("com.android.library")
    kotlin("plugin.serialization") version "1.8.10"
    id("app.cash.sqldelight") version "2.0.0"
}

@OptIn(org.jetbrains.kotlin.gradle.ExperimentalKotlinGradlePluginApi::class)
kotlin {
    targetHierarchy.default()

    android {
        compilations.all {
            kotlinOptions {
                jvmTarget = "1.8"
            }
        }
    }

    listOf(
        iosX64(),
        iosArm64(),
        iosSimulatorArm64()
    ).forEach {
        it.binaries.framework {
            baseName = "shared"
        }
    }

    sourceSets {

        //KTOR
        val ktorVersion = "2.3.4"
        val koinVersion = "3.2.0"
        val sqldelight = "2.0.0"

        val commonMain by getting {
            dependencies {
                //put your multiplatform dependencies here
                implementation("io.ktor:ktor-client-core:$ktorVersion")
                implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.6.4")

                implementation("io.ktor:ktor-client-content-negotiation:$ktorVersion")
                implementation("io.ktor:ktor-serialization-kotlinx-json:$ktorVersion")

                //koin
                implementation("io.insert-koin:koin-core:$koinVersion")
                implementation("io.insert-koin:koin-test:$koinVersion")

                implementation("app.cash.sqldelight:sqlite-driver:$sqldelight")
            }
        }
        val commonTest by getting {
            dependencies {
                implementation(kotlin("test"))
            }
        }

        val androidMain by getting {
            dependencies {
                implementation("io.ktor:ktor-client-okhttp:$ktorVersion")

                implementation("app.cash.sqldelight:android-driver:$sqldelight")
            }
        }

        val iosX64Main by getting
        val iosArm64Main by getting
        val iosSimulatorArm64Main by getting
        val iosMain by getting {
            dependsOn(commonMain)
            iosX64Main.dependsOn(this)
            iosArm64Main.dependsOn(this)
            iosSimulatorArm64Main.dependsOn(this)

            dependencies {
                implementation("io.ktor:ktor-client-darwin:$ktorVersion")

                implementation("app.cash.sqldelight:native-driver:$sqldelight")
            }
        }
    }
}

sqldelight {
    databases {
        create("MyDatabase") {
            packageName.set("com.example.pokedexmultiplatform")
        }
    }
}

android {
    namespace = "com.example.pokedexmultiplatform"
    compileSdk = 34
    defaultConfig {
        minSdk = 28
    }
}