package com.group2elearningapp.cplusplus

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.LinearLayout

class Finals : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_finals)

        val intent = intent
        var StudentNumber= intent.getStringExtra("StudentNumber")

        val lesson7box_finals = findViewById<LinearLayout>(R.id.lesson7box_finals)
        lesson7box_finals.setOnClickListener(){
            val intent = Intent(this, Lesson7::class.java)
            intent.putExtra("StudentNumber",StudentNumber.toString())
            startActivity(intent)
        }

        val lesson7p1box_finals = findViewById<LinearLayout>(R.id.lesson7p1box_finals)
        lesson7p1box_finals.setOnClickListener(){
            val intent = Intent(this, Lesson_7_1::class.java)
            intent.putExtra("StudentNumber",StudentNumber.toString())
            startActivity(intent)
        }

        val lesson7p2box_finals = findViewById<LinearLayout>(R.id.lesson7p2box_finals)
        lesson7p2box_finals.setOnClickListener(){
            val intent = Intent(this, Lesson_7_2::class.java)
            intent.putExtra("StudentNumber",StudentNumber.toString())
            startActivity(intent)
        }

        val lesson7p3box_finals = findViewById<LinearLayout>(R.id.lesson7p3box_finals)
        lesson7p3box_finals.setOnClickListener(){
            val intent = Intent(this, Lesson_7_3::class.java)
            intent.putExtra("StudentNumber",StudentNumber.toString())
            startActivity(intent)
        }

        val lesson7p4box_finals = findViewById<LinearLayout>(R.id.lesson7p4box_finals)
        lesson7p4box_finals.setOnClickListener(){
            val intent = Intent(this, Lesson_7_4::class.java)
            intent.putExtra("StudentNumber",StudentNumber.toString())
            startActivity(intent)
        }

        val lesson8box_finals = findViewById<LinearLayout>(R.id.lesson8box_finals)
        lesson8box_finals.setOnClickListener(){
            val intent = Intent(this, Lesson8::class.java)
            intent.putExtra("StudentNumber",StudentNumber.toString())
            startActivity(intent)
        }

        val lesson8p1box_finals = findViewById<LinearLayout>(R.id.lesson8p1box_finals)
        lesson8p1box_finals.setOnClickListener(){
            val intent = Intent(this, Lesson_8_1::class.java)
            intent.putExtra("StudentNumber",StudentNumber.toString())
            startActivity(intent)
        }

        val lesson8p2box_finals = findViewById<LinearLayout>(R.id.lesson8p2box_finals)
        lesson8p2box_finals.setOnClickListener(){
            val intent = Intent(this, Lesson_8_2::class.java)
            intent.putExtra("StudentNumber",StudentNumber.toString())
            startActivity(intent)
        }
    }
}