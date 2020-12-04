package com.arraigntech.triviaapp.ui.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.arraigntech.triviaapp.R

// containing navhost fragment mehtod in xml
class HomeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
    }
}