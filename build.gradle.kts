plugins {
    kotlin("multiplatform") version "1.4.10"
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
    js {
        nodejs()
        binaries.executable()
    }

    sourceSets {
        val commonMain by getting {
            dependencies {
                implementation("com.ionspin.kotlin:bignum:0.2.0")
                implementation("com.soywiz.korlibs.krypto:krypto:1.12.0")
            }
        }
    }
}