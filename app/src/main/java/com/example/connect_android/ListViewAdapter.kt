package com.example.connect_android

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView
import java.util.*

class ListViewAdapter(val context: Context, val humanList: Array<ListViewItem>) : BaseAdapter() {
    override fun getCount(): Int {
        return humanList.size
    }

    override fun getItem(position: Int): Any {
        return humanList[position]
    }

    override fun getItemId(position: Int): Long {
        return 0
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val view: View = LayoutInflater.from(context).inflate(R.layout.custom_listitem_human, null)

        val name = view.findViewById<TextView>(R.id.name)
        val sex = view.findViewById<TextView>(R.id.sex)
        val img = view.findViewById<ImageView>(R.id.img)
        val type = view.findViewById<TextView>(R.id.type)
        val missingDate = view.findViewById<TextView>(R.id.missingDate)
        val missingAge = view.findViewById<TextView>(R.id.missingAge)
        val missingPlace = view.findViewById<TextView>(R.id.missingPlace)
        val clothing = view.findViewById<TextView>(R.id.clothing)
        val characteristics = view.findViewById<TextView>(R.id.characteristics)

        val human = humanList[position]
        img.setImageResource(human.img)
        name.text = human.name
        sex.text = human.sex
        type.text = human.type
        missingDate.text = human.missingDate
        missingAge.text = human.missingAge
        missingPlace.text = human.missingPlace
        clothing.text = human.clothing
        characteristics.text = human.characteristics


        return view
    }

}