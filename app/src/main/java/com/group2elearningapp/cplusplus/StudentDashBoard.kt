package com.group2elearningapp.cplusplus

import android.content.Intent
import android.database.sqlite.SQLiteDatabase
import android.graphics.Color.rgb
import android.os.Bundle
import android.os.CountDownTimer
import android.widget.*
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isInvisible
import androidx.core.view.isVisible
import java.lang.Exception

class StudentDashBoard : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_student_dash_board)

        var intent = intent
        val StudentNumber = intent.getStringExtra("StudentNumber").toString()


        lateinit var handler: DatabaseHelper
        handler = DatabaseHelper(this)


        var db: SQLiteDatabase = handler.readableDatabase


        var Gender = ""
        var Name = ""
        var Surname = ""
        var Email = ""
        var Course = ""
        var YearLvl = ""
        var Section = ""
        var Password=""

        var OverAllProgress = 0
        var Achievement = 0
        var SkillChallenge = 0
        var PrelimProgress = 0
        var MidtermProgress = 0
        var PreFinalProgress = 0
        var FinalProgress = 0
        var Activities = 0
        var LatestSync: String
        ////// ADD SyncCount to DB PLEASE
        var DataVersion = 0
        var PrelimAccess=""
        var MidtermAccess=""
        var PreFinalAccess=""
        var FinalsAccess=""
        //prelim var
        var one = 0;
        var onePointOne = 0;
        var onePointTwo = 0;
        var onePointThree = 0;
        var two = 0;
        var twoPointOne = 0;
        var twoPointTwo = 0;
        var twoPointThree = 0;
        var three = 0

        //midterm var
        var four = 0;
        var fourPointOne = 0;
        var five = 0;
        var fivePointOne = 0;
        var fivePointTwo = 0;
        var fivePointThree = 0;
        var fivePointFour = 0
        //prefinal var
        var six = 0;
        var sixPointOne = 0;
        var sixPointTwo = 0;
        var sixPointThree = 0;
        var sixPointFour = 0
        //finals var
        var seven = 0;
        var sevenPointOne = 0;
        var sevenPointTwo = 0;
        var sevenPointThree = 0;
        var sevenPointFour = 0;
        var eight = 0;
        var eightPointOne = 0;
        var eightPointTwo = 0
        //Activiy var
        var Activity1= 0;
        var Activity2= 0;
        var Activity3= 0;
        var Score1= 0;
        var Score2= 0;
        var Score3= 0;




        //get student info(start)
        val query = "select * from studentInfo where StudentNumber= '$StudentNumber'"
        val cursor = db.rawQuery(query, null)
        if (cursor.moveToFirst()) {
            Password=cursor.getString(1)
            val tvNameStudentDashboard = findViewById<TextView>(R.id.tvNameStudentDashboard)
            Name = cursor.getString(2)
            tvNameStudentDashboard.text = Name
            val tvSurnameStudentDashboard = findViewById<TextView>(R.id.tvSurnameStudentDashboard)
            Surname = cursor.getString(3)
            tvSurnameStudentDashboard.text = Surname
            val tvCourseStudentDashboard = findViewById<TextView>(R.id.tvCourseStudentDashboard)
            Course = cursor.getString(6)
            tvCourseStudentDashboard.text = Course
            Gender = cursor.getString(4)
            Email = cursor.getString(5)
            YearLvl = cursor.getString(7)
            Section = cursor.getString(8)
            if (tvCourseStudentDashboard.text.toString() == "CS") {
                tvCourseStudentDashboard.text = "B.S. Computer Science"
            } else {
                tvCourseStudentDashboard.text = "B.S. Information System"
            }

            if (Gender == "Male") {
                val ivDisplayPictureStudentDashboard = findViewById<ImageView>(R.id.ivDisplayPictureTeacherDashboard)
                ivDisplayPictureStudentDashboard.setImageResource(R.drawable.studentmale)
            } else {
                val ivDisplayPictureStudentDashboard = findViewById<ImageView>(R.id.ivDisplayPictureTeacherDashboard)
                ivDisplayPictureStudentDashboard.setImageResource(R.drawable.studentfemale)
            }

            //slicing the string to format the student number with dash
            var slicenumber1 = StudentNumber.toString()
            var slicenumber2 = StudentNumber.toString()
            var slicenumber3 = StudentNumber.toString()
            val tvStudentNUmberStudentDashboard = findViewById<TextView>(R.id.tvStudentNUmberStudentDashboard)
            tvStudentNUmberStudentDashboard.text = slicenumber1.slice(0..3).toString()
            val tvStudentNUmberStudentDashboard2 = findViewById<TextView>(R.id.tvStudentNUmberStudentDashboard2)
            tvStudentNUmberStudentDashboard2.text = slicenumber2.slice(4..9).toString()
            val tvStudentNUmberStudentDashboard3 = findViewById<TextView>(R.id.tvStudentNUmberStudentDashboard3)
            tvStudentNUmberStudentDashboard3.text = slicenumber3.slice(10..12).toString()
        }
        //get student info(end)


        //get student progress(start)
        val queryprogress = "select * from studentProgress where StudentNumber= '$StudentNumber'"
        val cursorprogress = db.rawQuery(queryprogress, null)
        if (cursorprogress.moveToFirst()) {

            OverAllProgress = cursorprogress.getInt(2)
            Achievement = cursorprogress.getInt(3)
            SkillChallenge = cursorprogress.getInt(4)
            PrelimProgress = cursorprogress.getInt(5)
            MidtermProgress = cursorprogress.getInt(6)
            PreFinalProgress = cursorprogress.getInt(7)
            FinalProgress = cursorprogress.getInt(8)
            Activities = cursorprogress.getInt(9)
            LatestSync = cursorprogress.getString(10)
            DataVersion = cursorprogress.getInt(11)
            PrelimAccess = cursorprogress.getString(12)
            MidtermAccess = cursorprogress.getString(13)
            PreFinalAccess = cursorprogress.getString(14)
            FinalsAccess = cursorprogress.getString(15)


            var toastprogress: String
            toastprogress = OverAllProgress.toString()
            Toast.makeText(this, "overall->"+toastprogress, Toast.LENGTH_SHORT).show()
        }
        //get student progress(end)

        //get Prelim Lesson Indicator(start)
        val queryPrelimLesson = "select * from Prelim where StudentNumber= '$StudentNumber'"
        val cursorPrelimLesson = db.rawQuery(queryPrelimLesson, null)
        if (cursorPrelimLesson.moveToFirst()) {

            one = cursorPrelimLesson.getInt(2)
            onePointOne = cursorPrelimLesson.getInt(3)
            onePointTwo = cursorPrelimLesson.getInt(4)
            onePointThree = cursorPrelimLesson.getInt(5)
            two = cursorPrelimLesson.getInt(6)
            twoPointOne = cursorPrelimLesson.getInt(7)
            twoPointTwo = cursorPrelimLesson.getInt(8)
            twoPointThree = cursorPrelimLesson.getInt(9)
            three = cursorPrelimLesson.getInt(10)
            //Toast.makeText(this, "ito yung three$three", Toast.LENGTH_SHORT).show()
            //get Prelim Lesson Indicator(start)
        }
        //get Midterm Lesson Indicator(start)
        val queryMidtermLesson = "select * from Prelim where StudentNumber= '$StudentNumber'"
        val cursorMidtermLesson = db.rawQuery(queryMidtermLesson, null)
        if (cursorMidtermLesson.moveToFirst()) {

            four = cursorMidtermLesson.getInt(2)
            fourPointOne = cursorMidtermLesson.getInt(3)
            five = cursorMidtermLesson.getInt(4)
            fivePointOne = cursorMidtermLesson.getInt(5)
            fivePointTwo = cursorMidtermLesson.getInt(6)
            fivePointThree = cursorMidtermLesson.getInt(7)
            fivePointFour = cursorMidtermLesson.getInt(8)
            //get Midterm Lesson Indicator(end)
        }

        //get PreFinal Lesson Indicator(start)
        val queryPreFinalLesson = "select * from Prelim where StudentNumber= '$StudentNumber'"
        val cursorPreFinalLesson = db.rawQuery(queryPreFinalLesson, null)
        if (cursorPreFinalLesson.moveToFirst()) {

            six = cursorPreFinalLesson.getInt(2)
            sixPointOne = cursorPreFinalLesson.getInt(3)
            sixPointTwo = cursorPreFinalLesson.getInt(4)
            sixPointThree = cursorPreFinalLesson.getInt(5)
            sixPointFour = cursorPreFinalLesson.getInt(6)
            //get PreFinal Lesson Indicator(end)
        }
        //get Finals Lesson Indicator(start)
        val queryFinalLesson = "select * from Prelim where StudentNumber= '$StudentNumber'"
        val cursorFinalLesson = db.rawQuery(queryFinalLesson, null)
        if (cursorFinalLesson.moveToFirst()) {

            seven = cursorFinalLesson.getInt(2)
            sevenPointOne = cursorFinalLesson.getInt(3)
            sevenPointTwo = cursorFinalLesson.getInt(4)
            sevenPointThree = cursorFinalLesson.getInt(5)
            sevenPointFour = cursorFinalLesson.getInt(6)
            eight = cursorFinalLesson.getInt(7)
            eightPointOne = cursorFinalLesson.getInt(8)
            eightPointTwo = cursorFinalLesson.getInt(9)

            //get Finals Lesson Indicator(end)
        }
        //get Activity (start)
        val queryActivity= "select * from Activity where StudentNumber= '$StudentNumber'"
        val cursorActivity = db.rawQuery(queryActivity, null)
        if (cursorActivity.moveToFirst()) {
            Activity1= cursorActivity.getInt(2)
            Activity2 = cursorActivity.getInt(3)
            Activity3 = cursorActivity.getInt(4)
            Score1 = cursorActivity.getInt(5)
            Score2 = cursorActivity.getInt(6)
            Score3 = cursorActivity.getInt(7)

            //get Activity (end)
        }






        val btnAchievementsStudentDashboard = findViewById<Button>(R.id.btnAchievementsStudentDashboard)
        btnAchievementsStudentDashboard.setOnClickListener() {
            val intent = Intent(this, Achivements::class.java)
            intent.putExtra("StudentNumber", StudentNumber)
            startActivity(intent)
        }

        //PRELIM textview,imageview,button (start)
        //(test only)
        //PrelimProgress = 100
        val tvProgressPrelimStudentDashBoard = findViewById<TextView>(R.id.tvProgressPrelimStudentDashBoard)
        val btnPrelimStudentDashboard = findViewById<Button>(R.id.SearchByClass)
        val btnMidtermStudentDashboard = findViewById<Button>(R.id.btnMidtermStudentDashboard)
        val btnPrefinalStudentDashboard = findViewById<Button>(R.id.btnPrefinalStudentDashboard)
        val btnFinalsStudentDashboard = findViewById<Button>(R.id.btnFinalsStudentDashboard)
        val tvOverAllProgressStudentDashboard = findViewById<TextView>(R.id.tvOverAllProgressStudentDashboard)
        val tvScoreStudentDashBoard = findViewById<TextView>(R.id.tvScoreStudentDashBoard)

        tvProgressPrelimStudentDashBoard.text = PrelimProgress.toString() + "% Complete"
        tvOverAllProgressStudentDashboard.text = OverAllProgress.toString() + "% Over-all Progress"
        tvScoreStudentDashBoard.text = "Total Score: " + Achievement.toString()


        val PrelimStar1 = findViewById<ImageView>(R.id.PrelimStar1)
        val PrelimStar2 = findViewById<ImageView>(R.id.PrelimStar2)
        val PrelimStar3 = findViewById<ImageView>(R.id.PrelimStar3)
        val PrelimStar4 = findViewById<ImageView>(R.id.PrelimStar4)
        val PrelimStar5 = findViewById<ImageView>(R.id.PrelimStar5)

        if (PrelimProgress == 100 && MidtermAccess=="Unlocked") {
            btnMidtermStudentDashboard.isEnabled = true
            btnMidtermStudentDashboard.setTextColor(rgb(255, 255, 255))
            btnMidtermStudentDashboard.setBackgroundColor(rgb(1, 135, 134))

            val linearMidtermInner = findViewById<LinearLayout>(R.id.linearMidtermInner)
            linearMidtermInner.isInvisible = true
            val tvProgressMidtermStudentDashBoard = findViewById<TextView>(R.id.tvProgressMidtermStudentDashBoard)
            tvProgressMidtermStudentDashBoard.isInvisible = false
            val linearMidtermInnerRight = findViewById<LinearLayout>(R.id.linearMidtermInnerRight)
            linearMidtermInnerRight.isInvisible = false

        }

        if (PrelimProgress > 0) {
            PrelimStar1.isInvisible = false
        }
        if (PrelimProgress > 20) {
            PrelimStar2.isInvisible = false
        }
        if (PrelimProgress > 40) {
            PrelimStar3.isInvisible = false
        }
        if (PrelimProgress > 60) {
            PrelimStar4.isInvisible = false
        }
        if (PrelimProgress == 100) {
            PrelimStar5.isInvisible = false
            tvProgressPrelimStudentDashBoard.setTextColor(rgb(132, 255, 0))
            btnPrelimStudentDashboard.setTextColor(rgb(132, 255, 0))

        }
        btnPrelimStudentDashboard.setOnClickListener() {

            val intent = Intent(this, Prelim::class.java)
            intent.putExtra("StudentNumber", StudentNumber)
            startActivity(intent)
        }
        //PRELIM textview,imageview,button (end)


        //MIDTERM textview,imageview,button (start)
        //MidtermProgress = 100
        val tvProgressMidtermStudentDashBoard = findViewById<TextView>(R.id.tvProgressMidtermStudentDashBoard)

        tvProgressMidtermStudentDashBoard.text = MidtermProgress.toString() + "% Complete"

        val MidtermStar1 = findViewById<ImageView>(R.id.MidtermStar1)
        val MidtermStar2 = findViewById<ImageView>(R.id.MidtermStar2)
        val MidtermStar3 = findViewById<ImageView>(R.id.MidtermStar3)
        val MidtermStar4 = findViewById<ImageView>(R.id.MidtermStar4)
        val MidtermStar5 = findViewById<ImageView>(R.id.MidtermStar5)
        if (MidtermProgress == 100 && PreFinalAccess=="Unlocked") {
            btnPrefinalStudentDashboard.isEnabled = true
            btnPrefinalStudentDashboard.setTextColor(rgb(255, 255, 255))
            btnPrefinalStudentDashboard.setBackgroundColor(rgb(1, 135, 134))

            val linearPrefinalInner = findViewById<LinearLayout>(R.id.linearPrefinalInner)
            linearPrefinalInner.isInvisible = true
            val tvProgressPrefinalsStudentDashBoard = findViewById<TextView>(R.id.tvProgressPreFinalStudentDashBoard)
            tvProgressPrefinalsStudentDashBoard.isInvisible = false
            val linearPrefinalInnerRight = findViewById<LinearLayout>(R.id.linearPrefinalInnerRight)
            linearPrefinalInnerRight.isInvisible = false

        }
        if (MidtermProgress > 0) {
            MidtermStar1.isInvisible = false
        }
        if (MidtermProgress > 20) {
            MidtermStar2.isInvisible = false
        }
        if (MidtermProgress > 40) {
            MidtermStar3.isInvisible = false
        }
        if (MidtermProgress > 60) {
            MidtermStar4.isInvisible = false
        }
        if (MidtermProgress == 100) {
            MidtermStar5.isInvisible = false
            tvProgressMidtermStudentDashBoard.setTextColor(rgb(132, 255, 0))
            btnMidtermStudentDashboard.setTextColor(rgb(132, 255, 0))
        }
        btnMidtermStudentDashboard.setOnClickListener() {
            val intent = Intent(this, Midterm::class.java)
            intent.putExtra("StudentNumber", StudentNumber)
            startActivity(intent)

        }
        //MIDTERM textview,imageview,button (end)


        //PreFinal textview,imageview,button (start)
        //PreFinalProgress = 100
        val tvProgressPreFinalStudentDashBoard = findViewById<TextView>(R.id.tvProgressPreFinalStudentDashBoard)

        tvProgressPreFinalStudentDashBoard.text = PreFinalProgress.toString() + "% Complete"

        val PreFinalStar1 = findViewById<ImageView>(R.id.PreFinalStar1)
        val PreFinalStar2 = findViewById<ImageView>(R.id.PreFinalStar2)
        val PreFinalStar3 = findViewById<ImageView>(R.id.PreFinalStar3)
        val PreFinalStar4 = findViewById<ImageView>(R.id.PreFinalStar4)
        val PreFinalStar5 = findViewById<ImageView>(R.id.PreFinalStar5)
        if (PreFinalProgress == 100&&FinalsAccess=="Unlocked") {
            btnFinalsStudentDashboard.isEnabled = true
            btnFinalsStudentDashboard.setTextColor(rgb(255, 255, 255))
            btnFinalsStudentDashboard.setBackgroundColor(rgb(1, 135, 134))

            val linearFinalsInner = findViewById<LinearLayout>(R.id.linearFinalsInner)
            linearFinalsInner.isInvisible = true
            val tvProgressFinalStudentDashBoard = findViewById<TextView>(R.id.tvProgressFinalStudentDashBoard)
            tvProgressFinalStudentDashBoard.isInvisible = false
            val linearFinalsInnerRight = findViewById<LinearLayout>(R.id.linearFinalsInnerRight)
            linearFinalsInnerRight.isInvisible = false

        }
        if (PreFinalProgress > 0) {
            PreFinalStar1.isInvisible = false
        }
        if (PreFinalProgress > 20) {
            PreFinalStar2.isInvisible = false
        }
        if (PreFinalProgress > 40) {
            PreFinalStar3.isInvisible = false
        }
        if (PreFinalProgress > 60) {
            PreFinalStar4.isInvisible = false
        }
        if (PreFinalProgress == 100) {
            PreFinalStar5.isInvisible = false
            tvProgressPreFinalStudentDashBoard.setTextColor(rgb(132, 255, 0))
            btnPrefinalStudentDashboard.setTextColor(rgb(132, 255, 0))
        }
        btnPrefinalStudentDashboard.setOnClickListener() {
            val intent = Intent(this, PreFinal::class.java)
            intent.putExtra("StudentNumber", StudentNumber)
            startActivity(intent)
        }
        //Prefinal textview,imageview,button (end)


        //Finals textview,imageview,button (start)
        //FinalProgress = 100
        val tvProgressFinalStudentDashBoard = findViewById<TextView>(R.id.tvProgressFinalStudentDashBoard)

        tvProgressFinalStudentDashBoard.text = FinalProgress.toString() + "% Complete"

        val FinalStar1 = findViewById<ImageView>(R.id.FinalStar1)
        val FinalStar2 = findViewById<ImageView>(R.id.FinalStar2)
        val FinalStar3 = findViewById<ImageView>(R.id.FinalStar3)
        val FinalStar4 = findViewById<ImageView>(R.id.FinalStar4)
        val FinalStar5 = findViewById<ImageView>(R.id.FinalStar5)
        if (FinalProgress == 100) {
            tvProgressFinalStudentDashBoard.setTextColor(rgb(132, 255, 0))
            btnFinalsStudentDashboard.setTextColor(rgb(132, 255, 0))
        }
        if (FinalProgress > 0) {
            FinalStar1.isInvisible = false
        }
        if (FinalProgress > 20) {
            FinalStar2.isInvisible = false
        }
        if (FinalProgress > 40) {
            FinalStar3.isInvisible = false
        }
        if (FinalProgress > 60) {
            FinalStar4.isInvisible = false
        }
        if (FinalProgress == 100) {
            FinalStar5.isInvisible = false
        }
        btnFinalsStudentDashboard.setOnClickListener() {
            val intent = Intent(this, Finals::class.java)
            Toast.makeText(this, "FINISH", Toast.LENGTH_SHORT).show()
            intent.putExtra("StudentNumber", StudentNumber)
            startActivity(intent)
        }
        //Finals textview,imageview,button (end)


        /////ONLINE DATA SYNC///////

        lateinit var onlinehandler: OnlineDBhelper


        onlinehandler = OnlineDBhelper()
        var onlineRecord = "0"
        val url = "http://bossfree-001-site1.dtempurl.com/read.php?StudentNumber=aa"
        val fullurll = "http://bossfree-001-site1.dtempurl.com/bobohanmopa.php?StudentNumber=$StudentNumber&Password=$Password&Name=$Name&Surname=$Surname&Gender=$Gender&Email=$Email&Course=$Course&YearLvl=$YearLvl&Section=$Section&OverAllProgress=$OverAllProgress&Achievements=$Achievement&SkillChallenge=$SkillChallenge&Prelim=$PrelimProgress&Midterm=$MidtermProgress&PreFinal=$PreFinalProgress&Finals=$FinalProgress&Activities=$Activities&DataVersion=$DataVersion&one=$one&onePointOne=$onePointOne&onePointTwo=$onePointTwo&onePointThree=$onePointThree&two=$two&twoPointOne=$twoPointOne&twoPointTwo=$twoPointTwo&twoPointThree=$twoPointThree&Three=$three&four=$four&fourPointOne=$fourPointOne&five=$five&fivePointOne=$fivePointOne&fivePointTwo=$fivePointTwo&fivePointThree=$fivePointThree&fivePointFour=$fivePointFour&six=$six&sixPointOne=$sixPointOne&sixPointTwo=$sixPointTwo&sixPointThree=$sixPointThree&sixPointFour=$sixPointFour&seven=$seven&sevenPointOne=$sevenPointOne&sevenPointTwo=$sevenPointTwo&sevenPointThree=$sevenPointThree&sevenPointFour=$sevenPointFour&eight=$eight&eightPointOne=$eightPointOne&eightPointTwo=$eightPointTwo"
        val button = findViewById<Button>(R.id.button)
        val urlsearchstudentnumber = "http://bossfree-001-site1.dtempurl.com/readmodified.php?StudentNumber=$StudentNumber"
        val urlStudentInfo = "http://bossfree-001-site1.dtempurl.com/singleInsertStudentInfo.php?StudentNumber=$StudentNumber&Name=$Name&Surname=$Surname&Password=$Password&Email=$Email&Gender=$Gender&Course=$Course&YearLvl=$YearLvl&Section=$Section"
        val urlStrudentProgress = "http://bossfree-001-site1.dtempurl.com/StudentProgresssingleInsert.php?StudentNumber=$StudentNumber&OverAllProgress=101&Achievements=$Achievement&SkillChallenge=$SkillChallenge&Prelim=$PrelimProgress&Midterm=$MidtermProgress&PreFinal=$PreFinalProgress&Finals=$FinalProgress&Activities=$Activities&DataVerion=$DataVersion&PrelimAccess=$PrelimAccess&MidtermAccess=$MidtermAccess&PreFinalAccess=$PreFinalAccess&FinalsAccess=$FinalsAccess"
        val urlPrelim = "http://bossfree-001-site1.dtempurl.com/PrelimSingleInsert.php?StudentNumber=$StudentNumber&one=$one&onePointOne=$onePointOne&onePointTwo=$onePointTwo&onePointThree=$onePointThree&two=$two&twoPointOne=$twoPointOne&twoPointTwo=$twoPointTwo&twoPointThree=$twoPointThree&three=$three.tostring"
        val urlMidterm = "http://bossfree-001-site1.dtempurl.com/MidtermSingleInsert.php?StudentNumber=$StudentNumber&four=$four&fourPointOne=$fourPointOne&five=$five&fivePointOne=$fivePointOne&fivePointTwo=$fivePointTwo&fivePointThree=$fivePointThree&fivePointFour=$fivePointFour"
        val urlPreFinal = "http://bossfree-001-site1.dtempurl.com/PreFinalSingleInsert.php?StudentNumber=$StudentNumber&six=$six&sixPointOne=$sixPointOne&sixPointTwo=$sixPointTwo&sixPointThree=$sixPointThree&sixPointFour=$sixPointFour"
        val urlFinal = "http://bossfree-001-site1.dtempurl.com/FinalSingleInsert.php?StudentNumber=$StudentNumber&seven=$seven&sevenPointOne=$sevenPointOne&sevenPointTwo=$sevenPointTwo&sevenPointThree=$sevenPointThree&sevenPointFour=$sevenPointFour&eight=$eight&eightPointOne=$eightPointOne&eightPointTwo=$eightPointTwo"
        val urlActivity="http://bossfree-001-site1.dtempurl.com/ActivitySingleInsert.php?StudentNumber=$StudentNumber&Activity1=$Activity1&Activity2=$Activity2&Activity3=$Activity3&Score1=$Score1&Score2=$Score2&Score3=$Score3"

        var urlUPDATEStrudentProgress = "http://bossfree-001-site1.dtempurl.com/UPDATEStudentProgresssingleInsert.php?StudentNumber=$StudentNumber&OverAllProgress=1111&Achievements=$Achievement&SkillChallenge=$SkillChallenge&Prelim=$PrelimProgress&Midterm=$MidtermProgress&PreFinal=$PreFinalProgress&Finals=$FinalProgress&Activities=$Activities&DataVerion=$DataVersion&PrelimAccess=$PrelimAccess&MidtermAccess=$MidtermAccess&PreFinalAccess=$PreFinalAccess&FinalsAccess=$FinalsAccess"
        val urlUPDATEPrelim = "http://bossfree-001-site1.dtempurl.com/UPDATEPrelimSingleInsert.php?StudentNumber=$StudentNumber&one=$one&onePointOne=$onePointOne&onePointTwo=$onePointTwo&onePointThree=$onePointThree&two=$two&twoPointOne=$twoPointOne&twoPointTwo=$twoPointTwo&twoPointThree=$twoPointThree&three=$three.tostring"


        //this will run upon opening the student the dashboard!
        //it will check whether the student number exist or not on the online database




