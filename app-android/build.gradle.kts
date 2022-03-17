plugins {
    id("com.android.application")
    id("kotlin-android")
}

android {
    compileSdk = 30

    defaultConfig {
        applicationId = "me.bilalhaider.moviedatabase"
        minSdk = 24
        targetSdk = 30
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
    kotlinOptions {
        jvmTarget = "1.8"
    }
}

dependencies {
    implementation("androidx.appcompat:appcompat:1.1.0")
    implementation ("androidx.constraintlayout:constraintlayout:1.1.3")
    implementation ("androidx.lifecycle:lifecycle-viewmodel-ktx:2.1.0")
    implementation ("com.squareup.retrofit2:retrofit:2.6.1")
    implementation ("com.squareup.retrofit2:converter-gson:2.4.0")
    implementation ("com.squareup.retrofit2:converter-scalars:2.1.0")
    implementation ("com.squareup.okhttp3:logging-interceptor:3.12.3")
    implementation ("com.squareup.retrofit2:adapter-rxjava2:2.6.1")
    implementation ("io.reactivex.rxjava2:rxandroid:2.0.2")
    implementation ("com.squareup.retrofit2:retrofit-converters:2.6.1")

    implementation ("com.jakewharton:butterknife:10.2.0")
    annotationProcessor ("com.jakewharton:butterknife-compiler:10.2.0")

    implementation ("com.github.bumptech.glide:glide:4.10.0")
    annotationProcessor ("com.github.bumptech.glide:compiler:4.10.0")

    implementation ("com.google.android.material:material:1.0.0")
    testImplementation ("junit:junit:4.12")
    androidTestImplementation ("androidx.test.ext:junit:1.1.1")
    androidTestImplementation ("androidx.test.espresso:espresso-core:3.1.1")
    implementation ("com.intuit.sdp:sdp-android:1.0.6")
}
