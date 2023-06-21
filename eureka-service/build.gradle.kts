plugins {
    id("java")
    id("org.spingframework.boot") version "3.1.0 RELEASE"
}

group = "com.skfl"
version = "0.0.1-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(platform("org.junit:junit-bom:5.9.1"))
    testImplementation("org.junit.jupiter:junit-jupiter")
    implementation("org.springframework.boot:spring-boot-starter-web:3.1.0")
    implementation("org.springframework.boot:spring-boot-starter:3.1.0")
    implementation("org.springframework.cloud:spring-cloud-starter-netflix-eureka-server:4.0.2")

}

tasks.test {
    useJUnitPlatform()
}