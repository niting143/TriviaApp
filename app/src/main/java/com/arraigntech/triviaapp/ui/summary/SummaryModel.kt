package com.arraigntech.triviaapp.ui.summary

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class SummaryModel(
    private val userName: String
    , private val answer1: String,
    private val checkOne: String,
    private val checkTwo: String,
    private val checkThree: String,
    private val checkFour: String
) : ViewModel() {
    private val userNamee = MutableLiveData<String>()
    val _userName: LiveData<String> get() = userNamee
    private val answer = MutableLiveData<String>()
    val _answer: LiveData<String> get() = answer
    private val list = MutableLiveData<String>()
    val _list: LiveData<String> get() = list
    private val list1 = MutableLiveData<String>()
    val _list1: LiveData<String> get() = list1
    private val list2 = MutableLiveData<String>()
    val _list2: LiveData<String> get() = list2
    private val list3 = MutableLiveData<String>()
    val _list3: LiveData<String> get() = list3





    private val ans2 = MutableLiveData<String>()
    val _ans2: LiveData<String> get() = ans2
    val sb = StringBuilder()

    init {
        userNamee.value = userName
        answer.value = answer1
        list.value = checkOne
        list1.value = checkTwo
        list2.value = checkThree
        list3.value = checkFour
        if (list.value != "")
            sb.append(list.value).append(",")
        if (list1.value != "")
            sb.append(list1.value).append(",")
        if (list2.value != "")
            sb.append((list2.value)).append(",")
        if (list3.value != "")
            sb.append(list3.value).append(",")
        ans2.value = sb.toString()
    }

}