package com.example.uielements2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.example.uielements2.models.AlbumSong
import com.example.uielements2.models.Song

class AlbumSongFormAdd : AppCompatActivity() {
    lateinit var btnConfirm: Button
    lateinit var etTitle: EditText
    lateinit var etArtist: EditText


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_album_song_form_add)

        val databaseHelper = DatabaseHelper(this)
        etTitle = findViewById(R.id.songTitle_album)
        etArtist = findViewById(R.id.songArtist_album)
        btnConfirm = findViewById(R.id.btn_confirm_add_song_main_album)
        btnConfirm.setOnClickListener {
            val title = etTitle.text.toString()
            val artitst = etArtist.text.toString()

            if(title.isNotEmpty() && artitst.isNotEmpty() ) {
                val albumSong = AlbumSong(title = title, artist = artitst)
                databaseHelper.albumSongCreate(albumSong)
                Toast.makeText(this,"Song added to album successfully", Toast.LENGTH_SHORT).show()
            }
            else
                Toast.makeText(this,"Please fill up the credentials", Toast.LENGTH_SHORT).show()
            clearFields()
        }
    }

    fun clearFields(){
        etTitle.text.clear()
        etArtist.text.clear()
    }
}