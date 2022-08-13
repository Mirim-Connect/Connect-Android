package com.example.connect_android

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.ListView
import com.google.android.material.floatingactionbutton.FloatingActionButton

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
        val listView = findViewById<ListView>(R.id.listview)

        //Adapter 연결
        val Adapter = ListViewAdapter(this, humanList)
        listView.adapter = Adapter

        listView.setOnClickListener {
            val intent = Intent(this@MainActivity, ListViewMoreActivity::class.java)
            startActivity(intent)
        }

        //글쓰기 버튼 클릭 시
        findViewById<FloatingActionButton>(R.id.btn_pencil).setOnClickListener {
            Log.d("mytag", "글쓰기 버튼 클릭")
            val intent = Intent(this@MainActivity, Human_writepage::class.java)
            startActivity(intent)
        }
    }
}
