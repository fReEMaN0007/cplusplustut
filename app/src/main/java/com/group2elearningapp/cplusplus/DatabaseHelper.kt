package com.group2elearningapp.cplusplus


import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.os.Build
import android.widget.Toast
import androidx.annotation.RequiresApi
import java.time.LocalDateTime

class DatabaseHelper(context: Context) :SQLiteOpenHelper(context,dbname, factory, version){


    override fun onCreate(p0: SQLiteDatabase?) {
        p0?.execSQL("CREATE TABLE studentInfo (StudentNumber varchar(50) primary key, Password varchar(50), Name varchar(50), Surname varchar(50), Gender varchar(50), Email varchar(50), Course varchar(50), YearLvl varchar(50), Section varchar(50),DateRegistered varchar(50))")
        p0?.execSQL("CREATE TABLE teacherInfo (EmployeeNumber varchar(50) primary key, Password varchar(50), Name varchar(50), Surname varchar(50),Gender varchar(50), Email varchar(50),DateRegistered varchar(50))")
        p0?.execSQL("CREATE TABLE studentProgress (ProgressId integer primary key autoincrement, StudentNumber varchar(50),OverAllProgress integer(100), Achievements integer(100), SkillChallenge integer(100), Prelim integer(100), Midterm integer(100), PreFinal integer(100), Finals integer(100), Activities integer(100),LatestSync varchar(50),DataVersion integer(100),PrelimAccess varchar(50),MidterAccess varchar(50),PreFinalAccess varchar(50),FinalsAccess varchar(50),FOREIGN KEY(StudentNumber) REFERENCES studentInfo(StudentNumber))")
        p0?.execSQL("CREATE TABLE Prelim (PrelimId integer primary key autoincrement, StudentNumber varchar(50),'one' integer(100), 'onePointOne' integer(100), 'onePointTwo' integer(100), 'onePointThree' integer(100), 'two' integer(100), 'twoPointOne' integer(100), 'twoPointTwo' integer(100), 'twoPointThree' integer(100),'three' integer(100),FOREIGN KEY(StudentNumber) REFERENCES studentInfo(StudentNumber))")
        p0?.execSQL("CREATE TABLE Midterm (MidtermId integer primary key autoincrement, StudentNumber varchar(50),'four' integer(100), 'fourPointOne' integer(100), 'five' integer(100), 'fivePointOne' integer(100), 'fivePointTwo' integer(100), 'fivePointThree' integer(100), 'fivePointFour' integer(100),FOREIGN KEY(StudentNumber) REFERENCES studentInfo(StudentNumber))")
        p0?.execSQL("CREATE TABLE PreFinal (PreFinalId integer primary key autoincrement, StudentNumber varchar(50),'six' integer(100), 'sixPointOne' integer(100), 'sixPointTwo' integer(100), 'sixPointThree' integer(100), 'sixPointFour' integer(100),FOREIGN KEY(StudentNumber) REFERENCES studentInfo(StudentNumber))")
        p0?.execSQL("CREATE TABLE Final (FinalId integer primary key autoincrement, StudentNumber varchar(50),'seven' integer(100), 'sevenPointOne' integer(100), 'sevenPointTwo' integer(100), 'sevenPointThree' integer(100), 'sevenPointFour' integer(100), 'eight' integer(100), 'eightPointOne' integer(100), 'eightPointTwo' integer(100),FOREIGN KEY(StudentNumber) REFERENCES studentInfo(StudentNumber))")
        p0?.execSQL("CREATE TABLE Testing (TestingId integer primary key autoincrement, StudentNumber varchar(50),testint int(100), testString varchar(100))")
        p0?.execSQL("CREATE TABLE Activity (ActivityId integer primary key autoincrement, StudentNumber varchar(50),Activity1 integer(100),Activity2 integer(100),Activity3 integer(100),Score1 integer(100),Score2 integer(100),Score3 integer(100),FOREIGN KEY(StudentNumber) REFERENCES studentInfo(StudentNumber))")

    }

    override fun onUpgrade(p0:SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        TODO("Not yet implemented")

    }

