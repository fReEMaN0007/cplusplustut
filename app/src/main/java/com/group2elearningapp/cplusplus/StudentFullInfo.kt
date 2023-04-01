package com.group2elearningapp.cplusplus

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*
import androidx.appcompat.app.AlertDialog

class StudentFullInfo : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_student_full_info)


        val StudentNumber =  intent.getStringExtra("Student Number")
        val name = intent.getStringExtra("Name")
        val Surname = intent.getStringExtra("Surname")
        val course = intent.getStringExtra("Course")
        val YearLvl = intent.getStringExtra("Year")
        val Section = intent.getStringExtra("Section")
        val overallprogress = intent.getStringExtra("OverAllProgress")
        val achievements = intent.getStringExtra("Achievements")
        val activities = intent.getStringExtra("Activities")
        val skillchallenge = intent.getStringExtra("Skill Challenge")
        val prelim = intent.getStringExtra("Prelim")
        val midterm = intent.getStringExtra("Midterm")
        val prefinal = intent.getStringExtra("PreFinal")
        val finals = intent.getStringExtra("Finals")
        val dateregistered = intent.getStringExtra("DateRegistered")
        val latestsync = intent.getStringExtra("LatestSync")
        val Activity1 = intent.getStringExtra("Activity1")
        val Activity2 = intent.getStringExtra("Activity2")
        val Activity3 = intent.getStringExtra("Activity3")
        val score1 = intent.getStringExtra("Score1")
        val score2 = intent.getStringExtra("Score2")
        val score3 = intent.getStringExtra("Score3")


        val StudentName = findViewById<TextView>(R.id.StudentName)
            StudentName.text = name
        val StudentSurname = findViewById<TextView>(R.id.StudentSurname)
            StudentSurname.text = Surname
        val StudentCourse = findViewById<TextView>(R.id.StudentCourse)
            StudentCourse.text = course
        val StudentStudentNumber = findViewById<TextView>(R.id.StudentStudentNumber)
            StudentStudentNumber.text = StudentNumber
        val tvRegistered = findViewById<TextView>(R.id.tvRegistered)
            tvRegistered.text = "Date Registed: "+dateregistered
        val tvSync = findViewById<TextView>(R.id.tvSync)
        tvSync.text = "Last Sync: "+latestsync
        val StudentYear = findViewById<TextView>(R.id.StudentYear)
            StudentYear.text = YearLvl+"-"+Section
        val overallprogressStudent = findViewById<TextView>(R.id.overallprogressStudent)
            overallprogressStudent.text = overallprogress
        val achievementsStudent = findViewById<TextView>(R.id.achievementsStudent)
            achievementsStudent.text = achievements
        val activitiesStudent = findViewById<TextView>(R.id.activitiesStudent)
            activitiesStudent.text = activities
        val skillchallengeStudent = findViewById<TextView>(R.id.skillchallengeStudent)
            skillchallengeStudent.text = skillchallenge
        val prelimStudent = findViewById<TextView>(R.id.prelimStudent)
            prelimStudent.text = prelim
        val midtermStudent = findViewById<TextView>(R.id.midtermStudent)
            midtermStudent.text = midterm
        val prefinalStudent = findViewById<TextView>(R.id.prefinalStudent)
            prefinalStudent.text = prefinal
        val finalsStudent = findViewById<TextView>(R.id.finalsStudent)
            finalsStudent.text = finals
        val activity1Student =findViewById<TextView>(R.id.score1Student)
            activity1Student.text = score1
        val activity2Student =findViewById<TextView>(R.id.score2Student)
            activity2Student.text = score2
        val activity3Student =findViewById<TextView>(R.id.score3Student)
            activity3Student.text = score3


        if(course=="CS"){
            StudentCourse.text = "Computer Science"
        }else{StudentCourse.text = "Information System"}


        var tventerScore = findViewById<TextView>(R.id.tventerScore)
        val editTextNumberScore = findViewById<EditText>(R.id.editTextNumberScore)

        var optionSpinner3 = arrayOf("Activity1","Activity2","Activity3")
        var spinnerActivity = findViewById<Spinner>(R.id.spinnerActivity)
        var selector = 0
        var score = ""

        spinnerActivity.adapter = ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, optionSpinner3)
        spinnerActivity.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                //var dummySection = findViewById<TextView>(R.id.dummySection)
               // dummySection.text = optionSpinner3.get(position)

                if(optionSpinner3.get(position).toString()=="Activity1"){
                tventerScore.text = "Max Possible Score: 50"

                    selector =1
                }
                else if (optionSpinner3.get(position).toString()=="Activity2"){
                    tventerScore.text = "Max Possible Score: 100"
                selector=2}
                else{tventerScore.text = "Max Possible Score: 200"
                    selector=3}
            }
            override fun onNothingSelected(parent: AdapterView<*>?) {
            }
        }






        lateinit var onlinehandler:OnlineDBhelper
        onlinehandler= OnlineDBhelper()

        val builder = AlertDialog.Builder(this)
        builder.setTitle("Greetings!")
        builder.setMessage("Thank you for using C++ Tutorial App")
//builder.setPositiveButton("OK", DialogInterface.OnClickListener(function = x))

        builder.setPositiveButton("Continue") { dialog, which ->
            val score1Student =findViewById<TextView>(R.id.score1Student)
            val score2Student =findViewById<TextView>(R.id.score2Student)
            val score3Student =findViewById<TextView>(R.id.score3Student)
            try {
                score1Student.text = onlinehandler.acti[0]
                score2Student.text = onlinehandler.acti[1]
                score3Student.text = onlinehandler.acti[2]
            }catch (ex:Exception){
                Toast.makeText(this, "Operation failed, please make sure your device is connected to the internet.", Toast.LENGTH_LONG).show()}


            //Toast.makeText(applicationContext,
            //android.R.string.yes, Toast.LENGTH_SHORT).show()
        }


        val submitStudentFullInfo = findViewById<Button>(R.id.submitStudentFullInfo)
        submitStudentFullInfo.setOnClickListener(){
            score = editTextNumberScore.text.toString()

            if (selector==1){
                if (score.toInt()>50){
                    score = "50"
                    editTextNumberScore.setText("50")
                }
            }

            else if (selector==2){
                if (score.toInt()>100){
                    score = "100"
                    editTextNumberScore.setText("100")
                }
            }

            else{
                if (score.toInt()>200){
                    score = "200"
                    editTextNumberScore.setText("200")
                }
            }

            val urlUpdateActivity="http://bossfree-001-site1.dtempurl.com/UPDATEActivitySingleInsert.php?Indicator=$selector&Score=$score&StudentNumber=$StudentNumber"
            Toast.makeText(this, score, Toast.LENGTH_SHORT).show()
            onlinehandler.MyAsyncTask3().execute(urlUpdateActivity)
            builder.show()

           // val intent = Intent(this, StudentFullInfo::class.java)
            //startActivity(intent)
        }







        }
}