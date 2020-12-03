package com.arraigntech.triviaapp.ui

import android.text.Editable
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class NameFragmentModel : ViewModel() {
    private val isEnabled = MutableLiveData<Boolean>()
    val _isEnabled: LiveData<Boolean> get() = isEnabled

    fun enterName(nameText: Editable) {
        if (nameText.toString().isNullOrEmpty())
            isEnabled.value = false
        else
            isEnabled.value = true
    }


}