    fun insertToTesting(int:Int,str:String){
        if (int<0){
            var str = "ss"
        }

        val db: SQLiteDatabase = writableDatabase
        val values:ContentValues= ContentValues()
        val query = "select * from Testing where StudentNumber= 1234"
        val cursor = db.rawQuery(query,null)
        if (cursor.count<=0){
            values.put("testint", int)
            values.put("testString", str)
            values.put("StudentNumber",1234)
            db.insert("Testing",null,values)
            db.close()
            cursor.close()
        }


    }

    @RequiresApi(Build.VERSION_CODES.O)
    fun insertUserData(name: String, surname: String, email: String, studentNumber:String, course:String, yrLvl:String, section:String, gender:String, password:String,indicator:Int,from:String,datereg:String):Boolean{
        val db: SQLiteDatabase = writableDatabase
        val values : ContentValues = ContentValues()


        var table:String
        var user:String
        var query:String



        if (indicator==1){
            query = "select * from studentInfo where StudentNumber= '$studentNumber'"
            table = "studentInfo"
            user="StudentNumber"
        }

        else {
            query = "select * from teacherInfo where EmployeeNumber= '$studentNumber'"
            table = "teacherInfo"
            user = "EmployeeNumber"
        }

        val cursor = db.rawQuery(query.toString(), null)
        if(cursor.count<=0){

            if(indicator==1){
                values.put("Course",course)
                values.put("YearLvl",yrLvl)
                values.put("Section",section)
                insertInitialProgress(studentNumber)
                insertInitialPrelim(studentNumber)
                insertInitialMidterm(studentNumber)
                insertInitialPreFinal(studentNumber)
                insertInitialFinal(studentNumber)
                insertInitialActivity(studentNumber)


            }
            else{}

            values.put("Name",name)
            values.put("Surname",surname)
            values.put("Email",email)
            values.put(user.toString(),studentNumber)
            values.put("Gender",gender)
            values.put("Password",password)
            values.put("DateRegistered", datereg)
            db.insert(table.toString(),null,values)
            db.close()
            cursor.close()

           return false
        }
        else {
            cursor.close()
            return true
        }

    }

    fun userLogin(StudentNumber: String,Password: String,indicator: Int):Boolean{
        val db=readableDatabase
        var query=""

        if(indicator==1) {
            query = "select * from studentInfo where StudentNumber= '$StudentNumber' and Password = '$Password'"
        }
        else{
            query = "select * from teacherInfo where EmployeeNumber= '$StudentNumber' and Password = '$Password'"
        }


            val cursor = db.rawQuery(query, null)
            if (cursor.count <= 0) {
                cursor.close()
                return false
            }
            else cursor.close()
            return true

    }

    @RequiresApi(Build.VERSION_CODES.O)
    fun insertInitialProgress(studentNumber: String) :String{
        val db2: SQLiteDatabase = writableDatabase
        val query2 = "select * from studentProgress where StudentNumber= '$studentNumber'"
        val values2: ContentValues = ContentValues()
        val cursor2 = db2.rawQuery(query2.toString(), null)
        if (cursor2.count <= 0) {
            values2.put("OverAllProgress", 0)
            values2.put("Achievements",  0)
            values2.put("SkillChallenge",  0)
            values2.put("Prelim",  0)
            values2.put("Midterm",  0)
            values2.put("PreFinal",  0)
            values2.put("Finals",  0)
            values2.put("Activities",  0)
            values2.put("DataVersion", 1)
            values2.put("StudentNumber", studentNumber)
            values2.put("LatestSync","")
            values2.put("PrelimAccess","Unlocked")
            values2.put("MidterAccess","Locked")
            values2.put("PreFinalAccess","Locked")
            values2.put("FinalsAccess","Locked")
            db2.insert("studentProgress",null,values2)

            cursor2.close()
        }
        return "Success"
    }

