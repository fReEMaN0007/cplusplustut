package com.group2elearningapp.cplusplus

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class Lesson_4_1 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lesson_4_1)

        var handler:DatabaseHelper = DatabaseHelper(this)

        val intent = intent
        var StudentNumber = intent.getStringExtra("StudentNumber")

        handler.checklAndUpdateProgress(StudentNumber.toString(),"Midterm","Midterm","fourPointOne",14,1,3,6,4,15)

    }
}