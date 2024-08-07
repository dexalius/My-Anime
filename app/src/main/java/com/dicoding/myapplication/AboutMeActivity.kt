package com.dicoding.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class AboutMeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_about_me)

        supportActionBar?.title = "About"

        val buttonShare = findViewById<Button>(R.id.button_share)
        buttonShare.setOnClickListener {
            shareInformation()
        }
    }

    private fun shareInformation() {
        val sharingIntent = Intent(Intent.ACTION_SEND)
        sharingIntent.type = "text/plain"
        val shareBody = "https://www.linkedin.com/in/dhanyaufar/"
        sharingIntent.putExtra(Intent.EXTRA_TEXT, shareBody)
        startActivity(Intent.createChooser(sharingIntent, "Bagikan melalui"))
    }
}