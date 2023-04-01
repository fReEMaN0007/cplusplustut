package com.group2elearningapp.cplusplus

import android.content.Intent
import android.text.Layout
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Toast
import androidx.core.view.isInvisible
import androidx.core.view.isVisible
import androidx.recyclerview.widget.RecyclerView
import java.lang.Exception

class resultaadapter(val Resulta: Resulta, val tanga:TextView, val indicator:String):RecyclerView.Adapter<customviewhodler>() {



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): customviewhodler {
        val layoutInflater = LayoutInflater.from(parent.context)
         val cellforrow = layoutInflater.inflate(R.layout.studentinfo, parent, false)
        return customviewhodler(cellforrow)

    }

    override fun onBindViewHolder(holder: customviewhodler, position: Int) {
        val name = Resulta.info.get(position)
        val Surname = Resulta.info.get(position)
        val StudentNumber = Resulta.info.get(position)
        val course = Resulta.info.get(position)
        val YearLvl = Resulta.info.get(position)
        val Section = Resulta.info.get(position)
        val overallprogress = Resulta.info.get(position)
        val achievements = Resulta.info.get(position)
        val activities = Resulta.info.get(position)
        val skillchallenge = Resulta.info.get(position)
        val prelim = Resulta.info.get(position)
        val midterm = Resulta.info.get(position)
        val prefinal = Resulta.info.get(position)
        val finals = Resulta.info.get(position)
        val dateregistered = Resulta.info.get(position)
        val latestsync = Resulta.info.get(position)
        val Activity1 = Resulta.info.get(position)
        val Activity2 = Resulta.info.get(position)
        val Activity3 = Resulta.info.get(position)
        val score1 = Resulta.info.get(position)
        val score2 = Resulta.info.get(position)
        val score3 = Resulta.info.get(position)

        if (indicator=="3"&&position==0){
            holder.view.findViewById<TextView>(R.id.goldribbon).isInvisible=false
        }
        if(indicator=="3"&&position==1){
            holder.view.findViewById<TextView>(R.id.silverribbon).isInvisible=false
        }
        if(indicator=="3"&&position==2){
            holder.view.findViewById<TextView>(R.id.bronzeribbon).isInvisible=false
        }

        holder.view.findViewById<TextView>(R.id.tvTotalScore).text = "Total Score: "+achievements.Achievements_OL
        holder.view.findViewById<TextView>(R.id.StudentName).text = name.Name_OL
        holder.view.findViewById<TextView>(R.id.StudentSurname).text = Surname.Surname_OL

        if(course.Course_OL=="CS"){
            holder.view.findViewById<TextView>(R.id.StudentCourse).text = "B.S. Computer Science"
        }else{holder.view.findViewById<TextView>(R.id.StudentCourse).text = "B.S. Information System"}

        holder.view.findViewById<TextView>(R.id.StudentStudentNumber).text = StudentNumber.StudentNumber_OL
        holder.view.findViewById<TextView>(R.id.StudentYear).text = YearLvl.YearLvl_OL + "-" + Section.Section_OL



        if (indicator!="3") {
            holder.view.findViewById<LinearLayout>(R.id.containerStudentinfo).setOnClickListener() {
                val intent = Intent(holder.view.context, StudentFullInfo::class.java)

                intent.putExtra("Student Number", StudentNumber.StudentNumber_OL)
                intent.putExtra("Name", name.Name_OL)
                intent.putExtra("Surname", Surname.Surname_OL)
                intent.putExtra("Course", course.Course_OL)
                intent.putExtra("Year", YearLvl.YearLvl_OL)
                intent.putExtra("Section", Section.Section_OL)
                intent.putExtra("OverAllProgress", overallprogress.OverAllProgress_OL)
                intent.putExtra("Achievements", achievements.Achievements_OL)
                intent.putExtra("Activities", activities.Activities_OL)
                intent.putExtra("Skill Challenge", skillchallenge.SkillChallenge_OL)
                intent.putExtra("Prelim", prelim.Prelim_OL)
                intent.putExtra("Midterm", midterm.Midterm_OL)
                intent.putExtra("PreFinal", prefinal.PreFinal_OL)
                intent.putExtra("Finals", finals.Finals_OL)
                intent.putExtra("DateRegistered", dateregistered.DateRegistered_OL)
                intent.putExtra("LatestSync", latestsync.LatestSync_OL)
                intent.putExtra("Activity1", Activity1.Activity1_OL)
                intent.putExtra("Activity2", Activity2.Activity2_OL)
                intent.putExtra("Activity3", Activity3.Activity3_OL)
                intent.putExtra("Score1", score1.Score1_OL)
                intent.putExtra("Score2", score2.Score2_OL)
                intent.putExtra("Score3", score3.Score3_OL)

                holder.view.context.startActivity(intent)
                Toast.makeText(holder.view.context, "Activity1.Activity1_OL", Toast.LENGTH_SHORT)
                    .show()


            }

        }

    }

    override fun getItemCount(): Int {
    var teka = 0
        try {
            teka = Resulta.info.count()
            tanga.text= Resulta.info.count().toString() + "  match found."
        }catch (ex:Exception){
            tanga.text="No match Found."
        }
        return teka
    }
}

class customviewhodler(val view: View): RecyclerView.ViewHolder(view){
}