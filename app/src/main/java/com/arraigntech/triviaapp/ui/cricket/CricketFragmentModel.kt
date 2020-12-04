package com.arraigntech.triviaapp.ui.cricket

import android.widget.RadioButton
import android.widget.RadioGroup
import androidx.core.view.get
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.arraigntech.triviaapp.R
import kotlinx.android.synthetic.main.cricketer_layout_fragment.view.*


class CricketFragmentModel(name: String) : ViewModel() {
    private val userNamee = MutableLiveData<String>()
    val _userName: LiveData<String> get() = userNamee
    private val ids = MutableLiveData<Int>()
    val _id:LiveData<Int>get() = ids



    init {
        userNamee.value = name
    }

    fun onSplitTypeChanged(radioGroup: RadioGroup?, id: Int) {
        ids.value = radioGroup?.checkedRadioButtonId
    }
}