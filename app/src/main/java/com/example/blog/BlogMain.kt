package com.example.blog

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class BlogMain : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_blog_main)
        val news:RecyclerView =findViewById(R.id.news)
        val parameter_news = arrayListOf<News>()
        parameter_news.add(News(1,"its project pohebeyy","my Githab https://github.com/pohebeyy","thanks for watching"))
        news.layoutManager = LinearLayoutManager(this)
        news.adapter = NewsAdapter(parameter_news,this)
        val GoAddNews: Button = findViewById(R.id.button)
        GoAddNews.setOnClickListener{
            val intent = Intent(this,AddNews::class.java)
            startActivity(intent)
        }
    }
}