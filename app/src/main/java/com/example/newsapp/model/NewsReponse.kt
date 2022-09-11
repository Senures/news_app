package com.example.newsapp.model

import com.example.newsapp.model.Article

data class NewsReponse(
    val articles: List<Article>,
    val status: String,
    val totalResults: Int
)