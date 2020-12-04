package com.arraigntech.triviaapp.ui.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import com.arraigntech.triviaapp.R
// main activity to show splash screen

class MainActivity : AppCompatActivity() {
    private val SPLASH_TIME_OUT:Long=3000
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //To schedule tasks and runnables to be executed at some point
        Handler().postDelayed({
            startActivity(Intent(this,
                HomeActivity::class.java)) // switch activity from Main to HomeActivity
            finish() // clear out the current activity from stack
        }, SPLASH_TIME_OUT)
    }
}