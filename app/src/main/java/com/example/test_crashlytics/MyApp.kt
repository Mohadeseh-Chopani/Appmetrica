package com.example.test_crashlytics

import android.app.Application
import com.google.firebase.FirebaseApp
import com.google.firebase.crashlytics.FirebaseCrashlytics
import com.yandex.metrica.YandexMetrica
import com.yandex.metrica.YandexMetricaConfig

class MyApp : Application() {
    override fun onCreate() {
        super.onCreate()

        FirebaseApp.initializeApp(this)
        FirebaseCrashlytics.getInstance().setCrashlyticsCollectionEnabled(true)

        val config = YandexMetricaConfig.newConfigBuilder("144ebb6e-ca44-4bb4-a288-5e092f9ca027")
            .withNativeCrashReporting(false)
            .withLocationTracking(true)
            .withAppVersion("1")
            .build()

        YandexMetrica.activate(applicationContext, config)
        YandexMetrica.enableActivityAutoTracking(this)
    }
}