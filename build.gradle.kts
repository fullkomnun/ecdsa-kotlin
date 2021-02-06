plugins {
    kotlin("multiplatform") version "1.4.30"
    id("maven-publish")
}

repositories {
    mavenCentral()
    jcenter()
    maven { url = uri("https://dl.bintray.com/korlibs/korlibs/") }
}

kotlin {
    jvm {
        val main by compilations.getting {
            kotlinOptions {
                jvmTarget = "1.8"
            }
        }
    }
    js(BOTH) {
        nodejs {
            testTask {
                useMocha {
                    timeout = "100000"
                }
            }
        }
    }

    sourceSets {
        commonMain {
            dependencies {
                implementation("com.ionspin.kotlin:bignum:0.2.4")
                implementation("com.soywiz.korlibs.krypto:krypto:1.12.0")
            }
        }

        commonTest {
            dependencies {
                implementation(kotlin("test-common"))
                implementation(kotlin("test-annotations-common"))
            }
        }

        val jvmTest by getting {
            dependencies {
                implementation(kotlin("test-junit"))
            }
        }

        val jsTest by getting {
            dependencies {
                implementation(kotlin("test-js"))
            }
        }
    }
}