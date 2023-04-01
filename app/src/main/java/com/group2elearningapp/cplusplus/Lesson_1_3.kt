package com.group2elearningapp.cplusplus

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class Lesson_1_3 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lesson_1_3)


        var handler: DatabaseHelper = DatabaseHelper(this)

        val intent = intent
        var StudentNumber = intent.getStringExtra("StudentNumber")

        handler.checklAndUpdateProgress(StudentNumber.toString(), "Prelim", "Prelim", "onePointThree", 11, 1,5,5,3,10)



    }
}