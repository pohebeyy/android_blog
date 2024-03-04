package com.example.blog

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.ListView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class NewsAdapter(var news: List<News>, var context: Context) :
    RecyclerView.Adapter<NewsAdapter.MyViewHolder>() {

    class MyViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val title: TextView = view.findViewById(R.id.news_list_title)
        val desc: TextView = view.findViewById(R.id.news_list_desc)
        val btn: Button = view.findViewById(R.id.news_list_button)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.news_in_list, parent, false)
        return MyViewHolder(view)
    }

    override fun getItemCount(): Int {
        return news.count()
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.title.text = news[position].title
        holder.desc.text = news[position].desc
        holder.btn.setOnClickListener {
            val intent = Intent(context, NewsAcrivity::class.java)
            intent.putExtra("newsTitle", news[position].title)
            intent.putExtra("newsText", news[position].text)
            context.startActivity(intent)
        }
    }

    fun updateNews(newNews: List<News>) {
        news = newNews
        notifyDataSetChanged()
    }
}