    fun insertInitialPrelim(studentNumber: String) :String{
        val db3: SQLiteDatabase = writableDatabase
        val query3 = "select * from Prelim where StudentNumber= '$studentNumber'"
        val values3: ContentValues = ContentValues()
        val cursor3 = db3.rawQuery(query3.toString(), null)
        if (cursor3.count <= 0) {
            values3.put("one", 0)
            values3.put("onePointOne",0)
            values3.put("onePointTwo",  0)
            values3.put("onePointThree",  0)
            values3.put("two",  0)
            values3.put("twoPointOne",  0)
            values3.put("twoPointTwo",  0)
            values3.put("twoPointThree",  0)
            values3.put("three",  0)
            values3.put("StudentNumber", studentNumber)
            db3.insert("Prelim",null,values3)
            cursor3.close()
        }
        return "Success"
    }
    fun insertInitialMidterm(studentNumber: String) :String{
        val db2: SQLiteDatabase = writableDatabase
        val query2 = "select * from Midterm where StudentNumber= '$studentNumber'"
        val values2: ContentValues = ContentValues()
        val cursor2 = db2.rawQuery(query2.toString(), null)
        if (cursor2.count <= 0) {
            values2.put("four", 0)
            values2.put("fourPointOne",  0)
            values2.put("five",  0)
            values2.put("fivePointOne",  0)
            values2.put("fivePointTwo",  0)
            values2.put("fivePointThree",  0)
            values2.put("fivePointFour",  0)
            values2.put("StudentNumber", studentNumber)
            db2.insert("Midterm",null,values2)
            cursor2.close()
        }
        return "Success"
    }


    fun insertInitialPreFinal(studentNumber: String) :String{
        val db2: SQLiteDatabase = writableDatabase
        val query2 = "select * from PreFinal where StudentNumber= '$studentNumber'"
        val values2: ContentValues = ContentValues()
        val cursor2 = db2.rawQuery(query2.toString(), null)
        if (cursor2.count <= 0) {
            values2.put("six", 0)
            values2.put("sixPointOne",  0)
            values2.put("sixPointTwo",  0)
            values2.put("sixPointThree",  0)
            values2.put("sixPointFour",  0)
            values2.put("StudentNumber", studentNumber)
            db2.insert("Prefinal",null,values2)
            cursor2.close()
        }
        return "Success"
    }


    fun insertInitialFinal(studentNumber: String) :String{
        val db2: SQLiteDatabase = writableDatabase
        val query2 = "select * from Final where StudentNumber= '$studentNumber'"
        val values2: ContentValues = ContentValues()
        val cursor2 = db2.rawQuery(query2.toString(), null)
        if (cursor2.count <= 0) {
            values2.put("seven", 0)
            values2.put("sevenPointOne",  0)
            values2.put("sevenPointTwo",  0)
            values2.put("sevenPointThree",  0)
            values2.put("sevenPointFour",  0)
            values2.put("eight",  0)
            values2.put("eightPointOne",  0)
            values2.put("eightPointTwo",  0)
            values2.put("StudentNumber", studentNumber)
            db2.insert("Final",null,values2)
            cursor2.close()
        }
        return "Success"
    }

    fun insertInitialActivity(studentNumber: String) :String{
        val db2: SQLiteDatabase = writableDatabase
        val query2 = "select * from Activity where StudentNumber= '$studentNumber'"
        val values2: ContentValues = ContentValues()
        val cursor2 = db2.rawQuery(query2.toString(), null)
        if (cursor2.count <= 0) {
            var random1 = (1..3).shuffled().first()
            var random2 = (1..3).shuffled().first()
            var random3 = (1..3).shuffled().first()
            values2.put("Activity1", random1)
            values2.put("Activity2",  random2)
            values2.put("Activity3",  random3)
            values2.put("Score1",  0)
            values2.put("Score2",  0)
            values2.put("Score3",  0)
            values2.put("StudentNumber", studentNumber)
            db2.insert("Activity",null,values2)
            cursor2.close()
        }
        return "Success"
    }

