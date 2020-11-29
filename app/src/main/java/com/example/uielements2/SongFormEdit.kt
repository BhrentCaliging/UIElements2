package com.example.uielements2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.example.uielements2.models.Song

class SongFormEdit : AppCompatActivity() {
    lateinit var editBtnConfirm: Button
    lateinit var editEtTitle: EditText
    lateinit var editEtArtist: EditText
    lateinit var editEtAlbum: EditText
    lateinit var song: Song

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_song_form_edit)

        val song_id = intent.getIntExtra("song_id", 0)

        val databaseHelper = DatabaseHelper(this)
        song = databaseHelper.readOne(song_id)

        editEtTitle = findViewById(R.id.edit_songTitle)
        editEtArtist = findViewById(R.id.edit_songArtist)
        editEtAlbum = findViewById(R.id.edit_songAlbum)
        editBtnConfirm = findViewById(R.id.edit_btn_confirm_add_song_main)

        editEtTitle.setText(song.title)
        editEtArtist.setText(song.artist)
        editEtAlbum.setText(song.album)

        editBtnConfirm.setOnClickListener {
            val title = editEtTitle.text.toString()
            val artitst = editEtArtist.text.toString()
            val album = editEtAlbum.text.toString()

            if(title.isNotEmpty() && artitst.isNotEmpty() && album.isNotEmpty()) {
                val updatesong = Song(id = song.id, title = title, artist = artitst, album = album)
                databaseHelper.update(updatesong)
                Toast.makeText(this,"Song edited successfully", Toast.LENGTH_SHORT).show()
            }
            else
                Toast.makeText(this,"Please fill up the credentials", Toast.LENGTH_SHORT).show()

        }
    }
}