package com.example.testeaplicativo.ui

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import com.example.testeaplicativo.R

class AboutActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_about)


        val urlLinkedin = findViewById<TextView>(R.id.url_linkedin)

        urlLinkedin.setOnClickListener {
            val url = "https://www.linkedin.com/in/douglas-campos-chagas-774a261ab/"
            val intentLinkedin = Intent(Intent.ACTION_VIEW)
            intentLinkedin.data = Uri.parse(url)
            startActivity(intentLinkedin)
        }
    }


}