package com.example.applist

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.widget.Toolbar
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*



class MainActivity : AppCompatActivity() {


    var competitionList = arrayListOf<List>(
        List("토익스터디 모집","5명 모집", "icon_toeic"),
        List("토익스터디 모집","2명 모집", "icon_toeic"),
        List("토익스터디 모집","1명 모집", "icon_toeic"),
        List("토익스터디 모집","50명 모집", "icon_toeic"),
        List("토익스터디 모집","뻥이고 놀아요", "icon_toeic"),
        List("토익스터디 모집","술 안마심", "icon_toeic"),
        List("토익스터디 모집","놀아요", "icon_toeic"),
        List("토익스터디 모집","마감 임박", "icon_toeic"),
        List("토익스터디 모집","오세요", "icon_toeic"),
        List("토익스터디 모집","뻥이고 놀아요", "icon_toeic"),
        List("토익스터디 모집","뻥이고 놀아요", "icon_toeic")

    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //툴바 시작
        val toolbar = findViewById(R.id.toolbar) as Toolbar
        setSupportActionBar(toolbar)
        val ab = supportActionBar!!
        ab.setDisplayShowTitleEnabled(false)

        //RecyclerView Adapter
        val mAdapter = MainRvAdapter(this, competitionList) {
           // list -> Toast.makeText(this, "개의 품종은 어쩌구다", Toast.LENGTH_SHORT).show()
           //클릭 intent
            val intent = Intent(this, SpecificActivity::class.java)
            startActivity(intent)
        }
        recycler_view.adapter = mAdapter

        val lm = LinearLayoutManager(this)
        recycler_view.layoutManager = lm
        recycler_view.setHasFixedSize(true)



        //뒤로가기 버튼
        ab.setDisplayHomeAsUpEnabled(true)
        //글 추가 버튼 아직 완료 안됨
       /* val go_intent = findViewById(R.id.add_competition) as Button
            go_intent.setOnClickListener{
                val intent = Intent(this@MainActivity, SpecificActivity::class.java)
                startActivity(intent)
            }*/
    }
    //뒤로가기 버튼 시작
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        val id = item.itemId
        when (id) {
            android.R.id.home -> {
                finish()
                return true
            }
        }
        return super.onOptionsItemSelected(item)
    }
}