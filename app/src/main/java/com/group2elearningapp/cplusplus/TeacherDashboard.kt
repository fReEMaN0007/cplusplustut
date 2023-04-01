package com.group2elearningapp.cplusplus

import android.annotation.SuppressLint
import android.content.Intent
import android.database.sqlite.SQLiteDatabase
import android.graphics.Color.rgb
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import android.view.MotionEvent
import android.view.View
import android.widget.*
import androidx.appcompat.app.AlertDialog
import androidx.core.view.isGone
import androidx.core.view.isInvisible
import androidx.core.view.isVisible

class TeacherDashboard : AppCompatActivity() {
    @SuppressLint("ClickableViewAccessibility")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_teacher_dashboard)


        var intent = intent
        val StudnetNumber = intent.getStringExtra("StudentNumber").toString()
        var gender = ""

        lateinit var onlinehandler: OnlineDBhelper
        onlinehandler = OnlineDBhelper()


        lateinit var handler: DatabaseHelper
        handler = DatabaseHelper(this)


        // val noticebox = findViewById<LinearLayout>(R.id.noticebox)
        val retry = findViewById<Button>(R.id.retry)
        var dummyCourse = findViewById<TextView>(R.id.dummyCourse)
        var dummyC = ""
        var dummyYear = findViewById<TextView>(R.id.dummyYear)
        var dummyY = ""
        var dummySection = findViewById<TextView>(R.id.dummySection)
        var dummyS = ""

        var db: SQLiteDatabase = handler.readableDatabase
        val query = "select * from teacherInfo where EmployeeNumber= '$StudnetNumber'"
        val cursor = db.rawQuery(query, null)
        if (cursor.moveToFirst()) {
            val tvNameStudentDashboard = findViewById<TextView>(R.id.tvNameStudentDashboard)
            tvNameStudentDashboard.text = cursor.getString(2)
            val tvSurnameStudentDashboard = findViewById<TextView>(R.id.tvSurnameStudentDashboard)
            tvSurnameStudentDashboard.text = cursor.getString(3)
            val tvCourseStudentDashboard = findViewById<TextView>(R.id.tvCourseStudentDashboard)
            tvCourseStudentDashboard.text = "Instructor"

            var slicenumber1 = StudnetNumber.toString()
            var slicenumber2 = StudnetNumber.toString()
            var slicenumber3 = StudnetNumber.toString()

            val tvStudentNUmberStudentDashboard =
                findViewById<TextView>(R.id.tvStudentNUmberStudentDashboard)
            tvStudentNUmberStudentDashboard.text = slicenumber1.slice(0..2).toString()

            val tvStudentNUmberStudentDashboard2 =
                findViewById<TextView>(R.id.tvStudentNUmberStudentDashboard2)
            tvStudentNUmberStudentDashboard2.text = slicenumber2.slice(3..8).toString()

            val tvStudentNUmberStudentDashboard3 =
                findViewById<TextView>(R.id.tvStudentNUmberStudentDashboard3)
            tvStudentNUmberStudentDashboard3.text = slicenumber3.slice(9..11).toString()
            gender = cursor.getString(4)
        }
        if (gender == "Male") {
            val ivDisplayPictureTeacherDashboard =
                findViewById<ImageView>(R.id.ivDisplayPictureTeacherDashboard)
            ivDisplayPictureTeacherDashboard.setImageResource(R.drawable.instructormale)
        } else {
            val ivDisplayPictureTeacherDashboard =
                findViewById<ImageView>(R.id.ivDisplayPictureTeacherDashboard)
            ivDisplayPictureTeacherDashboard.setImageResource(R.drawable.instructorfemale)
        }


        val seachButton = findViewById<Button>(R.id.seachButton)
        val searchbox = findViewById<EditText>(R.id.searchbox)

        seachButton.setOnClickListener() {
            val extra = searchbox.text.toString()
            val intent = Intent(this, teacherSearchResult::class.java)
            intent.putExtra("search", extra.toString())
            intent.putExtra("indicator", "1")
            startActivity(intent)
        }

        var optionSpinnerCourse = arrayOf("ComSci", "InfoSys")
        var spinnerCourseTeacher = findViewById<Spinner>(R.id.spinnerCourseTeacher)
        spinnerCourseTeacher.adapter =
            ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, optionSpinnerCourse)
        spinnerCourseTeacher.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                var dummyCourse = findViewById<TextView>(R.id.dummyCourse)
                dummyCourse.text = optionSpinnerCourse.get(position)


                if (optionSpinnerCourse.get(position) == "ComSci") {
                    dummyCourse.text = "CS"
                } else {
                    dummyCourse.text = "IS"
                }
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {
            }
        }

        var optionSpinnerYearlvl = arrayOf("1", "2", "3", "4")
        var spinnerYearlvlTeacher = findViewById<Spinner>(R.id.spinnerYearlvlTeacher)
        spinnerYearlvlTeacher.adapter =
            ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, optionSpinnerYearlvl)
        spinnerYearlvlTeacher.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                var dummyYear = findViewById<TextView>(R.id.dummyYear)
                dummyYear.text = optionSpinnerYearlvl.get(position)
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {
            }
        }

        var optionSpinnerSection = arrayOf("1", "2", "3", "4")
        var spinnerSectionTeacher = findViewById<Spinner>(R.id.spinnerSectionTeacher)
        spinnerSectionTeacher.adapter =
            ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, optionSpinnerSection)
        spinnerSectionTeacher.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                var dummySection = findViewById<TextView>(R.id.dummySection)
                dummySection.text = optionSpinnerSection.get(position)

            }

            override fun onNothingSelected(parent: AdapterView<*>?) {
            }
        }

        val btnPrelimStudentDashboard = findViewById<Button>(R.id.SearchByClass)
        btnPrelimStudentDashboard.setOnClickListener() {


            val intent = Intent(this, teacherSearchResult::class.java)
            intent.putExtra("course", dummyCourse.text.toString())
            intent.putExtra("year", dummyYear.text.toString())
            intent.putExtra("section", dummySection.text.toString())
            intent.putExtra("indicator", "2")

            startActivity(intent)
        }


        val confimation = AlertDialog.Builder(this)
        confimation.setTitle("Greetings!")
        confimation.setMessage("Thank you for using C++ Tutorial App")
