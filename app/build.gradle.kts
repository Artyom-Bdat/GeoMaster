plugins {
    id("com.android.application")
    id("com.google.gms.google-services")
}

android {
    namespace = "com.example.tyomo_prodaqshn"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.example.tyomo_prodaqshn"
        minSdk = 26
        targetSdk = 33
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    buildFeatures {
        viewBinding = true
    }
}

dependencies {
    implementation ("com.airbnb.android:lottie:4.2.2")
    implementation ("com.google.gms:google-services:4.3.10")
    implementation("com.google.firebase:firebase-database:20.0.2")
    implementation("androidx.appcompat:appcompat:1.6.1")
    implementation("com.google.android.material:material:1.11.0")
    implementation("androidx.constraintlayout:constraintlayout:2.1.4")
    implementation("com.google.firebase:firebase-firestore:24.10.3")
    implementation("com.google.android.gms:play-services-tasks:18.1.0")
    implementation("com.google.firebase:firebase-database:20.3.1")
    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.1.5")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")
    implementation("com.hbb20:ccp:2.5.0")
    implementation("com.intuit.sdp:sdp-android:1.1.1")
    implementation("com.squareup.okhttp3:okhttp:4.12.0")
    implementation(platform("com.google.firebase:firebase-bom:32.7.0"))
    implementation("com.google.firebase:firebase-auth")
    implementation("com.firebaseui:firebase-ui-firestore:8.0.2")
    dependencies {
        // FirebaseUI for Firebase Realtime Database
        implementation("com.firebaseui:firebase-ui-database:8.0.2")

        // FirebaseUI for Cloud Firestore
        implementation("com.firebaseui:firebase-ui-firestore:8.0.2")

        // FirebaseUI for Firebase Auth
        implementation("com.firebaseui:firebase-ui-auth:8.0.2")

        // FirebaseUI for Cloud Storage
        implementation("com.firebaseui:firebase-ui-storage:8.0.2")
        implementation ("com.github.Spikeysanju:MotionToast:1.4")

    }
}