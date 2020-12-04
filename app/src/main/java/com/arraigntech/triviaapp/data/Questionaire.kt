package com.arraigntech.triviaapp.data

import androidx.room.Entity
import androidx.room.PrimaryKey

//creting table named question
@Entity(tableName = "question")
data class Questionaire(
    var name:String,  // column name
    var cricketer:String,
    var flag:String
)
{
    @PrimaryKey(autoGenerate = true)
    var id: Int = 0
}