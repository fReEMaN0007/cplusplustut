package com.group2elearningapp.cplusplus

import android.content.Intent
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AlertDialog
import androidx.core.view.isInvisible
import androidx.core.view.isVisible
import java.time.LocalDateTime

class TecherNewAccount : AppCompatActivity() {


    lateinit var handler:DatabaseHelper

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_techer_new_account)

        handler = DatabaseHelper(this)


        /////////////////////////ActionBar
        val actionbar = supportActionBar
        actionbar!!.title = "Teacher New Account"
        actionbar.setDisplayHomeAsUpEnabled(true)
        val colorDrawable = ColorDrawable(Color.parseColor("#FF018786"))
        actionbar!!.setBackgroundDrawable(colorDrawable)
        /////////////////////////ActionBar


        ///variable for sqliteDB
        var name = findViewById<EditText>(R.id.nameTNAct)
        var nameT = name.text
        var surname = findViewById<EditText>(R.id.surnameTNAct)
        var surnameT = surname.text
        var email = findViewById<EditText>(R.id.emailTNAct)
        var emailT = email.text
        var studentNumber = findViewById<EditText>(R.id.employeeNumberTNAct)
        var studentNumberT = studentNumber.text
        var password = findViewById<EditText>(R.id.passwordTNAct)
        var passwordT = password.text
        var confirmPassword = findViewById<EditText>(R.id.confirmPasswordTNAct)
        var confirmPasswordT = confirmPassword.text
        var rbMaleTNAct = findViewById<RadioButton>(R.id.rbMaleTNAct)
        var rbFemaleTNAct = findViewById<RadioButton>(R.id.rbFemaleTNAct)
        var gender="pp"
        ///variable for sqliteDB
        gender = if (rbMaleTNAct.isChecked){
            "Male"
        } else{
            "Female"
        }

        ////builder
        val builder = AlertDialog.Builder(this)
        builder.setTitle("Please confirm if all the information is correct")
        //builder.setPositiveButton("OK", DialogInterface.OnClickListener(function = x))
        builder.setPositiveButton("Confirm") { dialog, which ->
            val intent = Intent(this, LogIn::class.java)
            intent.putExtra("UserIndicator", "Student")
            intent.putExtra("UserIndicator2", "Student")

            var regex = Regex("[^A-Za-z0-9 ]")
            var studentNumberfiltered = regex.replace(studentNumberT,"")



            if (handler.insertUserData(nameT.toString(), surnameT.toString(), emailT.toString(), studentNumberfiltered.toString(), "","","",gender, passwordT.toString(), 2,"offline",
                    LocalDateTime.now().toString())) {
                Toast.makeText(this, "Already Exist", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(this, "Registration Successful", Toast.LENGTH_SHORT).show()
                val intent = Intent(this, LogIn::class.java)
                intent.putExtra("UserIndicator", "Teacher")
                intent.putExtra("UserIndicator2", "Employee")
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
        ////builder



        ///Submit button
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

                                    builder.setMessage("Name: " + name.text + "\nSurname: " + surname.text + "" +
                                            "\nEmail: " + email.text + "\nStudent No.: " + studentNumber.text + "\nGender: " + gender.toString()  /*"Password: " + password.text + "Confirm: " + confirmPassword.text*/)
                                    builder.show()
                                } else {
                                    agreeChkBxSNAct.setBackgroundColor(Color.rgb(255, 122, 122))
                                    Toast.makeText(this, "Make sure you agreed to app terms and condition", Toast.LENGTH_SHORT).show()
                                }
                            } else {
                                password.setBackgroundColor(Color.rgb(255, 122, 122))
                                confirmPassword.setBackgroundColor(Color.rgb(255, 122, 122))
                                Toast.makeText(this, "Password didn't match", Toast.LENGTH_SHORT).show()
                            }
                        } else {
                            studentNumber.setBackgroundColor(Color.rgb(255, 122, 122))
                            Toast.makeText(this, "Make sure all fields are filled out.", Toast.LENGTH_SHORT).show()
                        }
                    } else {
                        email.setBackgroundColor(Color.rgb(255, 122, 122))
                        Toast.makeText(this, "Make sure all fields are filled out.", Toast.LENGTH_SHORT).show()
                    }
                } else {
                    surname.setBackgroundColor(Color.rgb(255, 122, 122))
                    Toast.makeText(this, "Make sure all fields are filled out.", Toast.LENGTH_SHORT).show()
                }
            } else {
                name.setBackgroundColor(Color.rgb(255, 122, 122))
                Toast.makeText(this, "Make sure all fields are filled out.", Toast.LENGTH_SHORT).show()
            }

        }
            ///Submit button

        }
    }

