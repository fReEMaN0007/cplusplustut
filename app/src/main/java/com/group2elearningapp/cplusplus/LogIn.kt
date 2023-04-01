package com.group2elearningapp.cplusplus

import android.content.Intent
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Build
import android.os.Bundle
import android.os.CountDownTimer
import android.view.animation.AnimationUtils
import android.widget.*
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isInvisible
import androidx.core.view.isVisible

class LogIn : AppCompatActivity() {

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_log_in)

        lateinit var handler: DatabaseHelper
        lateinit var onlinehandler: OnlineDBhelper
        handler = DatabaseHelper(this)
        onlinehandler = OnlineDBhelper()


        //intent from mainactivity
        val intent = intent
        val userIndicatorLogin = intent.getStringExtra("UserIndicator").toString()
        val userIndicator2Login = intent.getStringExtra("UserIndicator2").toString()

        /////////////////////////ActionBar
        val actionbar = supportActionBar
        actionbar!!.title = "$userIndicatorLogin Log In"
        val colorDrawable = ColorDrawable(Color.parseColor("#FF018786"))
        actionbar!!.setBackgroundDrawable(colorDrawable)
        /////////////////////////ActionBar

        val tvUser = findViewById<TextView>(R.id.TvUser_Login)
        tvUser.text = userIndicator2Login + " No."

        val EditTextStudentNumber = findViewById<EditText>(R.id.EditTextStudentNumber)
        val EditTextPassword = findViewById<EditText>(R.id.EditTextPassword)
        var StudentNumber = ""
        var Password = ""
        val LogInBtn = findViewById<Button>(R.id.LogInBtn)
        val LoginMessage = AlertDialog.Builder(this)
        val alertBox = findViewById<LinearLayout>(R.id.alertBox)
        val alertYes= findViewById<Button>(R.id.alertYes)
        val alertNo= findViewById<Button>(R.id.alertNo)
        val creatNewAccountBtnLogin = findViewById<Button>(R.id.CreateNewAccountBtn_Login)


        val logintimer = object : CountDownTimer(3000, 1000) {
            override fun onTick(millisUntilFinished: Long) {
               // onlinehandler.MyAsyncTask4().execute(urlgetaccess)
                val progressbar = findViewById<ProgressBar>(R.id.progressBar)
                progressbar.isVisible = true
                val onlineLoginGetAll = "http://bossfree-001-site1.dtempurl.com/onlineLoginGetall.php?StudentNumber=$StudentNumber&Password=$Password"
                onlinehandler.MyAsyncTask2().execute(onlineLoginGetAll)

            }

            override fun onFinish() {
                val progressbar = findViewById<ProgressBar>(R.id.progressBar)
                progressbar.isInvisible = true

                try {
                    handler.insertUserData(onlinehandler.ari[0], onlinehandler.ari[1], onlinehandler.ari[4], StudentNumber, onlinehandler.ari[5],
                        onlinehandler.ari[6], onlinehandler.ari[7], onlinehandler.ari[3], onlinehandler.ari[2],
                        1, "online", onlinehandler.ari[8])
                    handler.insertInitialProgress(StudentNumber)
                    handler.insertInitialPrelim(StudentNumber)
                    handler.insertInitialMidterm(StudentNumber)
                    handler.insertInitialPreFinal(StudentNumber)
                    handler.insertInitialFinal(StudentNumber)


                    handler.updatefromOLProgress(StudentNumber, onlinehandler.ari[9].toInt(), onlinehandler.ari[10].toInt(), onlinehandler.ari[11].toInt(),
                        onlinehandler.ari[12].toInt(), onlinehandler.ari[13].toInt(), onlinehandler.ari[14].toInt(), onlinehandler.ari[15].toInt(),
                        onlinehandler.ari[16].toInt(), onlinehandler.ari[17].toInt(), onlinehandler.ari[50], onlinehandler.ari[51],onlinehandler.ari[52],onlinehandler.ari[53])

                    handler.updatefromOLPrelim(onlinehandler.ari[18].toInt(), onlinehandler.ari[19].toInt(), onlinehandler.ari[20].toInt(), onlinehandler.ari[21].toInt(),
                        onlinehandler.ari[22].toInt(), onlinehandler.ari[23].toInt(), onlinehandler.ari[24].toInt(), onlinehandler.ari[25].toInt(),
                        onlinehandler.ari[26].toInt()
                    )
                    /////KULANG PA NG UPDATE PREFINAL AT FINALS

                    alertBox.isVisible=false
                    creatNewAccountBtnLogin.isEnabled=true
                } catch (ex: Exception) {
                    val animation = AnimationUtils.loadAnimation(this@LogIn, R.anim.fadeout)
                    alertBox.startAnimation(animation)
                    alertBox.isVisible=false
                    creatNewAccountBtnLogin.isEnabled=true

                }
            }
        }



        LogInBtn.setOnClickListener() {
            if (userIndicatorLogin == "Student") {
                if (handler.userLogin(
                        EditTextStudentNumber.text.toString(),
                        EditTextPassword.text.toString(),
                        1
                    )
                ) {
                    val intent = Intent(this, StudentDashBoard::class.java)
                    intent.putExtra("StudentNumber", EditTextStudentNumber.text.toString())
                    startActivity(intent)
                } else {//////////////////////////////////////////////////////////////////////////////////////////////////////
                    StudentNumber = EditTextStudentNumber.text.toString()
                    Password = EditTextPassword.text.toString()
                    creatNewAccountBtnLogin.isEnabled=false
                    val animation = AnimationUtils.loadAnimation(this, R.anim.fadein)
                    alertBox.startAnimation(animation)
                    alertBox.isVisible=true


                    alertNo.setOnClickListener(){
                        val animation = AnimationUtils.loadAnimation(this, R.anim.fadeout)
                        alertBox.startAnimation(animation)
                        alertBox.isVisible=false
                        creatNewAccountBtnLogin.isEnabled=true
                    }
                    //////  YES  /////
                    alertYes.setOnClickListener(){
                        logintimer.start()
                    }


                    Toast.makeText(this, "Invalid Login", Toast.LENGTH_SHORT).show()
                }
            } else {
                if (handler.userLogin(
                        EditTextStudentNumber.text.toString(),
                        EditTextPassword.text.toString(),
                        2
                    )
                ) {
                    val intent = Intent(this, TeacherDashboard::class.java)
                    intent.putExtra("StudentNumber", EditTextStudentNumber.text.toString())
                    startActivity(intent)
                } else {
                    Toast.makeText(this, "Invalid Login", Toast.LENGTH_SHORT).show()
                }

            }
        }


        /*val SyncMessage = AlertDialog.Builder(this)
        SyncMessage.setTitle("Greetings!")
        SyncMessage.setMessage("Thank you for using C++ Tutorial App")
//builder.setPositiveButton("OK", DialogInterface.OnClickListener(function = x))

        SyncMessage.setPositiveButton("Continue") { dialog, which ->

            //Toast.makeText(applicationContext,
            //android.R.string.yes, Toast.LENGTH_SHORT).show()
            handler.insertUserData(
                onlinehandler.ari[0],
                onlinehandler.ari[1],
                onlinehandler.ari[4],
                StudentNumber,
                onlinehandler.ari[5],
                onlinehandler.ari[6],
                onlinehandler.ari[7],
                onlinehandler.ari[3],
                onlinehandler.ari[2],
                1,
                "online",
                onlinehandler.ari[8]
            )
            handler.insertInitialProgress(StudentNumber)
            handler.insertInitialPrelim(StudentNumber)
            handler.insertInitialMidterm(StudentNumber)
            handler.insertInitialPreFinal(StudentNumber)
            handler.insertInitialFinal(StudentNumber)
            handler.updatefromOLProgress(
                StudentNumber,
                onlinehandler.ari[9].toInt(),
                onlinehandler.ari[10].toInt(),
                onlinehandler.ari[11].toInt(),
                onlinehandler.ari[12].toInt(),
                onlinehandler.ari[13].toInt(),
                onlinehandler.ari[14].toInt(),
                onlinehandler.ari[15].toInt(),
                onlinehandler.ari[16].toInt(),
                onlinehandler.ari[17].toInt()
            )
            handler.updatefromOLPrelim(
                onlinehandler.ari[18].toInt(),
                onlinehandler.ari[19].toInt(),
                onlinehandler.ari[20].toInt(),
                onlinehandler.ari[21].toInt(),
                onlinehandler.ari[22].toInt(),
                onlinehandler.ari[23].toInt(),
                onlinehandler.ari[24].toInt(),
                onlinehandler.ari[25].toInt(),
                onlinehandler.ari[26].toInt()
            )
            /////KULANG PA NG UPDATE PREFINAL AT FINALS


            val intent = Intent(this, StudentDashBoard::class.java)
            intent.putExtra("StudentNumber", StudentNumber)
            startActivity(intent)

        }*/


       /* LoginMessage.setTitle("Greetings!")
        LoginMessage.setMessage("Thank you for using C++ Tutorial App")
//builder.setPositiveButton("OK", DialogInterface.OnClickListener(function = x))

        LoginMessage.setPositiveButton("Continue") { dialog, which ->

            val onlineLoginGetAll =
                "http://bossfree-001-site1.dtempurl.com/onlineLoginGetall.php?StudentNumber=$StudentNumber&Password=$Password"
            onlinehandler.MyAsyncTask2().execute(onlineLoginGetAll)

            SyncMessage.show()

            /* val intent = Intent(this, StudentDashBoard::class.java)
             intent.putExtra("StudentNumber", StudentNumber)
             startActivity(intent)*/

            //Toast.makeText(applicationContext,
            //android.R.string.yes, Toast.LENGTH_SHORT).show()
        }
        */



        creatNewAccountBtnLogin.setOnClickListener() {
            if (userIndicatorLogin == "Student") {
                val intent = Intent(this, StudentNewAccount::class.java)
                startActivity(intent)
            } else {
                val intent = Intent(this, TecherNewAccount::class.java)
                startActivity(intent)
            }
        }


    }

}