/*
        val builder = AlertDialog.Builder(this)
        builder.setTitle("Greetings!")
        builder.setMessage("Thank you for using C++ Tutorial App")
//builder.setPositiveButton("OK", DialogInterface.OnClickListener(function = x))

        builder.setPositiveButton("Continue") { dialog, which ->



            //Toast.makeText(applicationContext,
            //android.R.string.yes, Toast.LENGTH_SHORT).show()
        }

        /*builder.setNegativeButton(android.R.string.no) { dialog, which ->
            Toast.makeText(applicationContext,
                    android.R.string.no, Toast.LENGTH_SHORT).show()
        }*/

        /*builder.setNeutralButton("Maybe") { dialog, which ->
            Toast.makeText(applicationContext,
                    "Maybe", Toast.LENGTH_SHORT).show()
        }*/

        builder.show()*/

        /*val SyncFromOL = AlertDialog.Builder(this)
        SyncFromOL.setTitle("Greetings!")
        SyncFromOL.setMessage("Sync Data")
//builder.setPositiveButton("OK", DialogInterface.OnClickListener(function = x))

        SyncFromOL.setPositiveButton("Ok") { dialog, which ->
            handler.updatefromOLProgress(StudentNumber,onlinehandler.ari[9].toInt(),onlinehandler.ari[10].toInt(),onlinehandler.ari[11].toInt(),
                    onlinehandler.ari[12].toInt(),onlinehandler.ari[13].toInt(),onlinehandler.ari[14].toInt(),onlinehandler.ari[15].toInt(),
                    onlinehandler.ari[16].toInt(),onlinehandler.ari[17].toInt(),onlinehandler.ari[50],onlinehandler.ari[51],onlinehandler.ari[52],onlinehandler.ari[53])
            handler.updatefromOLPrelim(onlinehandler.ari[18].toInt(),onlinehandler.ari[19].toInt(),onlinehandler.ari[20].toInt(),onlinehandler.ari[21].toInt(),
                    onlinehandler.ari[22].toInt(),onlinehandler.ari[23].toInt(),onlinehandler.ari[24].toInt(),onlinehandler.ari[25].toInt(),onlinehandler.ari[26].toInt())
            /////KULANG PA NG UPDATE PREFINAL AT FINALS


            /////ito ay pang score lang
            handler.updatefromOLActivity(onlinehandler.acti[0].toInt(),onlinehandler.acti[1].toInt(),onlinehandler.acti[2].toInt(),StudentNumber)

            Toast.makeText(this, onlinehandler.ari[12], Toast.LENGTH_SHORT).show()
            val intent = Intent(this, StudentDashBoard::class.java)
            intent.putExtra("StudentNumber", StudentNumber)
            startActivity(intent)
        }*/


       /* val SyncFromOLSCORE= AlertDialog.Builder(this)
        SyncFromOLSCORE.setTitle("Greetings!")
        SyncFromOLSCORE.setMessage("Sync Data")
//builder.setPositiveButton("OK", DialogInterface.OnClickListener(function = x))

        SyncFromOLSCORE.setPositiveButton("Ok") { dialog, which ->

            /////ito ay pang score lang
            handler.updatefromOLActivity(onlinehandler.acti[0].toInt(),onlinehandler.acti[1].toInt(),onlinehandler.acti[2].toInt(),StudentNumber)

            val intent = Intent(this, StudentDashBoard::class.java)
            intent.putExtra("StudentNumber", StudentNumber)
            startActivity(intent)
        }*/




       /* val SyncFromOLACCESS= AlertDialog.Builder(this)
        SyncFromOLACCESS.setTitle("Greetings!")
        SyncFromOLACCESS.setMessage("Access")
//builder.setPositiveButton("OK", DialogInterface.OnClickListener(function = x))

        SyncFromOLACCESS.setPositiveButton("Ok") { dialog, which ->
            Toast.makeText(this, onlinehandler.access[1].toString(), Toast.LENGTH_SHORT).show()
            handler.updatefromOLACCESS(onlinehandler.access[0],onlinehandler.access[1],onlinehandler.access[2],onlinehandler.access[3],StudentNumber)

            val intent = Intent(this, StudentDashBoard::class.java)
            intent.putExtra("StudentNumber", StudentNumber)
            startActivity(intent)
        }*/


        var tekalang = 0
        var itonakaya = 0
        var syncChecker=""
        val progressBar2 = findViewById<ProgressBar>(R.id.progressBar2)
        val btnSyncDataOnlineStudentDashboard = findViewById<Button>(R.id.btnSyncDataOnlineStudentDashboard)
