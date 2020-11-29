package com.example.uielements2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.example.uielements2.models.Album
import com.example.uielements2.models.Song

class AlbumFormAdd : AppCompatActivity() {
    lateinit var albumTitle: EditText
    lateinit var albumRelease: EditText
    lateinit var btnConfirm: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_album_form_add)

        val databaseHelper = DatabaseHelper(this)

        albumTitle = findViewById(R.id.albumTitle)
        albumRelease = findViewById(R.id.releaseDate)
        btnConfirm = findViewById(R.id.btn_confirm_add_album_main)
        btnConfirm.setOnClickListener {
            val title = albumTitle.text.toString()
            val releaseDate = albumRelease.text.toString()

            if(title.isNotEmpty() && releaseDate.isNotEmpty()) {
                val album = Album(title = title, releaseDate = releaseDate)
                databaseHelper.albumCreate(album)
                Toast.makeText(this,"Album added successfully", Toast.LENGTH_SHORT).show()
            }
            else
                Toast.makeText(this,"Please fill up the credentials", Toast.LENGTH_SHORT).show()
            clearFields()
        }
    }

    fun clearFields(){
        albumTitle.text.clear()
        albumRelease.text.clear()
    }
}

