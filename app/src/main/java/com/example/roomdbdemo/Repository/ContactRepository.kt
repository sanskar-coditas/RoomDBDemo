package com.example.roomdbdemo.Repository

import com.example.roomdbdemo.Database.Contact
import com.example.roomdbdemo.Database.ContactDAO
import androidx.lifecycle.LiveData

class ContactRepository (private val contactDAO: ContactDAO){

    fun getContacts() : LiveData<List<Contact>>{
        return contactDAO.getContact()
    }
    suspend fun insertConatct(contact: Contact){
        contactDAO.insertContact(contact)
    }



}