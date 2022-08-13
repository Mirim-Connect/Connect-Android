package com.example.connect_android

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ListView

class MainActivity : AppCompatActivity() {

    var humanList = arrayOf<ListViewItem>(
        ListViewItem("박떙땡","남자",R.drawable.human,"가출인",
            "2022.08.13","21세","서울특별시 강동구 천호동","검은색 모자","50kg"),
        ListViewItem("홍길동","남자",R.drawable.human,"가출인",
        "2022.08.13","21세","서울특별시 강동구 천호동","검은색 모자","50kg"),
        ListViewItem("김갑수","남자",R.drawable.human,"가출인",
            "2022.08.13","21세","서울특별시 강동구 천호동","검은색 모자","50kg")
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val listView = findViewById<ListView>(R.id.listView)

        val Adapter = ListViewAdapter(this, humanList)
        listView.adapter = Adapter
    }
}
