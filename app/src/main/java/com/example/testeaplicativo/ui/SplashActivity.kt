package com.example.testeaplicativo.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import com.example.testeaplicativo.R

class SplashActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        splashToMainActivity()

        //esconde action bar
        supportActionBar?.hide()
    }

    private fun splashToMainActivity() {


        Handler().postDelayed({
            startActivity(Intent(this, MainActivity::class.java))
        }, 4000); //4 Seconds

    }
}