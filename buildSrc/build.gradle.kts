plugins {
    `kotlin-dsl`
}

repositories {
    google()
    mavenCentral()
    maven("https://ajoberstar.org/bintray-backup")
}

dependencies {
    implementation("com.android.tools.build:gradle:7.1.0")
    implementation("org.ajoberstar.grgit:grgit-core:4.1.0")
    implementation(kotlin("compiler-embeddable", "1.6.10"))
    implementation(kotlin("gradle-plugin", "1.6.10"))
}