package com.group2elearningapp.cplusplus

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class Achivements : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_achivements)




     val recycle = findViewById<RecyclerView>(R.id.RecyclerviewLesson2)
     /*recycle.setBackgroundColor(Color.GRAY)*/
     recycle.layoutManager = LinearLayoutManager(this)
     recycle.adapter = mainAdapter()
    }
}