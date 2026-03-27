plugins {
    `java-library`
    `maven-publish`
}

group = "com.example.rewritelab"
version = "1.0.0"

java {
    sourceCompatibility = JavaVersion.VERSION_1_8
    targetCompatibility = JavaVersion.VERSION_1_8
}

repositories {
    mavenCentral()
}

dependencies {
    api("com.google.guava:guava:32.1.3-jre")
    api("org.apache.commons:commons-lang3:3.14.0")
    api("commons-io:commons-io:2.15.1")

    testImplementation("junit:junit:4.13.2")
}

publishing {
    publications {
        create<MavenPublication>("mavenJava") {
            from(components["java"])
        }
    }
}
