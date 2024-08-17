package com.example.test_crashlytics

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.yandex.metrica.YandexMetrica

class MainActivity : AppCompatActivity() {

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnCrash = findViewById<Button>(R.id.crash_btn)


        val crashButton = Button(this)
        crashButton.text = "Test Crash"
        crashButton.setOnClickListener {
            throw RuntimeException("Test Crash") // Force a crash
        }

        addContentView(
            crashButton, ViewGroup.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.WRAP_CONTENT
            )
        )


        btnCrash.setOnClickListener(View.OnClickListener {
            val eventParameters: MutableMap<String, Any> = HashMap()
            eventParameters["name"] = "mohadeseh"
            eventParameters["age"] = "20"
            YandexMetrica.reportEvent("New person", eventParameters)
        })
    }
}