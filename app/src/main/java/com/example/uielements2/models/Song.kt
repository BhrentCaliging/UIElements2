package com.example.uielements2.models

import java.io.Serializable

class Song (var id: Int = 0, var title: String, var artist: String, var album: String){
    override fun toString(): String {
        return "Title: ${title} \n"+
                "Artist: ${artist} \n"+
                "Album: ${album}"
    }
}