package com.example.farmeazy.Activities

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import androidx.appcompat.app.AppCompatActivity
import com.example.farmeazy.R

class SplashscreenActivity : AppCompatActivity() {
    lateinit var handler: Handler
        override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)
            setContentView(R.layout.activity_splashscreen)


            handler= Handler()
            handler.postDelayed({
                val intent= Intent(this,LoginActivity::class.java)
                startActivity(intent)
                finish()
            },3000)
        }
}