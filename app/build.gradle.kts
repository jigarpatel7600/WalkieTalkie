plugins {
    alias(libs.plugins.android.application)
}

android {
    namespace = "org.jigar.wfwt"
    compileSdk {
        version = release(37)
    }

    defaultConfig {
        applicationId = "org.jigar.wfwt"
        minSdk = 23
        targetSdk = 37
        versionCode = 2
        versionName = "2.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildFeatures {
        buildConfig = true
    }

    signingConfigs {
        create("release") {
            storeFile = file("sign-key.jks")
            storePassword = "123456"
            keyAlias = "test"
            keyPassword = "123456"

            // Optional, specify signing versions used
            //enableV1Signing = true
            //enableV2Signing = true
            //enableV3Signing = true
            //enableV4Signing = true
        }
    }

    buildTypes {
        debug {
            signingConfig = signingConfigs.getByName("release")
            optimization {
                enable = false
                packageScope = setOf("androidx.**", "kotlin.**", "kotlinx.**")
            }
        }

        release {
            signingConfig = signingConfigs.getByName("release")
            optimization {
                enable = true
                packageScope = setOf("androidx.**", "kotlin.**", "kotlinx.**")
            }
        }
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
}

dependencies {
    implementation(libs.appcompat)
    implementation(libs.material)
    testImplementation(libs.junit)
    androidTestImplementation(libs.espresso.core)
    androidTestImplementation(libs.ext.junit)
}