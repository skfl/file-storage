plugins {
    id("java")
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
    implementation("org.springframework.boot:spring-boot-starter-data-jpa:3.1.0")
    implementation("org.springframework.kafka:spring-kafka:3.0.7")

    implementation("org.postgresql:postgresql:42.5.1")
    implementation(project(mapOf("path" to ":common")))
    compileOnly("org.projectlombok:lombok:1.18.24")
    annotationProcessor("org.projectlombok:lombok:1.18.24")
}

tasks.test {
    useJUnitPlatform()
}