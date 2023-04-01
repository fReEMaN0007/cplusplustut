package com.group2elearningapp.cplusplus

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class mainAdapter() : RecyclerView.Adapter<CustomViewHolder>(){

    lateinit var handler:DatabaseHelper
    lateinit var onlinehandler: OnlineDBhelper


    val listOfTitle = listOf<String>("Complete Lesson 1", "Complete Lesson 1.1", "Complete Lesson 1.2",
                                        "Complete Lesson 1.3","Complete Lesson 2","Complete Lesson 2.1",
                                    "Complete Lesson 2.2","Complete Lesson 2.3","Complete Lesson 3",
                                    "Complete Lesson 4","Complete Lesson 4.1","Complete Lesson 5",
                                    "Complete Lesson 5.1","Complete Lesson 5.2","Complete Lesson 5.3",
                                    "Complete Lesson 5.4","Complete Lesson 6","Complete Lesson 6.1",
                                    "Complete Lesson 6.2","Complete Lesson 6.3","Complete Lesson 6.4",
                                    "Complete Lesson 7","Complete Lesson 7.1","Complete Lesson 7.2","Complete Lesson 7.3",
                                    "Complete Lesson 7.4","Complete Lesson 8","Complete Lesson 8.1","Complete Lesson 8.2")

    override fun getItemCount(): Int {
        return listOfTitle.size
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int,): CustomViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)

        val cellforlesson = layoutInflater.inflate(R.layout.lesson2nd, parent, false)
        return CustomViewHolder(cellforlesson)
    }

    override fun onBindViewHolder(holder: CustomViewHolder, position: Int) {
        val arraypostion = listOfTitle[position]
        val pos = position + 1
        holder.view.findViewById<TextView>(R.id.textView52).text= arraypostion

        if (position<=8){
        holder.view.findViewById<TextView>(R.id.textView50).text = "10"
        }
        else if (position>8 && position<16){
            holder.view.findViewById<TextView>(R.id.textView50).text = "15"
        }
        else if (position>15 && position<21){
            holder.view.findViewById<TextView>(R.id.textView50).text = "25"
        }
        else if (position>20 && position<29){
            holder.view.findViewById<TextView>(R.id.textView50).text = "50"
        }
    }

    }


class CustomViewHolder(val view: View,): RecyclerView.ViewHolder(view){

    init{
        view.setOnClickListener(){
            val pospos: Int = adapterPosition
            var toktok = adapterPosition+1
            //Toast.makeText(itemView.context, "$toktok", Toast.LENGTH_SHORT).show()
            when (toktok) {
                1 -> {
                    val intent = Intent(view.context, Lesson1::class.java)
                    intent.putExtra("ito","tekanga")

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
