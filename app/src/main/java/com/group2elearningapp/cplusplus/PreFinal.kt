package com.group2elearningapp.cplusplus

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.LinearLayout

class PreFinal : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pre_final)

        val intent = intent
        var StudentNumber= intent.getStringExtra("StudentNumber")

        val lesson6box_Prefinal = findViewById<LinearLayout>(R.id.lesson6box_Prefinal)
        lesson6box_Prefinal.setOnClickListener(){
            val intent = Intent(this, Lesson6::class.java)
            intent.putExtra("StudentNumber",StudentNumber.toString())
            startActivity(intent)
        }

        val lesson6p1box_Prefinal = findViewById<LinearLayout>(R.id.lesson6p1box_Prefinal)
        lesson6p1box_Prefinal.setOnClickListener(){
            val intent = Intent(this, Lesson_6_1::class.java)
            intent.putExtra("StudentNumber",StudentNumber.toString())
            startActivity(intent)
        }

        val lesson6p2box_Prefinal = findViewById<LinearLayout>(R.id.lesson6p2box_Prefinal)
        lesson6p2box_Prefinal.setOnClickListener(){
            val intent = Intent(this, Lesson_6_2::class.java)
            intent.putExtra("StudentNumber",StudentNumber.toString())
            startActivity(intent)
        }

        val lesson6p3box_Prefinal = findViewById<LinearLayout>(R.id.lesson6p3box_Prefinal)
        lesson6p3box_Prefinal.setOnClickListener(){
            val intent = Intent(this, Lesson_6_3::class.java)
            intent.putExtra("StudentNumber",StudentNumber.toString())
            startActivity(intent)
        }

        val lesson6p4box_Prefinal = findViewById<LinearLayout>(R.id.lesson6p4box_Prefinal)
        lesson6p4box_Prefinal.setOnClickListener(){
            val intent = Intent(this, Lesson_6_4::class.java)
            intent.putExtra("StudentNumber",StudentNumber.toString())
            startActivity(intent)
        }
    }
}