package com.example.roomdbdemo

import com.example.roomdbdemo.repo.ContactRepository
import com.example.roomdbdemo.db.Contact
import com.example.roomdbdemo.db.ContactDatabase
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.roomdbdemo.databinding.ActivityMainBinding
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import com.example.roomdbdemo.viewmodel.MainViewModel
import com.example.roomdbdemo.viewmodel.MainViewModelFactory

class MainActivity : AppCompatActivity() {
    lateinit var database: ContactDatabase
    lateinit var binding: ActivityMainBinding
    lateinit var mainViewModel: MainViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
       binding= DataBindingUtil.setContentView(this, R.layout.activity_main)
        val DAO = ContactDatabase.getDatabase(applicationContext).contactDao()
        val repository = ContactRepository(DAO)
        mainViewModel = ViewModelProvider(this,
            MainViewModelFactory(repository)
        ).get(MainViewModel::class.java)

        mainViewModel.getContacts().observe(this, Observer {
            binding.contacts = it.toString()
        })
        //we need to use singleton but still
       // database= Room.databaseBuilder(applicationContext,      //database instance
        //ContactDatabase::class.java,
       // "contactDB").build()

        database= ContactDatabase.getDatabase(this)

        GlobalScope.launch {
            database.contactDao().insertContact(Contact(0,"john", "999999999"))
        }


        binding.buttonForData.setOnClickListener {
            val contact = Contact(0,"Sanskar", "9595092420")
            mainViewModel.insertContact(contact)

        }

//featur_2b dsbdsdsgitcheck
//featuregit
//feature for testing
        //feature for testing rebase
    }

//   fun getData(view: View) {
//        database.contactDao().getContact().observe( this, Observer {
//            Log.d("MainActivityLog",it.toString())
//        })

    //chnages to uderstand the concept of submodule
    //Changes to understand concept of submodule part 2

}