package com.group2elearningapp.cplusplus

import android.content.Intent
import android.graphics.Color
import android.graphics.Color.rgb
import android.graphics.drawable.ColorDrawable
import android.os.Build
import android.os.Bundle
import android.view.View
import android.widget.*
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import java.time.LocalDateTime


class StudentNewAccount : AppCompatActivity() {

    lateinit var handler:DatabaseHelper


    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_student_new_account)
        handler = DatabaseHelper(this)

        /////////////////////////ActionBar
        val actionbar = supportActionBar
        actionbar!!.title = "Student New Account"
        actionbar.setDisplayHomeAsUpEnabled(true)
        val colorDrawable = ColorDrawable(Color.parseColor("#FF018786"))
        actionbar.setBackgroundDrawable(colorDrawable)
        /////////////////////////ActionBar


        var optionSpinner = arrayOf("CS", "IS")
        var spinner = findViewById<Spinner>(R.id.spinnerCourseTeacher)
        spinner.adapter = ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, optionSpinner)
        spinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                var dummycourse = findViewById<TextView>(R.id.dummyCourse)
                dummycourse.text = optionSpinner.get(position)
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {
            }
        }
        var optionSpinner2 = arrayOf("1", "2", "3", "4")
        var spinner2 = findViewById<Spinner>(R.id.spinnerYearlvlTeacher)
        spinner2.adapter = ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, optionSpinner2)
        spinner2.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                var dummyYrLvl = findViewById<TextView>(R.id.dummyYrLvl)
                dummyYrLvl.text = optionSpinner2.get(position)
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {
            }
        }

        var optionSpinner3 = arrayOf("1", "2", "3", "4")
        var spinner3 = findViewById<Spinner>(R.id.spinnerSectionTeacher)
        spinner3.adapter = ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, optionSpinner3)
        spinner3.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                var dummySection = findViewById<TextView>(R.id.dummySection)
                dummySection.text = optionSpinner3.get(position)
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {
            }
        }

        var optionSpinner4 = arrayOf("Male", "Female")
        var spinner4 = findViewById<Spinner>(R.id.spinner2)
        spinner4.adapter = ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, optionSpinner4)
        spinner4.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                var dummyGender = findViewById<TextView>(R.id.dummyGender)
                dummyGender.text = optionSpinner4.get(position)
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {
            }
        }

        ///variable for sqliteDB
        var name = findViewById<EditText>(R.id.nameTNAct)
        var nameT = name.text
        var surname = findViewById<EditText>(R.id.surnameTNAct)
        var surnameT = surname.text
        var email = findViewById<EditText>(R.id.emailTNAct)
        var emailT = email.text
        var studentNumber = findViewById<EditText>(R.id.employeeNumberTNAct)
        var studentNumberT = studentNumber.text
        var courseSpinner = findViewById<Spinner>(R.id.spinnerCourseTeacher)
        var password = findViewById<EditText>(R.id.passwordTNAct)
        var passwordT = password.text
        var confirmPassword = findViewById<EditText>(R.id.confirmPasswordTNAct)
        var confirmPasswordT = confirmPassword.text


        val builder = AlertDialog.Builder(this)
        builder.setTitle("Please confirm if all the information is correct")
