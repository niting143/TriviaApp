package com.arraigntech.triviaapp.data

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import kotlinx.coroutines.flow.Flow


// interface for querying the database

@Dao
interface QuestionaireDAO {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(questionaire: Questionaire)

    @Query("SELECT * FROM question")
    suspend fun getLists(): List<Questionaire>


}