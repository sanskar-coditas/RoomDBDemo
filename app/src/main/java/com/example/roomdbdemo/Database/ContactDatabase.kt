package com.example.roomdbdemo.Database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase


@Database(entities = [Contact::class], version = 1)
abstract class ContactDatabase : RoomDatabase(){

    //this approch is thread safe (singleton approach)
    abstract fun contactDao(): ContactDAO
    companion object{

        @Volatile   //whenever new value assigns to instance variable; this annotation  will notify all threads with the updated value
        private var INSTANCE : ContactDatabase?=null

        fun getDatabase(context:Context): ContactDatabase {
            if(INSTANCE ==null)
            {
               synchronized(this)   //if multiple thread locking mechanism to create only one instance even if two thread access it
                {
                        INSTANCE = Room.databaseBuilder(context.applicationContext,      //database instance
                        ContactDatabase::class.java,
                        "contactDB").build()
                }
            }
            return INSTANCE!!
        }
    }





}