    fun checklAndUpdateProgress(studentNumber: String,table:String,column:String,column2:String,value:Int,value2:Int,index:Int,index2:Int,value3:Int,score:Int):String{
        var db : SQLiteDatabase = readableDatabase



        val query =  "select * from '$table' where StudentNumber= '$studentNumber'"
        val values = ContentValues()
        val cursor = db.rawQuery(query,null)
        var one=99
        if ((cursor.moveToFirst())){
            one = cursor.getInt(index)
        }


        val query2 =  "select * from 'studentProgress' where StudentNumber= '$studentNumber'"
        val values2 = ContentValues()
        val cursor2 = db.rawQuery(query2,null)
        var computedvalue=99
        var oldvalue = 99
        var computedOVALL=99
        var oldOALL= 99
        var computedScore=99
        var oldOScore= 99
        if ((cursor2.moveToFirst())){
            oldvalue = cursor2.getInt(index2)
            oldOALL = cursor2.getInt(2)
            oldOScore = cursor2.getInt(3)
        }
        computedvalue = oldvalue +value
        computedOVALL = oldOALL +value3
        computedScore = oldOScore +score


        if (one==0){
            var db : SQLiteDatabase = writableDatabase
            val updateProgress =  "UPDATE studentProgress SET '$column'= '+$computedvalue' WHERE StudentNumber= '$studentNumber'"
            val updateProgressOverall =  "UPDATE studentProgress SET OverAllProgress= '+$computedOVALL' WHERE StudentNumber= '$studentNumber'"
            val updateAchievements =  "UPDATE studentProgress SET Achievements= '+$computedScore' WHERE StudentNumber= '$studentNumber'"
            val updateQuarter =  "UPDATE '$table' SET '$column2'='$value2' WHERE StudentNumber= '$studentNumber'"
            db.execSQL(updateProgress)
            db.execSQL(updateQuarter)
            db.execSQL(updateProgressOverall)
            db.execSQL(updateAchievements)
        }
        else{
        }
        return "Success"

    }

    fun updateDataVersion(version : Int,StudentNumber: String) {
        var db: SQLiteDatabase = writableDatabase
        val updateDataVersion = "UPDATE studentProgress SET DataVersion='$version' WHERE StudentNumber='$StudentNumber'"
        db.execSQL(updateDataVersion)
    }


    fun updatefromOLProgress(StudentNumber: String,OverAllProgress:Int,Achievement:Int,SkillChallenge:Int,PrelimProgress:Int,MidtermProgress:Int,
                             PreFinalProgress:Int,FinalProgress:Int,Activities:Int,DataVersion:Int,prelim:String,midterm:String,prefinal:String,final:String){
        val db:SQLiteDatabase=writableDatabase
        val updateProgress = "UPDATE studentProgress SET OverAllProgress='$OverAllProgress', Achievements='$Achievement',SkillChallenge='$SkillChallenge', Prelim='$PrelimProgress'," +
                "Midterm='$MidtermProgress',PreFinal='$PreFinalProgress', Finals='$FinalProgress', Activities='$Activities',DataVersion='$DataVersion' " +
                ",PrelimAccess='$prelim', MidterAccess='$midterm', PreFinalAccess='$prefinal', FinalsAccess='$final' WHERE StudentNumber='$StudentNumber'"
        db.execSQL(updateProgress)

    }

    fun updatefromOLPrelim(one:Int,onePone:Int,onePtwo:Int,onePthree:Int,two:Int,twoPone:Int,twoPtwo:Int,twoPthree:Int,three:Int){
        val db:SQLiteDatabase=writableDatabase
        val updateprelim="UPDATE Prelim SET one='$one',onePointOne='$onePone',onePointTwo='$onePtwo',onePointThree='$onePthree',two='$two',twoPointOne='$twoPone',twoPointTwo='$twoPtwo'" +
                ",twoPointThree='$twoPthree',three='$three'"
        db.execSQL(updateprelim)

    }
    fun updatefromOLActivity(Score1:Int,Score2:Int,Score3:Int,StudentNUmber:String){
        val db:SQLiteDatabase=writableDatabase
        val updateActivity="UPDATE Activity SET Score1=$Score1,Score2=$Score2,Score3=$Score3 WHERE StudentNumber='$StudentNUmber'"
        db.execSQL(updateActivity)
    }

    fun updatefromOLACCESS(Prelim:String,Midterm:String,PreFinal:String,Finals:String,StudentNUmber:String){
        val db:SQLiteDatabase=writableDatabase
        val updateAccess="UPDATE studentProgress SET PrelimAccess= '$Prelim', MidterAccess= '$Midterm', PreFinalAccess= '$PreFinal', FinalsAccess= '$Finals' WHERE StudentNumber='$StudentNUmber'"
        db.execSQL(updateAccess)
    }
    companion object{
        internal val dbname = "userDB"
        internal val factory = null
        internal val version = 1
    }
}