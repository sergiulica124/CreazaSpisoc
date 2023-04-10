package com.siperju.listmaker.ui.main

import android.content.SharedPreferences
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class MainViewModelFactory(var sharedPreferences: SharedPreferences): ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
            if(modelClass.isAssignableFrom(MainViewModel::class.java)){
                @Suppress("UNCHECKED_CAST")
                return MainViewModel(sharedPreferences) as T
            }
            throw IllegalArgumentException("ViewModel class not found")
        }
}
