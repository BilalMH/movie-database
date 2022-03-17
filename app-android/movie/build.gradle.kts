plugins {
    id("com.android.library")
    id("dagger.hilt.android.plugin")
    kotlin("android")
    kotlin("kapt")
}

androidLibrary()

dependencies {
    implementation(project(":app-android:base"))

    implementation("androidx.hilt:hilt-lifecycle-viewmodel:${Versions.Hilt.HILT_VIEW_MODEL}")
    implementation("com.google.dagger:hilt-android:${Versions.Hilt.HILT}")
    kapt("com.google.dagger:hilt-android-compiler:${Versions.Hilt.HILT}")

    testImplementation(kotlin("test-junit"))
}