////////////////////////SYNC BUTTON
        btnSyncDataOnlineStudentDashboard.setOnClickListener() {
            val queryprogress = "select * from studentProgress where StudentNumber= '$StudentNumber'"
            val cursorprogress = db.rawQuery(queryprogress, null)
            if (cursorprogress.moveToFirst()) {
                DataVersion = cursorprogress.getInt(11)}

            urlUPDATEStrudentProgress = "http://bossfree-001-site1.dtempurl.com/UPDATEStudentProgresssingleInsert.php?StudentNumber=$StudentNumber&OverAllProgress=1111&Achievements=$Achievement&SkillChallenge=$SkillChallenge&Prelim=$PrelimProgress&Midterm=$MidtermProgress&PreFinal=$PreFinalProgress&Finals=$FinalProgress&Activities=$Activities&DataVerion=$DataVersion&PrelimAccess=$PrelimAccess&MidtermAccess=$MidtermAccess&PreFinalAccess=$PreFinalAccess&FinalsAccess=$FinalsAccess"

            val synctimerOnlinerecord = object : CountDownTimer(3000, 1000) {
                override fun onTick(millisUntilFinished: Long) {
                    onlineRecord = onlinehandler.search(urlsearchstudentnumber)
                    progressBar2.isVisible=true
                }

                override fun onFinish() {
                    onlineRecord = onlinehandler.ito()
                    Toast.makeText(this@StudentDashBoard, onlineRecord+" dataversion-> "+DataVersion, Toast.LENGTH_SHORT).show()
                    ///////////////////////////////////////////////////////////////////////////////////////
                    /////////////////////////////////////////////////////////////////////////////////////
                    if (onlineRecord == "") {
                        Toast.makeText(this@StudentDashBoard, "NO RECORD", Toast.LENGTH_SHORT).show()
                        val synctimer = object : CountDownTimer(1500, 1000) {
                            override fun onTick(millisUntilFinished: Long) {
                                onlinehandler.search(urlStudentInfo)
                                onlinehandler.search(urlStrudentProgress)
                                onlinehandler.search(urlPrelim)
                                onlinehandler.search(urlMidterm)
                                onlinehandler.search(urlPreFinal)
                                onlinehandler.search(urlFinal)
                                onlinehandler.search(urlActivity)
                                progressBar2.isVisible=true
                            }

                            override fun onFinish() {
                                val syncimerInner = object : CountDownTimer(1500, 1000) {
                                    override fun onTick(millisUntilFinished: Long) {
                                        syncChecker = onlinehandler.search(urlsearchstudentnumber)

                                        progressBar2.isVisible=true
                                    }

                                    override fun onFinish() {
                                        syncChecker = onlinehandler.ito()
                                        progressBar2.isVisible=false
                                        if (syncChecker!=""){
                                            Toast.makeText(this@StudentDashBoard, "Sync Successful!", Toast.LENGTH_SHORT).show()
                                            DataVersion = DataVersion+1
                                            handler.updateDataVersion(DataVersion, StudentNumber)
                                        }
                                        else{
                                            Toast.makeText(this@StudentDashBoard, "Sync Failed! Make sure your device is connected to the internet.", Toast.LENGTH_LONG).show()
                                        }
                                    }
                                }
                                syncimerInner.start()
                            }
                        }
                        synctimer.start()

                    } else if (onlineRecord != "") {
                        var BlockID = Course+YearLvl+Section
                        // Toast.makeText(this, BlockID, Toast.LENGTH_LONG).show()

                        val getScore="http://bossfree-001-site1.dtempurl.com/getScore.php?StudentNumber=$StudentNumber"
                        val urlgetaccess = "http://bossfree-001-site1.dtempurl.com/getAccess.php?BlockID=$BlockID"

                        if (onlineRecord.toInt() < DataVersion) {
                            Toast.makeText(this@StudentDashBoard, "OL LESSTHAN", Toast.LENGTH_SHORT).show()
                            val synctimer = object : CountDownTimer(2000, 1000) {
                                override fun onTick(millisUntilFinished: Long) {
                                    onlinehandler.MyAsyncTask3().execute(getScore)
                                    onlinehandler.MyAsyncTask4().execute(urlgetaccess)

                                    ///KULANG PA PARA SA IBANG TABLE! GAGAWA NG PHP FILE
                                    onlinehandler.MyAsyncTask().execute(urlUPDATEStrudentProgress)
                                    onlinehandler.MyAsyncTask().execute(urlUPDATEPrelim)
                                    ///KULANG PA PARA SA IBANG TABLE! GAGAWA NG PHP FILE
                                    progressBar2.isVisible=true

                                }

                                override fun onFinish() {
                                    val synctimerInner = object : CountDownTimer(3000, 1000) {
                                        override fun onTick(millisUntilFinished: Long) {
                                            progressBar2.isVisible=true
                                            syncChecker = onlinehandler.search(urlsearchstudentnumber)
                                            try {
                                                //SYNC FROM ONLINE ACCESS
                                                handler.updatefromOLACCESS(onlinehandler.access[0],onlinehandler.access[1],onlinehandler.access[2],onlinehandler.access[3],StudentNumber)

                                                //SYNC FROM ONLINE ACTIVITY SCORE
                                                handler.updatefromOLActivity(onlinehandler.acti[0].toInt(),onlinehandler.acti[1].toInt(),onlinehandler.acti[2].toInt(),StudentNumber)

                                            }catch (ex:Exception){}
                                        }

                                        override fun onFinish() {
                                            progressBar2.isVisible=false
                                            syncChecker = onlinehandler.ito()
                                            if(syncChecker>onlineRecord){
                                                Toast.makeText(this@StudentDashBoard, "Sync Successful!"+syncChecker+onlineRecord, Toast.LENGTH_SHORT).show()
                                                DataVersion = DataVersion + 1
                                                handler.updateDataVersion(DataVersion, StudentNumber)

                                            }else{
                                                Toast.makeText(this@StudentDashBoard, "Sync Failed! Make sure your device is connected to the internet."+syncChecker+onlineRecord, Toast.LENGTH_LONG).show()
                                            }

                                        }
                                    }
                                    synctimerInner.start()
                                }
                            }
                            synctimer.start()
                        }

                        else if(onlineRecord.toInt()>DataVersion){
                            Toast.makeText(this@StudentDashBoard, "OL GREATERTHAN", Toast.LENGTH_SHORT).show()
                            val getAll="http://bossfree-001-site1.dtempurl.com/getAll.php?StudentNumber=$StudentNumber"
                            val synctimerOuter = object : CountDownTimer(3000, 1000) {
                                override fun onTick(millisUntilFinished: Long) {
                                    onlinehandler.MyAsyncTask2().execute(getAll)
                                }

                                override fun onFinish() {
                                    val synctimer= object : CountDownTimer(1500, 1000) {
                                        override fun onTick(millisUntilFinished: Long) {
                                            ////////////
                                            progressBar2.isVisible=true
                                            try {
                                                handler.updatefromOLProgress(StudentNumber,onlinehandler.ari[9].toInt(),onlinehandler.ari[10].toInt(),onlinehandler.ari[11].toInt(),
                                                    onlinehandler.ari[12].toInt(),onlinehandler.ari[13].toInt(),onlinehandler.ari[14].toInt(),onlinehandler.ari[15].toInt(),
                                                    onlinehandler.ari[16].toInt(),onlinehandler.ari[17].toInt(),onlinehandler.ari[47],onlinehandler.ari[48],onlinehandler.ari[49],onlinehandler.ari[50])
                                                ////////
                                                handler.updatefromOLPrelim(onlinehandler.ari[18].toInt(),onlinehandler.ari[19].toInt(),onlinehandler.ari[20].toInt(),onlinehandler.ari[21].toInt(),
                                                    onlinehandler.ari[22].toInt(),onlinehandler.ari[23].toInt(),onlinehandler.ari[24].toInt(),onlinehandler.ari[25].toInt(),onlinehandler.ari[26].toInt())
                                                /////KULANG PA NG UPDATE PREFINAL FINALS,activity,access
                                            }catch (ex:Exception){}

                                        }
                                        override fun onFinish() {
                                            progressBar2.isVisible=false
                                            val synctimerInner = object : CountDownTimer(1500, 1000) {
                                                override fun onTick(millisUntilFinished: Long) {
                                                    val queryprogress = "select * from studentProgress where StudentNumber= '$StudentNumber'"
                                                    val cursorprogress = db.rawQuery(queryprogress, null)
                                                    if (cursorprogress.moveToFirst()) {
                                                        OverAllProgress = cursorprogress.getInt(2)
                                                        Achievement = cursorprogress.getInt(3)
                                                        SkillChallenge = cursorprogress.getInt(4)
                                                        PrelimProgress = cursorprogress.getInt(5)
                                                        MidtermProgress = cursorprogress.getInt(6)
                                                        PreFinalProgress = cursorprogress.getInt(7)
                                                        FinalProgress = cursorprogress.getInt(8)
                                                        Activities = cursorprogress.getInt(9)
                                                        LatestSync = cursorprogress.getString(10)
                                                        DataVersion = cursorprogress.getInt(11)
                                                        PrelimAccess = cursorprogress.getString(12)
                                                        MidtermAccess = cursorprogress.getString(13)
                                                        PreFinalAccess = cursorprogress.getString(14)
                                                        FinalsAccess = cursorprogress.getString(15)
                                                    }
                                                }
                                                override fun onFinish() {
                                                    if (DataVersion.toString()==onlinehandler.ari[17]){
                                                        Toast.makeText(this@StudentDashBoard, "Sync Successful", Toast.LENGTH_SHORT).show()
                                                        DataVersion=DataVersion+1
                                                        handler.updateDataVersion(DataVersion, StudentNumber)
                                                    }else{
                                                        Toast.makeText(this@StudentDashBoard, "Sync Failed! Make sure your device is connected to the internet.", Toast.LENGTH_LONG).show()
                                                    }
                                                }

                                            }
                                            synctimerInner.start()
                                        }
                                    }
                                    synctimer.start()
                                }

                            }
                            synctimerOuter.start()
                        }else{
                            DataVersion=DataVersion-1
                            handler.updateDataVersion(DataVersion, StudentNumber)
                            Toast.makeText(this@StudentDashBoard, "Sync Failed, please try again.", Toast.LENGTH_SHORT).show()
                        }


                    }
                    //////////////////////////////////////////////////////////////////////////
                    //////////////////////////////////////////////////////////////////////////


                }

            }
            synctimerOnlinerecord.start()


        }


        var tuks = emptyArray<String>()
        val button5 = findViewById<Button>(R.id.seachButton)

        val button10 = findViewById<Button>(R.id.button10)
        button10.setOnClickListener(){
            //onlinehandler.MyAsyncTask2().execute(getAll)
            //Toast.makeText(this, "ops", Toast.LENGTH_SHORT).show()
            val intent = Intent(this, com.group2elearningapp.cplusplus.Activities::class.java)
            intent.putExtra("StudentNumber", StudentNumber)
            startActivity(intent)


        }
        //button5.setOnClickListener() {
           // val tvCourseStudentDashboard = findViewById<TextView>(R.id.tvCourseStudentDashboard)
            //tvCourseStudentDashboard.text = onlinehandler.ari[9]
            //tvCourseStudentDashboard.text = tekalang.toString()
          //  SyncFromOL.show()
       // }

        /////ONLINE DATA SYNC///////

        val leaderBoardBtn=findViewById<Button>(R.id.leaderBoardBtn)
        leaderBoardBtn.setOnClickListener(){
            val intent = Intent(this, teacherSearchResult::class.java)
            intent.putExtra("indicator","3")
            startActivity(intent)
        }


    }


}

