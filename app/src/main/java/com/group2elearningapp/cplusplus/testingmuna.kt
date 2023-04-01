@file:Suppress("DEPRECATION")

package com.group2elearningapp.cplusplus

import android.content.Intent
import android.os.AsyncTask
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import org.json.JSONArray
import org.json.JSONObject
import java.io.BufferedReader
import java.io.InputStream
import java.io.InputStreamReader
import java.net.HttpURLConnection
import java.net.URL

class testingmuna : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_testingmuna)

        lateinit var handler:DatabaseHelper
        handler = DatabaseHelper(this)
        val button = findViewById<Button>(R.id.button)
        val intToSTring = findViewById<EditText>(R.id.intToSTring)
        val stringToInt = findViewById<EditText>(R.id.stringToInt)

        val ari = emptyArray<String>()
        val itonanga:Int
        itonanga = intToSTring.text.toString().toInt()


        handler.insertToTesting(itonanga,"wala")

        val editTextTextMultiLine = findViewById<EditText>(R.id.editTextTextMultiLine)
        editTextTextMultiLine.requestFocus()









        val urlsearchstudentnumber = "http://bossfree-001-site1.dtempurl.com/readmodified.php?StudentNumber=1234"

        val getAll="http://bossfree-001-site1.dtempurl.com/getAll.php?StudentNumber=0217006223073"
        button.setOnClickListener(){
        MyAsyncTask().execute(getAll) }
        val tv = findViewById<TextView>(R.id.textView19)


   /*
        val urlStudentInfo = "http://bossfree-001-site1.dtempurl.com/singleInsertStudentInfo.php?StudentNumber=1234&Name=agelo&Surname=pogi&Password=999&Email=ffff&Gender=male&Course=CS&YearLvl=4th&Section=1"
        val urlStrudentProgress = "http://bossfree-001-site1.dtempurl.com/StudentProgresssingleInsert.php?ProgressId=46&StudentNumber=1234&OverAllProgress=25&Achievements=25&SkillChallenge=25&Prelim=25&Midterm=25&PreFinal=25&Finals=25&Activities=25&DataVerion=1"
        val urlPrelim = "http://bossfree-001-site1.dtempurl.com/PrelimSingleInsert.php?ProgressId=46&StudentNumber=1234&one=1&onePointOne=1&onePointTwo=1&onePointThree=1&two=1&twoPointOne=1&twoPointTwo=1&twoPointThree=1&Three=1"
        val urlMidterm = "http://bossfree-001-site1.dtempurl.com/MidtermSingleInsert.php?ProgressId=46&StudentNumber=1234&four=1&fourPointOne=1&five=1&fivePointOne=1&fivePointTwo=1&fivePointThree=1&fivePointFour=1"
        val urlPreFinal = "http://bossfree-001-site1.dtempurl.com/PreFinalSingleInsert.php?ProgressId=46&StudentNumber=1234&six=1&sixPointOne=1&sixPointTwo=1&sixPointThree=1&sixPointFour=1"
        val urlFinal = "http://bossfree-001-site1.dtempurl.com/FinalSingleInsert.php?ProgressId=46&StudentNumber=1234&seven=1&sevenPointOne=1&sevenPointTwo=1&sevenPointThree=1&sevenPointFour=1&eight=1&eightPointOne=1&eightPointTwo=1"

        MyAsyncTask().execute(urlStudentInfo)
        MyAsyncTask().execute(urlStrudentProgress)
        MyAsyncTask().execute(urlPrelim)
        MyAsyncTask().execute(urlMidterm)
        MyAsyncTask().execute(urlPreFinal)
        MyAsyncTask().execute(urlFinal)*/

        }

    inner class MyAsyncTask: AsyncTask<String, String, String>(){

        override fun onPreExecute(){
        }

        override fun doInBackground(vararg p0: String?): String{
            try{
                val url= URL(p0[0])
                val urlConnect=url.openConnection() as HttpURLConnection
                urlConnect.connectTimeout=7000

                var inString=ConvertStreamToString(urlConnect.inputStream)
                publishProgress(inString)
            }catch (ex:Exception){}

            return ""
        }

        override fun onProgressUpdate(vararg values: String?) = try{
            var json=JSONObject(values[0])
            val info=JSONArray(json.getString("info"))
            val usercredentials=info.getJSONObject(0)
            val tv = findViewById<TextView>(R.id.textView19)
            //tv.text=usercredentials.getString("Name_OL")
            val ari = arrayOf(usercredentials.getString("Name_OL"))
            tv.text=ari[0]

        }catch(ex:Exception){  val tv = findViewById<TextView>(R.id.textView19)
            tv.text= "gago"


        }

        override fun onPostExecute(result: String?){

        }


        fun ConvertStreamToString(inputStream: InputStream):String{

            val bufferReader= BufferedReader(InputStreamReader(inputStream))
            var line:String
            var AllString:String=""

            try{

                do{
                    line=bufferReader.readLine()
                    if(line!=null){
                        AllString+=line
                    }
                }while (line!=null)
                inputStream.close()
            }catch (ex:Exception){}

            return AllString
        }


    }
}
