package com.group2elearningapp.cplusplus

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class Lesson_8_1 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lesson_8_1)

        var handler:DatabaseHelper = DatabaseHelper(this)
        val intent = intent
        var StudentNumber = intent.getStringExtra("StudentNumber")

        handler.checklAndUpdateProgress(StudentNumber.toString(),"Final","Finals","eightPointOne",12,1,8,8,3,50)

    }
}