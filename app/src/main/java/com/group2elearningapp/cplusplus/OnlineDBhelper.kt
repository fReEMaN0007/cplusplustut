@file:Suppress("DEPRECATION")

package com.group2elearningapp.cplusplus

import android.os.AsyncTask
import android.widget.TextView
import org.json.JSONArray
import org.json.JSONObject
import java.io.BufferedReader
import java.io.InputStream
import java.io.InputStreamReader
import java.net.HttpURLConnection
import java.net.URL
import java.sql.Array
import java.util.concurrent.TimeUnit

class OnlineDBhelper {


     var sagot: String = ""
    var ari = emptyArray<String>()
    var acti = emptyArray<String>()
    var access = emptyArray<String>()

    fun search(URL:String): String {
           MyAsyncTask().execute(URL)

        return sagot
        }

    fun ito(): String {
        return sagot
    }

    fun all(URL: String):kotlin.Array<String>{

        MyAsyncTask2().execute(URL)
        return ari
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
            var json= JSONObject(values[0])
            val info= JSONArray(json.getString("info"))
            val usercredentials=info.getJSONObject(0)
            sagot= usercredentials.getString("DataVersion_OL")
        }catch(ex:Exception){}
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

    /////////2nd

    inner class MyAsyncTask2: AsyncTask<String, String, String>(){

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
            var json= JSONObject(values[0])
            val info= JSONArray(json.getString("info"))
            val usercredentials=info.getJSONObject(0)
            ari = arrayOf(usercredentials.getString("Name_OL"),//////0studentINfo
                        usercredentials.getString("Surname_OL"),//1
                        usercredentials.getString("Password_OL"),//2
                        usercredentials.getString("Gender_OL"),//3
                        usercredentials.getString("Email_OL"),//4
                        usercredentials.getString("Course_OL"),//5
                        usercredentials.getString("YearLvl_OL"),//6
                        usercredentials.getString("Section_OL"),//7
                        usercredentials.getString("DateRegistered_OL"),//8
                        usercredentials.getString("OverAllProgress_OL"),//9studentProgress
                        usercredentials.getString("Achievements_OL"),//10
                        usercredentials.getString("SkillChallenge_OL"),//11
                        usercredentials.getString("Prelim_OL"),//12
                        usercredentials.getString("Midterm_OL"),//13
                        usercredentials.getString("PreFinal_OL"),//14
                        usercredentials.getString("Finals_OL"),//15
                        usercredentials.getString("Activities_OL"),//16
                        usercredentials.getString("DataVersion_OL"),//17
                        usercredentials.getString("one_OL"),////////////18Prelim
                        usercredentials.getString("onePointOne_OL"),//19
                        usercredentials.getString("onePointTwo_OL"),//20
                        usercredentials.getString("onePointThree_OL"),//21
                        usercredentials.getString("two_OL"),//22
                        usercredentials.getString("twoPointOne_OL"),//23
                        usercredentials.getString("twoPointTwo_OL"),//24
                        usercredentials.getString("twoPointThree_OL"),//25
                        usercredentials.getString("three_OL"),//26
                        usercredentials.getString("four_OL"),/////////////27Midterm
                        usercredentials.getString("fourPointOne_OL"),//28
                        usercredentials.getString("five_OL"),//29
                        usercredentials.getString("fivePointOne_OL"),//30
                        usercredentials.getString("fivePointTwo_OL"),//31
                        usercredentials.getString("fivePointThree_OL"),//32
                        usercredentials.getString("fivePointFour_OL"),//33
                        usercredentials.getString("six_OL"),//////////////34PreFinal
                        usercredentials.getString("sixPointOne_OL"),//35
                        usercredentials.getString("sixPointTwo_OL"),//36
                        usercredentials.getString("sixPointThree_OL"),//37
                        usercredentials.getString("sixPointFour_OL"),//38
                        usercredentials.getString("seven_OL"),////////////39Final
                        usercredentials.getString("sevenPointOne_OL"),//40
                        usercredentials.getString("sevenPointTwo_OL"),//41
                        usercredentials.getString("sevenPointThree_OL"),//42
                        usercredentials.getString("sevenPointFour_OL"),//43
                        usercredentials.getString("eight_OL"),//44
                        usercredentials.getString("eightPointOne_OL"),//45
                        usercredentials.getString("eightPointTwo_OL"),//46

                        usercredentials.getString("PrelimAccess_OL"),//47 (late addition)
                        usercredentials.getString("MidtermAccess_OL"),//48 (late addition)
                        usercredentials.getString("PreFinalAccess_OL"),//49 (late addition)
                        usercredentials.getString("FinalsAccess_OL"))//50 (late addition)

        }catch(ex:Exception){}
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
///////////////////////////////////////////////////////////////////////////////
    inner class MyAsyncTask3: AsyncTask<String, String, String>(){

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
            var json= JSONObject(values[0])
            val info= JSONArray(json.getString("info"))
            val usercredentials=info.getJSONObject(0)
            acti= arrayOf(usercredentials.getString("Score1_OL"),usercredentials.getString("Score2_OL"),usercredentials.getString("Score3_OL"))


        }catch(ex:Exception){}
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
//////////////////////////////////////////////////////////////////////

    inner class MyAsyncTask4: AsyncTask<String, String, String>(){

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
            var json= JSONObject(values[0])
            val info= JSONArray(json.getString("info"))
            val usercredentials=info.getJSONObject(0)
            access= arrayOf(usercredentials.getString("PrelimAccess_OL"),usercredentials.getString("MidtermAccess_OL"),usercredentials.getString("PreFinalAccess_OL"),usercredentials.getString("FinalsAccess_OL"))


        }catch(ex:Exception){}
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