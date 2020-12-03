package com.arraigntech.triviaapp.ui

import android.util.Log
import android.widget.CompoundButton
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider


class FlagFactoryModel(private val name: String, private val answer: String) :
    ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(FlagModelView::class.java)) {
            return FlagModelView(name, answer) as T
        }

        throw IllegalStateException("")
    }



}