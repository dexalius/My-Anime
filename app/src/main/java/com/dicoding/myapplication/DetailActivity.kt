package com.dicoding.myapplication

import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView

class DetailActivity : AppCompatActivity() {

    companion object{
        const val key_anime = "anime_data"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        val tvTitle:TextView = findViewById(R.id.tv_title)
        val tvDescription:TextView = findViewById(R.id.tv_description)
        val imageDetail:ImageView = findViewById(R.id.image_detail)


        val dataAnime = if (Build.VERSION.SDK_INT >= 33){
            intent.getParcelableExtra<Anime>(key_anime, Anime::class.java)
        } else {
            @Suppress("DEPRECATION")
            intent.getParcelableExtra<Anime>(key_anime)
        }
        if (dataAnime != null){
            tvTitle.text= dataAnime.name
            tvDescription.text = dataAnime.description
            imageDetail.setImageResource(dataAnime.photo)
        }
    }
}