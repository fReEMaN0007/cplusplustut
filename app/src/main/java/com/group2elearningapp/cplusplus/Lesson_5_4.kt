package com.group2elearningapp.cplusplus

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class Lesson_5_4 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lesson_5_4)
        var handler:DatabaseHelper = DatabaseHelper(this)

        val intent = intent
        var StudentNumber = intent.getStringExtra("StudentNumber")

        handler.checklAndUpdateProgress(StudentNumber.toString(),"Midterm","Midterm","fivePointFour",16,1,8,6,1,15)

    }
}