package com.arraigntech.triviaapp.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase


//database schema abstract class extended roomdb
@Database(entities = arrayOf(Questionaire::class), version = 1, exportSchema = false)
abstract class QuestionaireDatabase : RoomDatabase() {

    abstract fun objDao(): QuestionaireDAO  //creating dao abstract method to access the queries

    companion object {
        @Volatile   // to provide the instance immediately
        private var instance: QuestionaireDatabase? = null
        private val LOCK = Any()
        operator fun invoke(context: Context) = instance ?: synchronized(LOCK) {
            instance ?: buildDatabase(context).also {
                instance = it
            }
        }
        // function to build the database containing context db classname and dbname
        private fun buildDatabase(context: Context) = Room.databaseBuilder(
            context.applicationContext,
            QuestionaireDatabase::class.java,
            "questionaire_database"
        ).build()
    }
}