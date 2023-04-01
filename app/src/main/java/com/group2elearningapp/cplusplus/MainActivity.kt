package com.group2elearningapp.cplusplus

import android.content.Intent
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.widget.Button
import android.widget.RadioButton
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity




class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


         val intent = Intent(this, testingmuna::class.java)
           //startActivity(intent)
            /////////////////////////ActionBar
            val actionbar = supportActionBar
            actionbar!!.title = ""
            val colorDrawable = ColorDrawable(Color.parseColor("#FF018786"))
            actionbar!!.setBackgroundDrawable(colorDrawable)
            /////////////////////////ActionBar

            ///////NEXT ACTIVITY
            val button = findViewById<Button>(R.id.ContinueButton_Main)
            button.setOnClickListener() {

                    ////RADIO BUTTONS
                    val RbStudent_Main = findViewById<RadioButton>(R.id.RbStudent_Main)
                    val RbTeacher_Main = findViewById<RadioButton>(R.id.RbTeacher_Main)
                    if (RbStudent_Main.isChecked) {
                        val randomInteger = (1..12).shuffled().first()
                        Toast.makeText(this, "Student Selected", Toast.LENGTH_SHORT).show()
                        Toast.makeText(this, randomInteger.toString(), Toast.LENGTH_SHORT).show()
                        val intent = Intent(this, LogIn::class.java)
                        intent.putExtra("UserIndicator", "Student")
                        intent.putExtra("UserIndicator2", "Student")

                        startActivity(intent)

                    }
                    else if (RbTeacher_Main.isChecked) {
                        Toast.makeText(this, "Teacher Selected", Toast.LENGTH_SHORT).show()
                        val intent = Intent(this, LogIn::class.java)
                        intent.putExtra("UserIndicator", "Teacher")
                        intent.putExtra("UserIndicator2", "Employee")
                        startActivity(intent)
                    }
                    ////RADIO BUTTONS
            }
            ///////NEXT ACTIVITY
    }
}