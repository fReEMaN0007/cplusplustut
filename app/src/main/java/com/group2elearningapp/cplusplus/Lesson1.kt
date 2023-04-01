package com.group2elearningapp.cplusplus

import android.content.ContentValues
import android.content.Intent
import android.database.sqlite.SQLiteDatabase
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import java.time.LocalDateTime


class Lesson1 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lesson1)


        /////////////////////////ActionBar
        val actionbar = supportActionBar
        actionbar!!.title = "Lesson1"
        val colorDrawable = ColorDrawable(Color.parseColor("#FF018786"))
        actionbar!!.setBackgroundDrawable(colorDrawable)
        /////////////////////////ActionBar


        var handler: DatabaseHelper = DatabaseHelper(this)

        val intent = intent
        var StudentNumber = intent.getStringExtra("StudentNumber")

        handler.checklAndUpdateProgress(StudentNumber.toString(), "Prelim", "Prelim", "one", 11, 1,2,5,3,10)

        val newbt = findViewById<Button>(R.id.a12)
        newbt.setOnClickListener() {
            val intent = Intent(this, Lesson1::class.java)
            startActivity(intent)
        }

    }
}