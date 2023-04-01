package com.group2elearningapp.cplusplus

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.gson.GsonBuilder
import okhttp3.*
import okio.IOException

class teacherSearchResult : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_teacher_search_result)


        var search = ""
        var course = ""
        var year = ""
        var section= ""
        var indicator=""

        var intent = intent
        search = intent.getStringExtra("search").toString()
        course = intent.getStringExtra("course").toString()
        year = intent.getStringExtra("year").toString()
        section = intent.getStringExtra("section").toString()
        indicator = intent.getStringExtra("indicator").toString()



        Toast.makeText(this, search, Toast.LENGTH_SHORT).show()

        val recycle = findViewById<RecyclerView>(R.id.result_Recycler)
        /*recycle.setBackgroundColor(Color.GRAY)*/
        recycle.layoutManager = LinearLayoutManager(this)

        getJson(search,course,year,section,indicator)
    }

    fun getJson(search:String,course:String,year:String,section:String,indicator:String) {
        var url = ""

        if (indicator=="1"){
            url="http://bossfree-001-site1.dtempurl.com/Binagoreadall.php?Search=$search"
        } else if (indicator=="2"){
            url="http://bossfree-001-site1.dtempurl.com/searchbyclass.php?Course=$course&Section=$section&Yearlvl=$year"
        }
        else{url="http://bossfree-001-site1.dtempurl.com/leaderboard.php"}

        val request = Request.Builder().url(url).build()
        val client = OkHttpClient()
        client.newCall(request).enqueue(object : Callback {
            override fun onResponse(call: Call, response: Response) {
                val body = response.body?.string()

                val gson = GsonBuilder().create()
                val resulta = gson.fromJson(body, Resulta::class.java)
                val tanga = findViewById<TextView>(R.id.textView12)

                runOnUiThread() {
                val recycle = findViewById<RecyclerView>(R.id.result_Recycler)
                recycle.adapter = resultaadapter(resulta, tanga,indicator)
            }

            }

            override fun onFailure(call: Call, e: IOException) {

            }
        })

    }

}
class Resulta(val info: List<Students>)
class Students(val Name_OL: String, val Surname_OL: String, val StudentNumber_OL:String,val YearLvl_OL:String,val Section_OL:String,val Course_OL:String,
               val OverAllProgress_OL:String,val Achievements_OL:String, val SkillChallenge_OL:String, val Prelim_OL:String,
                val Midterm_OL:String,val PreFinal_OL:String, val Finals_OL:String, val Activities_OL:String,
                val DateRegistered_OL:String, val LatestSync_OL:String, val Activity1_OL:String, val Activity2_OL:String, val Activity3_OL:String,
               val Score1_OL:String,val Score2_OL:String,val Score3_OL:String)