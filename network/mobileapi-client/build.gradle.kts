import com.codingfeline.buildkonfig.compiler.FieldSpec.Type

plugins {
    kotlin("multiplatform")
    kotlin("plugin.serialization")
    id("com.android.library")
    id("com.codingfeline.buildkonfig")
}

kotlin {
    android()

    sourceSets {
        all {
            languageSettings.apply {
                apiVersion = "1.6"
                languageVersion = "1.6"
                progressiveMode = true
                optIn("io.ktor.util.InternalAPI")
            }
        }

        val commonMain by getting {
            dependencies {
                implementation(project(":network:model"))

                implementation("io.ktor:ktor-client-auth:${Versions.KTOR}")
                implementation("io.ktor:ktor-client-core:${Versions.KTOR}")
                implementation("io.ktor:ktor-client-encoding:${Versions.KTOR}")
                implementation("io.ktor:ktor-client-json:${Versions.KTOR}")
                implementation("io.ktor:ktor-client-serialization:${Versions.KTOR}")
                api("org.jetbrains.kotlinx:kotlinx-coroutines-core:${Versions.Kotlinx.COROUTINES}")
            }
        }

        val commonTest by getting {
            dependencies {
                implementation(kotlin("test-common"))
                implementation(kotlin("test-annotations-common"))
            }
        }

        val androidMain by getting {
            dependencies {
                implementation("com.squareup.okhttp3:okhttp:${Versions.OK_HTTP}")
                implementation("com.squareup.okhttp3:logging-interceptor:${Versions.OK_HTTP}")
                implementation("io.ktor:ktor-client-okhttp:${Versions.KTOR}")
            }
        }
        val androidTest by getting {
            dependencies {
                implementation(kotlin("test-junit"))
                implementation("junit:junit:${Versions.JUNIT}")
            }
        }
    }
}

multiplatformLibrary()

buildkonfig {
    packageName = "me.bilalhaider.moviedatabase.network.mobileapi.client"

    defaultConfigs {
        buildConfigField(Type.BOOLEAN, "RELEASE", "false")
        buildConfigField(Type.BOOLEAN, "DEBUG", "true")

        buildConfigField(Type.STRING, "DEFAULT_MOBILEAPI_ENVIRONMENT", "PRODUCTION")
    }

    defaultConfigs("release") {
        buildConfigField(Type.BOOLEAN, "RELEASE", "true")
        buildConfigField(Type.BOOLEAN, "DEBUG", "false")
    }
}