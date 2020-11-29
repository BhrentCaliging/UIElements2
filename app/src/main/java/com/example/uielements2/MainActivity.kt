package com.example.uielements2

import android.content.Intent
import android.os.Bundle
import android.view.ContextMenu
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.AdapterView
import android.widget.AdapterView.AdapterContextMenuInfo
import android.widget.ArrayAdapter
import android.widget.ListView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.get
import com.example.uielements2.models.Song
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity() {
    lateinit var songsQueueArray: MutableList<Song>
    lateinit var songsTableHandler: DatabaseHelper
    lateinit var adapter: ArrayAdapter<Song>
    lateinit var songsQueueListView: ListView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        songsQueueListView = findViewById<ListView>(R.id.songsQueueListView)

        songsTableHandler = DatabaseHelper(this)
        songsQueueArray = songsTableHandler.read()


        adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, songsQueueArray)
        songsQueueListView.adapter = adapter

        registerForContextMenu(songsQueueListView)
        songsQueueListView.onItemClickListener = AdapterView.OnItemClickListener { parent, view, position, id ->  }
    }

    override fun onCreateContextMenu(menu: ContextMenu?, v: View?, menuInfo: ContextMenu.ContextMenuInfo?) {
        super.onCreateContextMenu(menu, v, menuInfo)
        val inflater = menuInflater
        inflater.inflate(R.menu.songs_menu, menu)
    }

    override fun onContextItemSelected(item: MenuItem): Boolean {

        val info = item.menuInfo as AdapterContextMenuInfo
        val listPosition = info.position

        return when (item.itemId) {
            R.id.add_to_queue -> {
                /*
                if(listPosition == 0) {
                    val songname = songsQueueArray[listPosition]
                    val preferences = getSharedPreferences("sharedPrefs", 0)
                    val editor = preferences.edit()
                    editor.putString("songname", songname)
                    editor.commit()
                }
                else if(listPosition == 1){
                    val songname2 = songsQueueArray[listPosition]
                    val preferences = getSharedPreferences("sharedPrefs", 0)
                    val editor = preferences.edit()
                    editor.putString("songname2", songname2)
                    editor.commit()
                }
                else if(listPosition == 2){
                    val songname3 = songsQueueArray[listPosition]
                    val preferences = getSharedPreferences("sharedPrefs", 0)
                    val editor = preferences.edit()
                    editor.putString("songname3", songname3)
                    editor.commit()
                }
                else if(listPosition == 3){
                    val songname4 = songsQueueArray[listPosition]
                    val preferences = getSharedPreferences("sharedPrefs", 0)
                    val editor = preferences.edit()
                    editor.putString("songname4", songname4)
                    editor.commit()
                }
                else if(listPosition == 4){
                    val songname5 = songsQueueArray[listPosition]
                    val preferences = getSharedPreferences("sharedPrefs", 0)
                    val editor = preferences.edit()
                    editor.putString("songname5", songname5)
                    editor.commit()
                }
                else if(listPosition == 5){
                    val songname6 = songsQueueArray[listPosition]
                    val preferences = getSharedPreferences("sharedPrefs", 0)
                    val editor = preferences.edit()
                    editor.putString("songname6", songname6)
                    editor.commit()
                }
                else if(listPosition == 6){
                    val songname7 = songsQueueArray[listPosition]
                    val preferences = getSharedPreferences("sharedPrefs", 0)
                    val editor = preferences.edit()
                    editor.putString("songname7", songname7)
                    editor.commit()
                }
                else if(listPosition == 7){
                    val songname8 = songsQueueArray[listPosition]
                    val preferences = getSharedPreferences("sharedPrefs", 0)
                    val editor = preferences.edit()
                    editor.putString("songname8", songname8)
                    editor.commit()
                }
                else if(listPosition == 8){
                    val songname9 = songsQueueArray[listPosition]
                    val preferences = getSharedPreferences("sharedPrefs", 0)
                    val editor = preferences.edit()
                    editor.putString("songname9", songname9)
                    editor.commit()
                }
                else if(listPosition == 9){
                    val songname10 = songsQueueArray[listPosition]
                    val preferences = getSharedPreferences("sharedPrefs", 0)
                    val editor = preferences.edit()
                    editor.putString("songname10", songname10)
                    editor.commit()
                }
                else if(listPosition == 10){
                    val songname11 = songsQueueArray[listPosition]
                    val preferences = getSharedPreferences("sharedPrefs", 0)
                    val editor = preferences.edit()
                    editor.putString("songname11", songname11)
                    editor.commit()
                }
                else if(listPosition == 11){
                    val songname12 = songsQueueArray[listPosition]
                    val preferences = getSharedPreferences("sharedPrefs", 0)
                    val editor = preferences.edit()
                    editor.putString("songname12", songname12)
                    editor.commit()
                }
                else if(listPosition == 12){
                    val songname13 = songsQueueArray[listPosition]
                    val preferences = getSharedPreferences("sharedPrefs", 0)
                    val editor = preferences.edit()
                    editor.putString("songname13", songname13)
                    editor.commit()
                }
                else if(listPosition == 13){
                    val songname14 = songsQueueArray[listPosition]
                    val preferences = getSharedPreferences("sharedPrefs", 0)
                    val editor = preferences.edit()
                    editor.putString("songname14", songname14)
                    editor.commit()
                }
                else if(listPosition == 14){
                    val songname15 = songsQueueArray[listPosition]
                    val preferences = getSharedPreferences("sharedPrefs", 0)
                    val editor = preferences.edit()
                    editor.putString("songname15", songname15)
                    editor.commit()
                }
                val snackbar = Snackbar.make(this.findViewById(R.id.songsQueueListView), "Navigate To Queue", Snackbar.LENGTH_LONG)
                snackbar.setAction("Go", View.OnClickListener {
                    startActivity(Intent(this, QueueActivity::class.java))
                })
                snackbar.show()
                 */
                true
            }
            R.id.go_to_edit_songs -> {
                val song_id = songsQueueArray[listPosition].id

                val intent = Intent(applicationContext, SongFormEdit::class.java)
                intent.putExtra("song_id", song_id)

                startActivity(intent)
                true
            }
            R.id.go_to_delete_songs -> {
                val song = songsQueueArray[listPosition]
                if(songsTableHandler.delete(song)){
                    songsQueueArray.removeAt(listPosition)
                    adapter.notifyDataSetChanged()
                    Toast.makeText(this,"Song deleted successfully", Toast.LENGTH_SHORT).show()
                }
                else{
                    Toast.makeText(this,"Song deletion failed", Toast.LENGTH_SHORT).show()
                }
                true
            }
            else -> super.onContextItemSelected(item)
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val inflater = menuInflater
        inflater.inflate(R.menu.main_menu, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.go_to_songs -> {
                true
            }
            R.id.go_to_add_songs -> {
                startActivity(Intent(this, SongFormAdd::class.java))
                true
            }
            R.id.go_to_albums -> {
                startActivity(Intent(this, AlbumActivity::class.java))
                true
            }
            R.id.go_to_queues -> {
                startActivity(Intent(this, QueueActivity::class.java))
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }
}