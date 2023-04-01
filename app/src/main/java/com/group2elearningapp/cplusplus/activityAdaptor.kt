package com.group2elearningapp.cplusplus

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class activityAdaptor(stdn:String) : RecyclerView.Adapter<CustomViewHolder>(){

    lateinit var handler:DatabaseHelper
    lateinit var onlinehandler: OnlineDBhelper


    val listOfTitle = listOf<String>("Print Out","Math Operations","Loopers"
    )

    override fun getItemCount(): Int {
        return listOfTitle.size
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int,): CustomViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)

        val cellforlesson = layoutInflater.inflate(R.layout.activitydesign, parent, false)
        return CustomViewHolder(cellforlesson)
    }

    override fun onBindViewHolder(holder: CustomViewHolder, position: Int) {
        val arraypostion = listOfTitle[position]
        val pos = position + 1
        holder.view.findViewById<TextView>(R.id.tvActivity).text= "Activity Number "+pos.toString()
        holder.view.findViewById<TextView>(R.id.tvTitle).text= '"'+arraypostion+'"'
        if (pos==1){
            holder.view.findViewById<TextView>(R.id.tvDifficulty).text= "EASY"
            holder.view.findViewById<TextView>(R.id.tvScore).text= "Max Score: 50"

        }
        else if(pos==2){
            holder.view.findViewById<TextView>(R.id.tvDifficulty).text= "MEDIUM"
            holder.view.findViewById<TextView>(R.id.tvScore).text= "Max Score: 100"
        }
        else{
            holder.view.findViewById<TextView>(R.id.tvDifficulty).text= "Hard"
            holder.view.findViewById<TextView>(R.id.tvScore).text= "Max Score: 200"
        }

        if (position<=8){
            //holder.view.findViewById<TextView>(R.id.textView50).text = "10"
        }
        else if (position>8 && position<16){
           // holder.view.findViewById<TextView>(R.id.textView50).text = "15"
        }
        else if (position>15 && position<21){
           // holder.view.findViewById<TextView>(R.id.textView50).text = "25"
        }
        else if (position>20 && position<29){
           // holder.view.findViewById<TextView>(R.id.textView50).text = "50"
        }
    }

}


class activityViewHolder(val view: View): RecyclerView.ViewHolder(view){


    init{
        view.setOnClickListener(){
            val pospos: Int = adapterPosition
            var toktok = adapterPosition+1
            //Toast.makeText(itemView.context, "$toktok", Toast.LENGTH_SHORT).show()

            when (toktok) {
                1 -> {
                    val intent = Intent(view.context, Lesson1::class.java)

                    val randomInteger = (1..12).shuffled().first()
                    //intent.putExtra("ito",)

                    view.context.startActivity(intent)
                }
                2 -> {val intent = Intent(view.context, Lesson_1_1::class.java)
                    view.context.startActivity(intent)}
                3 -> {val intent = Intent(view.context, LogIn::class.java)
                    view.context.startActivity(intent)}
                4 -> {val intent = Intent(view.context, StudentNewAccount::class.java)
                    view.context.startActivity(intent)}
            }
            println(view.context.toString())

        }
    }

}
