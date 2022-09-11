package com.example.newsapp

import android.app.Application
import dagger.hilt.android.HiltAndroidApp

//step 1 bağımlılıkların  oluşturulması için

@HiltAndroidApp
class NewsHiltApplication :Application(){
}