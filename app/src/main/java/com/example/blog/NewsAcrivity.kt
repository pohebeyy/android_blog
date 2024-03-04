package com.example.blog

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.PersistableBundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class NewsAcrivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_news_acrivity)
        val title:TextView = findViewById(R.id.news_list_title_one)
        val text:TextView = findViewById(R.id.news_list_text)
        title.text = intent.getStringExtra("newsTitle")
        text.text = intent.getStringExtra("newsText")
        val GoMain:Button = findViewById(R.id.news_list_button_main)
        GoMain.setOnClickListener{
            val intent = Intent(this,BlogMain::class.java)
            startActivity(intent)
        }


    }




}