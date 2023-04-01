package com.group2elearningapp.cplusplus

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.LinearLayout

class Midterm : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_midterm)

        val intent = intent
        var StudentNumber= intent.getStringExtra("StudentNumber")

        val lesson4box_midterm = findViewById<LinearLayout>(R.id.lesson4box_midterm)
        lesson4box_midterm.setOnClickListener(){
            val intent = Intent(this, Lesson4::class.java)
            intent.putExtra("StudentNumber",StudentNumber.toString())
            startActivity(intent)
        }

        val lesson4p1box_midterm = findViewById<LinearLayout>(R.id.lesson4p1box_midterm)
        lesson4p1box_midterm.setOnClickListener(){
            val intent = Intent(this, Lesson_4_1::class.java)
            intent.putExtra("StudentNumber",StudentNumber.toString())
            startActivity(intent)
        }

        val lesson5box_midterm = findViewById<LinearLayout>(R.id.lesson5box_midterm)
        lesson5box_midterm.setOnClickListener(){
            val intent = Intent(this, Lesson5::class.java)
            intent.putExtra("StudentNumber",StudentNumber.toString())
            startActivity(intent)
        }

        val lesson5p1box_midterm = findViewById<LinearLayout>(R.id.lesson5p1box_midterm)
        lesson5p1box_midterm.setOnClickListener(){
            val intent = Intent(this, Lesson_5_1::class.java)
            intent.putExtra("StudentNumber",StudentNumber.toString())
            startActivity(intent)
        }

        val lesson5p2box_midterm = findViewById<LinearLayout>(R.id.lesson5p2box_midterm)
        lesson5p2box_midterm.setOnClickListener(){
            val intent = Intent(this, Lesson_5_2::class.java)
            intent.putExtra("StudentNumber",StudentNumber.toString())
            startActivity(intent)
        }

        val lesson5p3box_midterm = findViewById<LinearLayout>(R.id.lesson5p3box_midterm)
        lesson5p3box_midterm.setOnClickListener(){
            val intent = Intent(this, Lesson_5_3::class.java)
            intent.putExtra("StudentNumber",StudentNumber.toString())
            startActivity(intent)
        }

        val lesson5p4box_midterm = findViewById<LinearLayout>(R.id.lesson5p4box_midterm)
        lesson5p4box_midterm.setOnClickListener(){
            val intent = Intent(this, Lesson_5_4::class.java)
            intent.putExtra("StudentNumber",StudentNumber.toString())
            startActivity(intent)
        }

    }
}