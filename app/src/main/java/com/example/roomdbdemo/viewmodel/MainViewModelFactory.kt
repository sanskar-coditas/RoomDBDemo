package com.example.roomdbdemo.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.roomdbdemo.repo.ContactRepository

class MainViewModelFactory(private val contactRepository: ContactRepository):ViewModelProvider.NewInstanceFactory() {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return MainViewModel(contactRepository) as T
    }



}