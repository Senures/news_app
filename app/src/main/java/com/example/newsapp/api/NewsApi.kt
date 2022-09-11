package com.example.newsapp.api

import com.example.newsapp.model.NewsReponse
import com.example.newsapp.utils.Constant.Companion.API_KEY
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

//step 2 interface classını oluştur.
interface NewsApi {


    @GET("v2/top-headlines")
    suspend fun  getBreakingNews(
        @Query("country") countryCode:String="us",
        @Query("page") pageNumber:Int=1,
        @Query("apiKey") apiKey:String=API_KEY,
    ):Response<NewsReponse>


    @GET("v2/everything")
    suspend fun  searchForNews(
        @Query("q")  searchQuery:String,
        @Query("page") pageNumber:Int=1,
        @Query("apiKey") apiKey:String=API_KEY,
    ):Response<NewsReponse>
}