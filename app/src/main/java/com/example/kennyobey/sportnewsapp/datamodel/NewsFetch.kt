package com.example.kennyobey.sportnewsapp.datamodel

///https://newsapi.org/v2/sources?category=sports&apiKey=76e05fa7414946f0a4a5e283bd2229b6

data class NewsFetch(
    val articles: List<Article>,
    val status: String,
    val totalResults: Int
)

data class Article(
    val author: String,
    val content: String,
    val description: String,
    val publishedAt: String,
    val source: Source,
    val title: String,
    val url: String,
    val urlToImage: String
)

data class Source(
    val id: Any,
    val name: String
)