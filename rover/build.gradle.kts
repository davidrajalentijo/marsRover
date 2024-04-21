plugins {
    id("java-library")
    alias(libs.plugins.jetbrainsKotlinJvm)
}

java {
    sourceCompatibility = JavaVersion.VERSION_17
    targetCompatibility = JavaVersion.VERSION_17
}

dependencies {
    implementation(libs.ktor.server.core)
    implementation(libs.ktor.server.netty)
    implementation(libs.ktor.jackson)
    implementation("ch.qos.logback:logback-classic:1.3.0")

    testImplementation(libs.junit)

    testImplementation(libs.mockito.core)

}