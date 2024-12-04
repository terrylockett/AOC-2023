plugins {
    `groovy-gradle-plugin`
    `kotlin-dsl`
}

repositories {
    mavenCentral()
    gradlePluginPortal()
}

dependencies {
    implementation(libs.spotless)
    implementation(libs.jmhPlugin)
    implementation(libs.kotlinJvmPlugin)
    implementation(files(libs.javaClass.superclass.protectionDomain.codeSource.location))
}