//builder.setPositiveButton("OK", DialogInterface.OnClickListener(function = x))
        builder.setPositiveButton("Confirm") { dialog, which ->
            val intent = Intent(this, LogIn::class.java)
            intent.putExtra("UserIndicator", "Student")
            intent.putExtra("UserIndicator2", "Student")
            var dummycourse = findViewById<TextView>(R.id.dummyCourse)
            var Course = dummycourse.text
            var dummyYrLvl = findViewById<TextView>(R.id.dummyYrLvl)
            var YrLvl = dummyYrLvl.text
            var dummySection = findViewById<TextView>(R.id.dummySection)
            var Section = dummySection.text
            var dummyGender = findViewById<TextView>(R.id.dummyGender)
            var Gender = dummyGender.text

            var regex = Regex("[^A-Za-z0-9 ]")
            var studentNumberfiltered = regex.replace(studentNumberT,"")

           // handler.insertInitialProgress(studentNumberfiltered.toString())
            if (handler.insertUserData(nameT.toString(), surnameT.toString(), emailT.toString(), studentNumberfiltered.toString(), Course.toString(), YrLvl.toString(), Section.toString(), Gender.toString(), passwordT.toString(), 1,"offline",
                    LocalDateTime.now().toString())) {
                Toast.makeText(this, "Already Exist", Toast.LENGTH_SHORT).show()
            } else {
                val intent = Intent(this, LogIn::class.java)
                intent.putExtra("UserIndicator", "Student")
                intent.putExtra("UserIndicator2", "Student")
                startActivity(intent)
            }


        }
        builder.setNegativeButton(android.R.string.no) { dialog, which ->
            Toast.makeText(applicationContext,
                    android.R.string.no, Toast.LENGTH_SHORT).show()
        }
        builder.setNeutralButton("") { dialog, which ->
            Toast.makeText(applicationContext,
                    "Maybe", Toast.LENGTH_SHORT).show()
        }

        ///Submit button
        val submitBtnSNAct = findViewById<Button>(R.id.submitBtnTNAct)
        val agreeChkBxSNAct = findViewById<CheckBox>(R.id.agreeChkBxTNAct)
        submitBtnSNAct.setOnClickListener {

            if (nameT.toString() != "") {
                if (surnameT.toString() != "") {
                    if (emailT.toString() != "") {
                        if (studentNumberT.toString() != "") {
                            if (passwordT.toString() == confirmPasswordT.toString()) {
                                if (agreeChkBxSNAct.isChecked) {
                                    var dummycourse = findViewById<TextView>(R.id.dummyCourse)
                                    var Course = dummycourse.text
                                    var dummyYrLvl = findViewById<TextView>(R.id.dummyYrLvl)
                                    var YrLvl = dummyYrLvl.text
                                    var dummySection = findViewById<TextView>(R.id.dummySection)
                                    var Section = dummySection.text
                                    var dummyGender = findViewById<TextView>(R.id.dummyGender)
                                    var Gender = dummyGender.text
                                    builder.setMessage("Name: " + name.text + "\nSurname: " + surname.text + "" +
                                            "\nEmail: " + email.text + "\nStudent No.: " + studentNumber.text + "\nCourse: " + Course +
                                            "\nYr Lvl: " + YrLvl + "\nSection: " + Section + "\nGender: " + Gender  /*"Password: " + password.text + "Confirm: " + confirmPassword.text*/)
                                    builder.show()
                                } else {
                                    agreeChkBxSNAct.setBackgroundColor(rgb(255, 122, 122))
                                    Toast.makeText(this, "Make sure you agreed to app terms and condition", Toast.LENGTH_SHORT).show()
                                }
                            } else {
                                password.setBackgroundColor(rgb(255, 122, 122))
                                confirmPassword.setBackgroundColor(rgb(255, 122, 122))
                                Toast.makeText(this, "Password didn't match", Toast.LENGTH_SHORT).show()
                            }
                        } else {
                            studentNumber.setBackgroundColor(rgb(255, 122, 122))
                            Toast.makeText(this, "Make sure all fields are filled out.", Toast.LENGTH_SHORT).show()
                        }
                    } else {
                        email.setBackgroundColor(rgb(255, 122, 122))
                        Toast.makeText(this, "Make sure all fields are filled out.", Toast.LENGTH_SHORT).show()
                    }
                } else {
                    surname.setBackgroundColor(rgb(255, 122, 122))
                    Toast.makeText(this, "Make sure all fields are filled out.", Toast.LENGTH_SHORT).show()
                }
            } else {
                name.setBackgroundColor(rgb(255, 122, 122))
                Toast.makeText(this, "Make sure all fields are filled out.", Toast.LENGTH_SHORT).show()
            }

        }
        ///Submit button,


    }
    /*fun insertToSqlite(name: String, surname: String,email: String,studentNumber:String,course:String,yrLvl:String,section:String,gender:String,password:String){
        var regex = Regex("[^A-Za-z0-9 ]")
        var studentNumberfiltered = regex.replace(studentNumber,"")

        handler.insertUserData(name.toString(),surname.toString())
        Toast.makeText(this, studentNumberfiltered.toString(), Toast.LENGTH_SHORT).show()

    }*/

}
