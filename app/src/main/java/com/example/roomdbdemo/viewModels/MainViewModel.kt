package com.example.roomdbdemo.viewModels


import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.roomdbdemo.Database.Contact
import com.example.roomdbdemo.Repository.ContactRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainViewModel(private val contactRepository: ContactRepository):ViewModel ()
{
    fun getContacts() : LiveData<List<Contact>>
    {
        return contactRepository.getContacts()

    }
    fun insertContact(contact: Contact)
    {
        viewModelScope.launch(Dispatchers.IO) {
            contactRepository.insertConatct(contact)
        }
    }

}