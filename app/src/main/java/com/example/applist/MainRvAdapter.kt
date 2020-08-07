package com.example.applist

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class MainRvAdapter(val context: Context, val competitionList: ArrayList<List>, val itemClick: (List) -> Unit) : RecyclerView.Adapter<MainRvAdapter.Holder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        val view = LayoutInflater.from(context).inflate(R.layout.item,parent,false)
        return Holder(view, itemClick)
    }
    override fun getItemCount(): Int {
        return competitionList.size
    }

    override fun onBindViewHolder(holder: Holder, position: Int) {
        holder.bind(competitionList[position], context)
    }

        inner class Holder(itemView: View?, itemClick: (List) -> Unit) : RecyclerView.ViewHolder(itemView!!) {

            val comptPhoto = itemView?.findViewById<ImageView>(R.id.imageView)
            val comptTitle = itemView?.findViewById<TextView>(R.id.itemList)
            val comptSubtitle = itemView?.findViewById<TextView>(R.id.itemListDetail)

            //ViewHolder와 클래스의 각 변수를 연동하는 역할
            fun bind(list:List, context: Context){
                //comptPhoto의 setImageResource에 들어갈 이미지의 id를 파일명(String)으로 찾고,
                //이미지가 없는 경우 안드로이드 기본 아이콘 표시
                if(list.photo !="") {
                    val resourceId =
                        context.resources.getIdentifier(list.photo, "drawable", context.packageName)
                    comptPhoto?.setImageResource(resourceId)
                } else{
                    comptPhoto?.setImageResource(R.mipmap.ic_launcher)
                }
                //나머지 textview와 string데이터를 연결
                comptTitle?.text = list.title
                comptSubtitle?.text = list.subtitle

                itemView.setOnClickListener { itemClick(list) }
            }
        }

}
