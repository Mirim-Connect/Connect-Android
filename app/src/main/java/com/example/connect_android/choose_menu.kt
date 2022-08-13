package com.example.connect_android

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class choose_menu : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_choose_menu)

        val human_btn_intent = findViewById<Button>(R.id.btn_human)
        human_btn_intent.setOnClickListener {
            val intent = Intent(this, Menu_Adapter::class.java)
            startActivity(intent)
        }

    }

}