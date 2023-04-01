package com.group2elearningapp.cplusplus

import android.content.Intent
import android.database.sqlite.SQLiteDatabase
import android.graphics.Color.rgb
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.FrameLayout
import android.widget.TextView
import androidx.core.view.isInvisible

class Activities : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_activities)

        val StudentNumber = intent.getStringExtra("StudentNumber").toString()



        var activity1=""
        var activity2=""
        var activity3=""
        lateinit var handler: DatabaseHelper
        handler = DatabaseHelper(this)
        lateinit var onlinehandler: OnlineDBhelper
        onlinehandler = OnlineDBhelper()
        var db: SQLiteDatabase = handler.readableDatabase
        val query = "select * from Activity where StudentNumber= '$StudentNumber'"
        val cursor = db.rawQuery(query, null)
        if (cursor.moveToFirst()) {
            activity1=cursor.getString(5)
            activity2 = cursor.getString(6)
            activity3 = cursor.getString(7)
        cursor.close()}
        if (activity1!="0"){
            val act1Complete = findViewById<TextView>(R.id.act1Complete)
            act1Complete.isInvisible=false
            val tvScore1 = findViewById<TextView>(R.id.tvScore1)
            tvScore1.text = "Gained Score:\n"+activity1
            tvScore1.setTextColor(rgb(132,255,0))
        }
        if (activity2!="0"){
            val act2Complete = findViewById<TextView>(R.id.act2Complete)
            act2Complete.isInvisible=false
            val tvScore2 = findViewById<TextView>(R.id.tvScore2)
            tvScore2.text = "Gained Score:\n"+activity2
            tvScore2.setTextColor(rgb(132,255,0))
        }
        if (activity3!="0"){
            val act3Complete = findViewById<TextView>(R.id.act3Complete)
            act3Complete.isInvisible=false
            val tvScore3 = findViewById<TextView>(R.id.tvScore3)
            tvScore3.text = "Gained Score:\n"+activity3
            tvScore3.setTextColor(rgb(132,255,0))
        }

        val activity1Frame = findViewById<FrameLayout>(R.id.activity1Frame)
            activity1Frame.setOnClickListener(){
                if (activity1=="1"){
                    val intent = Intent(this, Activity_1_1::class.java)
                    startActivity(intent)
                }
                else if (activity1=="2"){
                    val intent = Intent(this, Activity_1_2::class.java)
                    startActivity(intent)
                }
                else{
                    val intent = Intent(this, Activity_1_3::class.java)
                    startActivity(intent)
                }
            }

        val activity2Frame = findViewById<FrameLayout>(R.id.activity2Frame)
        activity2Frame.setOnClickListener(){
            if (activity2=="1"){
                val intent = Intent(this, Activity_2_1::class.java)
                startActivity(intent)
            }
            else if (activity2=="2"){
                val intent = Intent(this, Activity_2_2::class.java)
                startActivity(intent)
            }
            else{
                val intent = Intent(this, Activity_2_3::class.java)
                startActivity(intent)
            }
        }

        val activity3Frame = findViewById<FrameLayout>(R.id.activity3Frame)
        activity3Frame.setOnClickListener(){
            if (activity3=="1"){
                val intent = Intent(this, Activity_2_1::class.java)
                startActivity(intent)
            }
            else if (activity3=="2"){
                val intent = Intent(this, Activity_2_2::class.java)
                startActivity(intent)
            }
            else{
                val intent = Intent(this, Activity_2_3::class.java)
                startActivity(intent)
            }
        }











        /*val recycle = findViewById<RecyclerView>(R.id.activitiesRecyclerview)
        /*recycle.setBackgroundColor(Color.GRAY)*/
        recycle.layoutManager = LinearLayoutManager(this)
        recycle.adapter = activityAdaptor(studentNumber)*/
    }


}