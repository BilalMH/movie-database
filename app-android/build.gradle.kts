import org.jetbrains.kotlin.kapt3.base.Kapt.kapt

plugins {
    id("com.android.application")
    kotlin("android")
    kotlin("kapt")
    id("dagger.hilt.android.plugin")
    id("kotlin-android")
}

android {
    compileSdk = Versions.TARGET_ANDROID_SDK

    defaultConfig {
        applicationId = "me.bilalhaider.moviedatabase"
        minSdk = Versions.MIN_ANDROID_SDK
        targetSdk = Versions.TARGET_ANDROID_SDK
        versionCode = 1
        versionName = "1.0"
        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
        }
    }

    compileOptions {
        sourceCompatibility(JavaVersion.VERSION_1_8)
        targetCompatibility(JavaVersion.VERSION_1_8)
    }

    buildFeatures {
        compose = true
    }

    composeOptions {
        kotlinCompilerExtensionVersion = Versions.Compose.COMPOSE_COMPILER
    }

    kotlinOptions {
        jvmTarget = "1.8"
    }
}

kapt {
    correctErrorTypes = true
}

dependencies {
    api(project(":network:mobileapi"))
    api(project(":network:mobileapi-client"))
    api(project(":network:model"))

    implementation(fileTree("libs"){
        include("*.jar")
    })

    api("androidx.appcompat:appcompat:${Versions.Androidx.APP_COMPAT}")
    api("androidx.activity:activity-compose:${Versions.Androidx.ACTIVITY_COMPOSE}")
    api("androidx.compose.ui:ui:${Versions.Compose.COMPOSE}")
    api("androidx.compose.ui:ui-tooling:${Versions.Compose.COMPOSE}")
    api("androidx.compose.foundation:foundation:${Versions.Compose.COMPOSE}")
    api("androidx.compose.material:material:${Versions.Compose.COMPOSE}")
    api("androidx.compose.runtime:runtime-livedata:${Versions.Compose.COMPOSE}")
    api("androidx.lifecycle:lifecycle-viewmodel-compose:${Versions.Compose.VIEWMODEL_COMPOSE}")
    api("androidx.constraintlayout:constraintlayout:${Versions.Androidx.CONSTRAINT_LAYOUT}")
    api("androidx.coordinatorlayout:coordinatorlayout:${Versions.Androidx.COORDINATOR_LAYOUT}")
    api("androidx.core:core-ktx:${Versions.Androidx.CORE_KTX}")
    api("androidx.fragment:fragment-ktx:${Versions.Androidx.FRAGMENT_KTX}")
    api("androidx.lifecycle:lifecycle-process:${Versions.Androidx.LIFECYCLE}")
    api("androidx.lifecycle:lifecycle-livedata-ktx:${Versions.Androidx.LIFECYCLE}")
    api("androidx.lifecycle:lifecycle-runtime-ktx:${Versions.Androidx.LIFECYCLE}")
    api("androidx.lifecycle:lifecycle-viewmodel-ktx:${Versions.Androidx.LIFECYCLE}")
    api("androidx.paging:paging-compose:${Versions.Compose.PAGING_COMPOSE}")
    api("androidx.recyclerview:recyclerview:${Versions.Androidx.RECYCLER_VIEW}")
    api("androidx.swiperefreshlayout:swiperefreshlayout:${Versions.Androidx.SWIPE_REFRESH_LAYOUT}")
    api("androidx.viewpager2:viewpager2:${Versions.Androidx.VIEW_PAGER2}")

    implementation ("com.squareup.retrofit2:retrofit:2.6.1")
    implementation ("com.squareup.retrofit2:converter-gson:2.4.0")
    implementation ("com.squareup.retrofit2:converter-scalars:2.1.0")
    implementation ("com.squareup.okhttp3:logging-interceptor:3.12.3")
    implementation ("com.squareup.retrofit2:adapter-rxjava2:2.6.1")
    implementation ("io.reactivex.rxjava2:rxandroid:2.0.2")
    implementation ("com.squareup.retrofit2:retrofit-converters:2.6.1")

    implementation("androidx.hilt:hilt-lifecycle-viewmodel:${Versions.Hilt.HILT_VIEW_MODEL}")
    implementation("com.google.dagger:hilt-android:${Versions.Hilt.HILT}")
    kapt("com.google.dagger:hilt-android-compiler:${Versions.Hilt.HILT}")

    implementation ("com.jakewharton:butterknife:10.2.0")
    annotationProcessor ("com.jakewharton:butterknife-compiler:10.2.0")

    implementation ("com.github.bumptech.glide:glide:4.10.0")
    annotationProcessor ("com.github.bumptech.glide:compiler:4.10.0")

    api("com.google.accompanist:accompanist-flowlayout:${Versions.ACCOMPANIST}")
    api("com.google.accompanist:accompanist-insets:${Versions.ACCOMPANIST}")

    api("io.coil-kt:coil-compose:${Versions.COIL}")

    api("com.google.android.material:material:${Versions.MATERIAL}")

    androidTestImplementation("androidx.test:runner:1.4.0")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.4.0")
    androidTestImplementation("androidx.test.ext:junit:1.1.3")
    debugImplementation("androidx.fragment:fragment-testing:1.4.1")

    testImplementation(kotlin("test-junit"))
}
