package com.example.uielements2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.ListView
import android.widget.TextView

class AlbumDetailsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_album_details)

        var albumItems: AlbumItem = intent.getSerializableExtra("data") as AlbumItem
        var viewImage = findViewById<ImageView>(R.id.icon_details)
        var viewText = findViewById<TextView>(R.id.icon_name)

        if(albumItems.icons == R.drawable.the_weeknd___house_of_balloons) {
            viewImage.setImageResource(albumItems.icons!!)

            val songsQueueArray = arrayOf("House of Balloons/Glass table girls", "High for this", "What you need", "Loft Music", "The Morning")
            val adapter = ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, songsQueueArray)
            val albumSongs = findViewById<ListView>(R.id.album_songs)
            albumSongs.adapter = adapter
        }
        else if(albumItems.icons == R.drawable.the_weeknd___after_hours){
            viewImage.setImageResource(albumItems.icons!!)
            viewText.text = "After Hours"

            val songsQueueArray = arrayOf("After Hours", "Blinding Lights", "Snowchild", "Alone again", "Too Late")
            val adapter = ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, songsQueueArray)
            val albumSongs = findViewById<ListView>(R.id.album_songs)
            albumSongs.adapter = adapter
        }
        else if(albumItems.icons == R.drawable.the_weeknd___beauty_behind_the_madness){
            viewImage.setImageResource(albumItems.icons!!)
            viewText.text = "Behind the Madness"

            val songsQueueArray = arrayOf("Dark Times", "Shameless", "Real Life", "Can't feel my face", "As you are")
            val adapter = ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, songsQueueArray)
            val albumSongs = findViewById<ListView>(R.id.album_songs)
            albumSongs.adapter = adapter
        }
    }
}