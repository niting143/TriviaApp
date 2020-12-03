package com.arraigntech.triviaapp.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import java.lang.IllegalStateException

class CricketFragmentFactory(private val name: String) : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(CricketFragmentModel::class.java)) {
            return CricketFragmentModel(name) as T
        }
        throw IllegalStateException("Unknown Model Class")
    }

}