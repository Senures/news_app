package com.example.newsapp.model

import android.os.Parcelable
import kotlinx.android.parcel.RawValue
import kotlinx.parcelize.Parcelize

@Parcelize
data class Article(
    val author: String,
    val content: String,
    val description: String,
    val publishedAt: String,
    val source:@RawValue Source?=null,
    val title: String,
    val url: String,
    val urlToImage: String
):Parcelable