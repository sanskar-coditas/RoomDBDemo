package com.example.roomdbdemo.repo

import com.example.roomdbdemo.db.Contact
import com.example.roomdbdemo.db.ContactDAO
import androidx.lifecycle.LiveData

class ContactRepository (private val contactDAO: ContactDAO){

    fun getContacts() : LiveData<List<Contact>>{
        return contactDAO.getContact()
    }
    suspend fun insertConatct(contact: Contact){
        contactDAO.insertContact(contact)
    }



}