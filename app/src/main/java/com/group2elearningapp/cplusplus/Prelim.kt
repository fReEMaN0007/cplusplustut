package com.group2elearningapp.cplusplus

import android.content.Intent
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.LinearLayout

class Prelim : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_prelim)

        /////////////////////////ActionBar
        val actionbar = supportActionBar
        actionbar!!.title = "PRELIM"
        val colorDrawable = ColorDrawable(Color.parseColor("#FF018786"))
        actionbar!!.setBackgroundDrawable(colorDrawable)
        /////////////////////////ActionBar

        val intent = intent
        var StudentNumber= intent.getStringExtra("StudentNumber")

        val lesson1box = findViewById<LinearLayout>(R.id.lesson1box)
        lesson1box.setOnClickListener(){
            val intent = Intent(this, Lesson1::class.java)
            intent.putExtra("StudentNumber",StudentNumber.toString())
            startActivity(intent)
        }

        val lesson2box = findViewById<LinearLayout>(R.id.lesson1p1box)
        lesson2box.setOnClickListener(){
            val intent = Intent(this, Lesson_1_1::class.java)
            intent.putExtra("StudentNumber",StudentNumber.toString())
            startActivity(intent)
        }

        val lesson1p2box = findViewById<LinearLayout>(R.id.lesson1p2box)
        lesson1p2box.setOnClickListener(){
            val intent = Intent(this, Lesson_1_2::class.java)
            intent.putExtra("StudentNumber",StudentNumber.toString())
            startActivity(intent)
        }
        val lesson1p3box = findViewById<LinearLayout>(R.id.lesson1p3box)
        lesson1p3box.setOnClickListener(){
            val intent = Intent(this, Lesson_1_3::class.java)
            intent.putExtra("StudentNumber",StudentNumber.toString())
            startActivity(intent)
        }

        val lesson2ox = findViewById<LinearLayout>(R.id.lesson2box)
        lesson2ox.setOnClickListener(){
            val intent = Intent(this, Lesson2::class.java)
            intent.putExtra("StudentNumber",StudentNumber.toString())
            startActivity(intent)
        }

        val lesson2p1box = findViewById<LinearLayout>(R.id.lesson2p1box)
        lesson2p1box.setOnClickListener(){
            val intent = Intent(this, Lesson_2_1::class.java)
            intent.putExtra("StudentNumber",StudentNumber.toString())
            startActivity(intent)
        }

        val lesson2p2box = findViewById<LinearLayout>(R.id.lesson2p2box)
        lesson2p2box.setOnClickListener(){
            val intent = Intent(this, Lesson_2_2::class.java)
            intent.putExtra("StudentNumber",StudentNumber.toString())
            startActivity(intent)
        }

        val lesson2p3box = findViewById<LinearLayout>(R.id.lesson2p3box)
        lesson2p3box.setOnClickListener(){
            val intent = Intent(this, Lesson_2_3::class.java)
            intent.putExtra("StudentNumber",StudentNumber.toString())
            startActivity(intent)
        }

        val lesson3box = findViewById<LinearLayout>(R.id.lesson3box)
        lesson3box.setOnClickListener(){
            val intent = Intent(this, Lesson3::class.java)
            intent.putExtra("StudentNumber",StudentNumber.toString())
            startActivity(intent)
        }
        /*
        val recycle = findViewById<RecyclerView>(R.id.RecyclerviewLesson)
        /*recycle.setBackgroundColor(Color.GRAY)*/
        recycle.layoutManager = LinearLayoutManager(this)
        recycle.adapter = mainAdapter()*/


    }
    }