//builder.setPositiveButton("OK", DialogInterface.OnClickListener(function = x))

        confimation.setPositiveButton("Continue") { dialog, which ->

            //Toast.makeText(applicationContext,
            //android.R.string.yes, Toast.LENGTH_SHORT).show()
        }


        val confimationmidterm = AlertDialog.Builder(this)
        confimation.setTitle("Greetings!")
        confimation.setMessage("Do you want to change the accessability of Midterm?")
//builder.setPositiveButton("OK", DialogInterface.OnClickListener(function = x))

        confimation.setPositiveButton("Continue") { dialog, which ->

            //Toast.makeText(applicationContext,
            //android.R.string.yes, Toast.LENGTH_SHORT).show()
        }


        val urlgetaccess =
            "http://bossfree-001-site1.dtempurl.com/getAccess.php?Course=${dummyCourse.text.toString()}&Yearlvl=${dummyYear.text.toString()}&Section=${dummySection.text.toString()}"
        val prelimAccess = findViewById<Button>(R.id.prelimAccess)
        val midtermAccess = findViewById<Button>(R.id.midtermAccess)
        val prefinalAccess = findViewById<Button>(R.id.prefinalAccess)
        val finalsAccess = findViewById<Button>(R.id.finalsAccess)
        var pr = ""
        var md = ""
        var pf = ""
        var fn = ""
        val tvDoyou = findViewById<TextView>(R.id.tvDoyou)
        val tvPlease = findViewById<TextView>(R.id.tvPlease)
        val alertBox = findViewById<LinearLayout>(R.id.alertBox)
        var code = 0
        val etCode = findViewById<EditText>(R.id.etCode)




        prelimAccess.setOnClickListener() {
            Toast.makeText(this, "Prelim is already Unlocked by default", Toast.LENGTH_SHORT).show()
        }

        midtermAccess.setOnClickListener() {
            dummyC = dummyCourse.text.toString()
            dummyY = dummyYear.text.toString()
            dummyS = dummySection.text.toString()
            var BlockID = dummyC + dummyY + dummyS

            val urlgetaccess = "http://bossfree-001-site1.dtempurl.com/getAccess.php?BlockID=$BlockID"
            Toast.makeText(this, dummySection.text.toString(), Toast.LENGTH_SHORT).show()
            val timer = object : CountDownTimer(3000, 1000) {
                override fun onTick(millisUntilFinished: Long) {
                    onlinehandler.MyAsyncTask4().execute(urlgetaccess)
                    val harang = findViewById<Button>(R.id.harang)
                    harang.isVisible = true
                    val progressbar = findViewById<ProgressBar>(R.id.progressBar)
                    progressbar.isVisible = true
                }

                override fun onFinish() {
                    val harang = findViewById<Button>(R.id.harang)
                    //harang.isInvisible = true
                    val progressbar = findViewById<ProgressBar>(R.id.progressBar)
                    progressbar.isInvisible = true
                    try {
                        pr = onlinehandler.access[0]
                        md = onlinehandler.access[1]
                        pf = onlinehandler.access[2]
                        fn = onlinehandler.access[3]
                        if (md == "Unlocked") {
                            harang.isInvisible = true
                            Toast.makeText(
                                this@TeacherDashboard,
                                "Midterm is already Unlocked for this block.",
                                Toast.LENGTH_SHORT
                            ).show()
                        } else {
                            alertBox.isInvisible = false
                            code = (10000..99999).shuffled().first()
                            var randomcode = code.toString()
                            tvPlease.text =
                                "Please re-enter this code " + randomcode + ", in the textbox below."
                            tvDoyou.text = "Do you want to unlock Midterm?"
                            val alertNo = findViewById<Button>(R.id.alertNo)
                            val alertYes = findViewById<Button>(R.id.alertYes)

                            alertNo.setOnClickListener() {
                                etCode.setText("")
                                alertBox.isInvisible = true
                            }

                            alertYes.setOnClickListener() {
                                val etCode = findViewById<EditText>(R.id.etCode)
                                if (etCode.text.toString() == randomcode) {
                                    val urlUpdateAccess =
                                        "http://bossfree-001-site1.dtempurl.com/updateAccess.php?Permission=Unlocked&BlockID=$BlockID&Indicator=Midterm"
                                    onlinehandler.MyAsyncTask4().execute(urlUpdateAccess)
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
                                    val confirmtimer = object : CountDownTimer(3000, 1000) {
                                        override fun onTick(millisUntilFinished: Long) {
                                            onlinehandler.MyAsyncTask4().execute(urlgetaccess)
                                            val harang = findViewById<Button>(R.id.harang)
                                            harang.isVisible = true
                                            val progressbar =
                                                findViewById<ProgressBar>(R.id.progressBar)
                                            progressbar.isVisible = true
                                        }

                                        override fun onFinish() {
                                            val harang = findViewById<Button>(R.id.harang)
                                            harang.isInvisible = true
                                            val progressbar =
                                                findViewById<ProgressBar>(R.id.progressBar)
                                            progressbar.isInvisible = true
                                            try {
                                                pr = onlinehandler.access[0]
                                                md = onlinehandler.access[1]
                                                pf = onlinehandler.access[2]
                                                fn = onlinehandler.access[3]
                                                if (md == "Unlocked") {
                                                    Toast.makeText(
                                                        this@TeacherDashboard, "Success!", Toast.LENGTH_SHORT).show()
                                                    alertBox.isInvisible=true
                                                } else {
                                                    Toast.makeText(
                                                        this@TeacherDashboard, "Failed! Check your internet connection.\nPlease try again.", Toast.LENGTH_SHORT).show()
                                                }
                                            } catch (ex: Exception) {
                                                Toast.makeText(this@TeacherDashboard, "Failed, make sure your are connected to the internet.",
                                                    Toast.LENGTH_SHORT
                                                ).show()
                                            }
                                        }
                                    }
                                    confirmtimer.start()
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
                                } else {
                                    Toast.makeText(
                                        this@TeacherDashboard,
                                        "Code didn't match!",
                                        Toast.LENGTH_SHORT
                                    ).show()
                                }
                            }
                        }
                    } catch (ex: Exception) {
                        Toast.makeText(this@TeacherDashboard, "wala.", Toast.LENGTH_SHORT).show()

                    }
                }
            }
            ///////////////ACCESS UNLOCK
            timer.start()
        }
        ///////////////////////////MIDTERM END

        prefinalAccess.setOnClickListener() {
            dummyC = dummyCourse.text.toString()
            dummyY = dummyYear.text.toString()
            dummyS = dummySection.text.toString()
            var BlockID = dummyC + dummyY + dummyS

            val urlgetaccess =
                "http://bossfree-001-site1.dtempurl.com/getAccess.php?BlockID=$BlockID"
            Toast.makeText(this, dummySection.text.toString(), Toast.LENGTH_SHORT).show()
            val timer = object : CountDownTimer(3000, 1000) {
                override fun onTick(millisUntilFinished: Long) {
                    onlinehandler.MyAsyncTask4().execute(urlgetaccess)
                    val harang = findViewById<Button>(R.id.harang)
                    harang.isVisible = true
                    val progressbar = findViewById<ProgressBar>(R.id.progressBar)
                    progressbar.isVisible = true
                }

                override fun onFinish() {
                    val harang = findViewById<Button>(R.id.harang)
                    harang.isInvisible = true
                    val progressbar = findViewById<ProgressBar>(R.id.progressBar)
                    progressbar.isInvisible = true
                    try {
                        pr = onlinehandler.access[0]
                        md = onlinehandler.access[1]
                        pf = onlinehandler.access[2]
                        fn = onlinehandler.access[3]
                        if (pf == "Unlocked") {
                            Toast.makeText(
                                this@TeacherDashboard,
                                "PreFinal is already Unlocked for this block.",
                                Toast.LENGTH_SHORT
                            ).show()
                        } else {
                            alertBox.isInvisible = false
                            code = (10000..99999).shuffled().first()
                            var randomcode = code.toString()
                            tvPlease.text =
                                "Please re-enter this code " + randomcode + ", in the textbox below."
                            tvDoyou.text = "Do you want to unlock PreFinal?"
                            val alertNo = findViewById<Button>(R.id.alertNo)
                            val alertYes = findViewById<Button>(R.id.alertYes)

                            alertNo.setOnClickListener() {
                                etCode.setText("")
                                alertBox.isInvisible = true
                            }

                            alertYes.setOnClickListener() {
                                val etCode = findViewById<EditText>(R.id.etCode)
                                if (etCode.text.toString() == randomcode) {
                                    val urlUpdateAccess =
                                        "http://bossfree-001-site1.dtempurl.com/updateAccess.php?Permission=Unlocked&BlockID=$BlockID&Indicator=PreFinal"
                                    onlinehandler.MyAsyncTask4().execute(urlUpdateAccess)
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
                                    val confirmtimer = object : CountDownTimer(3000, 1000) {
                                        override fun onTick(millisUntilFinished: Long) {
                                            onlinehandler.MyAsyncTask4().execute(urlgetaccess)
                                            val harang = findViewById<Button>(R.id.harang)
                                            harang.isVisible = true
                                            val progressbar =
                                                findViewById<ProgressBar>(R.id.progressBar)
                                            progressbar.isVisible = true
                                        }

                                        override fun onFinish() {
                                            val harang = findViewById<Button>(R.id.harang)
                                            harang.isInvisible = true
                                            val progressbar =
                                                findViewById<ProgressBar>(R.id.progressBar)
                                            progressbar.isInvisible = true
                                            try {
                                                pr = onlinehandler.access[0]
                                                md = onlinehandler.access[1]
                                                pf = onlinehandler.access[2]
                                                fn = onlinehandler.access[3]
                                                if (pf == "Unlocked") {
                                                    Toast.makeText(
                                                        this@TeacherDashboard, "Success!", Toast.LENGTH_SHORT).show()
                                                    alertBox.isInvisible=true
                                                } else {
                                                    Toast.makeText(
                                                        this@TeacherDashboard, "Failed! Check your internet connection.\nPlease try again.", Toast.LENGTH_SHORT).show()
                                                }
                                            } catch (ex: Exception) {
                                                Toast.makeText(this@TeacherDashboard, "Failed, make sure your are connected to the internet.",
                                                    Toast.LENGTH_SHORT
                                                ).show()
                                            }
                                        }
                                    }
                                    confirmtimer.start()
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
                                } else {
                                    Toast.makeText(
                                        this@TeacherDashboard,
                                        "Code didn't match!",
                                        Toast.LENGTH_SHORT
                                    ).show()
                                }
                            }
                        }
                    } catch (ex: Exception) {
                        Toast.makeText(this@TeacherDashboard, "wala.", Toast.LENGTH_SHORT).show()

                    }
                }
            }
            ///////////////ACCESS UNLOCK
            timer.start()
        }
        ///////////////////////////PREFINAL END





        finalsAccess.setOnClickListener() {
            dummyC = dummyCourse.text.toString()
            dummyY = dummyYear.text.toString()
            dummyS = dummySection.text.toString()
            var BlockID = dummyC + dummyY + dummyS

            val urlgetaccess =
                "http://bossfree-001-site1.dtempurl.com/getAccess.php?BlockID=$BlockID"
            Toast.makeText(this, dummySection.text.toString(), Toast.LENGTH_SHORT).show()
            val timer = object : CountDownTimer(3000, 1000) {
                override fun onTick(millisUntilFinished: Long) {
                    onlinehandler.MyAsyncTask4().execute(urlgetaccess)
                    val harang = findViewById<Button>(R.id.harang)
                    harang.isVisible = true
                    val progressbar = findViewById<ProgressBar>(R.id.progressBar)
                    progressbar.isVisible = true
                }

                override fun onFinish() {
                    val harang = findViewById<Button>(R.id.harang)
                    harang.isInvisible = true
                    val progressbar = findViewById<ProgressBar>(R.id.progressBar)
                    progressbar.isInvisible = true
                    try {
                        pr = onlinehandler.access[0]
                        md = onlinehandler.access[1]
                        pf = onlinehandler.access[2]
                        fn = onlinehandler.access[3]
                        if (fn == "Unlocked") {
                            Toast.makeText(
                                this@TeacherDashboard,
                                "Finals is already Unlocked for this block.",
                                Toast.LENGTH_SHORT
                            ).show()
                        } else {
                            alertBox.isInvisible = false
                            code = (10000..99999).shuffled().first()
                            var randomcode = code.toString()
                            tvPlease.text =
                                "Please re-enter this code " + randomcode + ", in the textbox below."
                            tvDoyou.text = "Do you want to unlock Finals?"
                            val alertNo = findViewById<Button>(R.id.alertNo)
                            val alertYes = findViewById<Button>(R.id.alertYes)

                            alertNo.setOnClickListener() {
                                etCode.setText("")
                                alertBox.isInvisible = true
                            }

                            alertYes.setOnClickListener() {

                                if (etCode.text.toString() == randomcode) {
                                    val urlUpdateAccess =
                                        "http://bossfree-001-site1.dtempurl.com/updateAccess.php?Permission=Unlocked&BlockID=$BlockID&Indicator=Finals"
                                    onlinehandler.MyAsyncTask4().execute(urlUpdateAccess)
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
                                    val confirmtimer = object : CountDownTimer(3000, 1000) {
                                        override fun onTick(millisUntilFinished: Long) {
                                            onlinehandler.MyAsyncTask4().execute(urlgetaccess)
                                            val harang = findViewById<Button>(R.id.harang)
                                            harang.isVisible = true
                                            val progressbar =
                                                findViewById<ProgressBar>(R.id.progressBar)
                                            progressbar.isVisible = true
                                        }

                                        override fun onFinish() {
                                            val harang = findViewById<Button>(R.id.harang)
                                            harang.isInvisible = true
                                            val progressbar =
                                                findViewById<ProgressBar>(R.id.progressBar)
                                            progressbar.isInvisible = true
                                            try {
                                                pr = onlinehandler.access[0]
                                                md = onlinehandler.access[1]
                                                pf = onlinehandler.access[2]
                                                fn = onlinehandler.access[3]
                                                if (fn == "Unlocked") {
                                                    Toast.makeText(
                                                        this@TeacherDashboard, "Success!", Toast.LENGTH_SHORT).show()
                                                    alertBox.isInvisible=true
                                                } else {
                                                    Toast.makeText(
                                                        this@TeacherDashboard, "Failed! Check your internet connection.\nPlease try again.", Toast.LENGTH_SHORT).show()
                                                }
                                            } catch (ex: Exception) {
                                                Toast.makeText(this@TeacherDashboard, "Failed, make sure your are connected to the internet.",
                                                    Toast.LENGTH_SHORT
                                                ).show()
                                            }
                                        }
                                    }
                                    confirmtimer.start()
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
                                } else {
                                    Toast.makeText(
                                        this@TeacherDashboard,
                                        "Code didn't match!",
                                        Toast.LENGTH_SHORT
                                    ).show()
                                }
                            }
                        }
                    } catch (ex: Exception) {
                        Toast.makeText(this@TeacherDashboard, "wala.", Toast.LENGTH_SHORT).show()

                    }
                }
            }
            ///////////////ACCESS UNLOCK
            timer.start()
        }
        ///////////////////////////PREFINAL END








    }

}