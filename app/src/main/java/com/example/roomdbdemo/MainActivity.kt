package com.example.roomdbdemo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.lifecycle.Observer
import androidx.room.Room
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {
    lateinit var database: ContactDatabase
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //we need to use singleton but still
       // database= Room.databaseBuilder(applicationContext,      //database instance
        //ContactDatabase::class.java,
       // "contactDB").build()

        database=ContactDatabase.getDatabase(this)

        GlobalScope.launch {
            database.contactDao().insertContact(Contact(0,"john", "999999999"))
        }



    }

    fun getData(view: View) {
        database.contactDao().getContact().observe( this, Observer {
            Log.d("MainActivityLog",it.toString())
        }


        )


    }
}