package com.group2elearningapp.cplusplus

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class Lesson8 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lesson8)

        var handler:DatabaseHelper = DatabaseHelper(this)
        val intent = intent
        var StudentNumber = intent.getStringExtra("StudentNumber")

        handler.checklAndUpdateProgress(StudentNumber.toString(),"Final","Finals","eight",12,1,7,8,3,50)

    }
}