package com.example.uielements2.models

class AlbumSong(var id: Int = 0, var title: String, var artist: String) {
    override fun toString(): String {
        return "Title: ${title} \n"+
                "Artist: ${artist}"
    }
}
