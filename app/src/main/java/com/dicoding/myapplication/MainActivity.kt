package com.dicoding.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
//import android.view.Menu
//import android.view.MenuItem
//import android.widget.Toast
//import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    private lateinit var rvAnime: RecyclerView
    private val list = ArrayList<Anime>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        rvAnime = findViewById(R.id.rv_anime)
        rvAnime.setHasFixedSize(true)

        list.addAll(getListAnimes())
        showRecyclerList()
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.action_aboutme -> {
                val intent = Intent(this, AboutMeActivity::class.java)
                startActivity(intent)
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

    private fun getListAnimes(): ArrayList<Anime> {
        val dataName = resources.getStringArray(R.array.data_name)
        val dataDescription = resources.getStringArray(R.array.data_description)
        val dataPhoto = resources.obtainTypedArray(R.array.data_photo)
        val listAnime = ArrayList<Anime>()
        for (i in dataName.indices) {
            val anime = Anime(dataName[i], dataDescription[i], dataPhoto.getResourceId(i, -1))
            listAnime.add(anime)
        }
        return listAnime
    }



    private fun showRecyclerList() {
        rvAnime.layoutManager = LinearLayoutManager(this)
        val listAnimeAdapter = ListAnimeAdapter(list)
        rvAnime.adapter = listAnimeAdapter

        listAnimeAdapter.setOnItemClickCallback(object : ListAnimeAdapter.OnItemClickCallback {
            override fun onItemClicked(data: Anime) {
                val intent = Intent(this@MainActivity, DetailActivity::class.java)
                intent.putExtra("anime_data", data)
                startActivity(intent)
            }
        })
    }
}