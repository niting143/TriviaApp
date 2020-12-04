package com.arraigntech.triviaapp.ui.summary

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import java.lang.IllegalStateException

class SummaryFactoryModel(
    private val userName: String
    , private val answer1: String,
    private val checkOne: String,
    private val checkTwo: String,
    private val checkThree: String,
    private val checkFour: String
) : ViewModelProvider.Factory{
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if(modelClass.isAssignableFrom(SummaryModel::class.java)){
            return SummaryModel(
                userName,
                answer1,
                checkOne,
                checkTwo,
                checkThree,
                checkFour
            ) as T
        }

        throw IllegalStateException("")
    }

}