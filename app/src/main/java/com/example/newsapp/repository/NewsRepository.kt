package com.example.newsapp.repository

import com.example.newsapp.api.NewsApi
import com.example.newsapp.utils.Constant.Companion.API_KEY
import javax.inject.Inject

class NewsRepository @Inject constructor(private  val apiService:NewsApi) {
    suspend fun getBreakingNews()=apiService.getBreakingNews("us",1,API_KEY)
    suspend fun getSearchForNews()=apiService.searchForNews("q",1, API_KEY)
}