import com.codingfeline.buildkonfig.compiler.FieldSpec.Type

plugins {
    kotlin("multiplatform")
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
                optIn("kotlin.time.ExperimentalTime")
                optIn("kotlinx.serialization.ExperimentalSerializationApi")
            }
        }

        val commonMain by getting {
            dependencies {
                implementation(project(":network:mobileapi-client"))
                implementation(project(":network:model"))
            }
        }
        val commonTest by getting {
            dependencies {
                implementation(kotlin("test-common"))
                implementation(kotlin("test-annotations-common"))
                implementation("com.google.truth:truth:1.1.3")
                implementation("io.insert-koin:koin-core:${Versions.KOIN}")
                implementation("io.insert-koin:koin-test:${Versions.KOIN}")
                implementation("io.insert-koin:koin-test-junit4:${Versions.KOIN}")
                implementation("io.kotest.extensions:kotest-extensions-koin:${Versions.KOTEST}")
            }
        }

        val androidMain by getting
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
    packageName = "me.bilalhaider.moviedatabase.network.mobileapi"

    defaultConfigs {
        buildConfigField(Type.BOOLEAN, "RELEASE", "false")
        buildConfigField(Type.BOOLEAN, "DEBUG", "true")

        buildConfigField(Type.LONG, "DEFAULT_REPOSITORY_DATA_TIMEOUT", "1800L")
    }

    defaultConfigs("release") {
        buildConfigField(Type.BOOLEAN, "RELEASE", "true")
        buildConfigField(Type.BOOLEAN, "DEBUG", "false")
    }
}