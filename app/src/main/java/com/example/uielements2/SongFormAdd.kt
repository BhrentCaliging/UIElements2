package com.example.uielements2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.example.uielements2.models.Song

class SongFormAdd : AppCompatActivity() {
    lateinit var btnConfirm:Button
    lateinit var etTitle:EditText
    lateinit var etArtist:EditText
    lateinit var etAlbum:EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_song_form_add)

        val databaseHelper = DatabaseHelper(this)

        etTitle = findViewById(R.id.songTitle)
        etArtist = findViewById(R.id.songArtist)
        etAlbum = findViewById(R.id.songAlbum)
        btnConfirm = findViewById(R.id.btn_confirm_add_song_main)
        btnConfirm.setOnClickListener {
            val title = etTitle.text.toString()
            val artitst = etArtist.text.toString()
            val album = etAlbum.text.toString()

            if(title.isNotEmpty() && artitst.isNotEmpty() && album.isNotEmpty()) {
                val song = Song(title = title, artist = artitst, album = album)
                databaseHelper.create(song)
                Toast.makeText(this,"Song added successfully", Toast.LENGTH_SHORT).show()
            }
            else
                Toast.makeText(this,"Please fill up the credentials", Toast.LENGTH_SHORT).show()
            clearFields()
        }
    }

    fun clearFields(){
        etTitle.text.clear()
        etArtist.text.clear()
        etAlbum.text.clear()
    }
}