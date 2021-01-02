package com.example.app

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.RecyclerView

class RecyclerViewActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recycler_view)
        val recycler = findViewById<RecyclerView>(R.id.rListView)

        val data = (0..100).map { "МИХА, ЛИДЕР!"}//"Value #$it" }
        recycler.adapter=MyRecyclerAdapter(data)
    }
}