package com.arraigntech.triviaapp.ui.flag

import android.util.Log
import android.widget.CompoundButton
import androidx.databinding.BindingAdapter
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class FlagModelView(private val name: String, private val answer: String) : ViewModel() {
    private val userNamee = MutableLiveData<String>()
    val _userName: LiveData<String> get() = userNamee
    private val answers = MutableLiveData<String>()
    val _answers: LiveData<String>
        get() = answers

    private val list = MutableLiveData<String>()
    val _list: LiveData<String> get() = list
    private val list1 = MutableLiveData<String>()
    val _list1: LiveData<String> get() = list1
    private val list2 = MutableLiveData<String>()
    val _list2: LiveData<String> get() = list2
    private val list3 = MutableLiveData<String>()
    val _list3: LiveData<String> get() = list3


    init {
        userNamee.value = name
        answers.value = answer
    }

    fun onCheckedChange0(button: CompoundButton?, check: Boolean) {
        list.value = button?.hint.toString()
        Log.d("Z1D1", "onCheckedChange: $check")
    }

    fun onCheckedChange1(button: CompoundButton?, check: Boolean) {
        list1.value = button?.hint.toString()
        Log.d("Z1D1", "onCheckedChange: $check")
    }

    fun onCheckedChange2(button: CompoundButton?, check: Boolean) {
        list2.value = button?.hint.toString()
        Log.d("Z1D1", "onCheckedChange: $check")
    }

    fun onCheckedChange3(button: CompoundButton?, check: Boolean) {
        list3.value = button?.hint.toString()
        Log.d("Z1D1", "onCheckedChange: $check")
    }

    interface OnUserCheckedChangeListener {
        fun onUserCheckChange(view:CompoundButton, isChecked:Boolean)
    }
    @BindingAdapter("onUserCheckedChange")
    fun setUserCheckedChangeListener(view:CompoundButton, listener: OnUserCheckedChangeListener?){
        if(listener == null){
            view.setOnClickListener(null)
        }else{
            view.setOnClickListener {
                listener.onUserCheckChange(view, view.isChecked)
            }
        }
    }
}