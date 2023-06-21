plugins {
    id("java")
    id("org.springframework.boot") version "3.1.0"
}

group = "com.skfl"
version = "0.0.1-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    implementation("org.springframework.boot:spring-boot-starter-web:3.1.0")
    implementation(project(mapOf("path" to ":common")))
    compileOnly("org.projectlombok:lombok:1.18.24")
    annotationProcessor("org.projectlombok:lombok:1.18.24")
    implementation("org.springframework.boot:spring-boot-starter-data-jpa:3.1.0")
    implementation("com.fasterxml.jackson.core:jackson-databind:2.14.2")
    testImplementation(platform("org.junit:junit-bom:5.9.1"))
    testImplementation("org.junit.jupiter:junit-jupiter")
}

tasks.test {
    useJUnitPlatform()
}