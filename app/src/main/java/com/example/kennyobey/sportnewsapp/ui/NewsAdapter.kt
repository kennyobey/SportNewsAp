package com.example.kennyobey.sportnewsapp.ui

import android.content.Context
import android.content.Intent
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.Glide
import com.example.kennyobey.sportnewsapp.R
import com.example.kennyobey.sportnewsapp.datamodel.NewsFetch
import kotlinx.android.synthetic.main.recyler_view_item.view.*

class NewsAdapter(
    private val context: Context,
    private val news: NewsFetch
):RecyclerView.Adapter<NewsAdapter.NewsViewHolder>() {
    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): NewsViewHolder {
        return NewsViewHolder(
            LayoutInflater.from(context).inflate(R.layout.activity_main,p0,false)
        )
    }

    override fun getItemCount(): Int {
        return news.articles.size
    }

    override fun onBindViewHolder(p0: NewsViewHolder, p1: Int) {
        val result = news.articles[p1]
        p0.itemView.news_title.text = result.title
        p0.itemView.news_date.text = result.publishedAt
        p0.itemView.news_desc.text = result.description
        p0.itemView.news_source.text = result.source.name
        Glide.with(context).load(result.urlToImage).into(p0.itemView.news_img)
    }

    inner class NewsViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView), View.OnClickListener{
        init {
            itemView.setOnClickListener(this)
        }
        override fun onClick(v: View?) {
            val result = news.articles[adapterPosition]
            val intent = Intent(context, FullNews::class.java).apply {
                putExtra("Headline", result.title)
                putExtra("Description", result.description)
                putExtra("publishDate", result.publishedAt)
                putExtra("imageUrl", "https://image.tmdb.org/t/p/w500${result.urlToImage}")
            }
            context.startActivity(intent)
        }

    }

}