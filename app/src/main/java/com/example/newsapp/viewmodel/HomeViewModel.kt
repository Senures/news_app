package com.example.newsapp.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.newsapp.model.Article
import com.example.newsapp.repository.NewsRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class HomeViewModel @Inject constructor(private val repository: NewsRepository):ViewModel(){
    private val _response= MutableLiveData<List<Article>>()
    val responseNews :LiveData<List<Article>>
        get() =_response
    init {

        getBreakingNews()
    }




    fun getBreakingNews()=viewModelScope.launch{

        println("VERIIKE")

        repository.getBreakingNews().let{response ->
            if(response.isSuccessful){
                println("RES === " + response.body().toString())
                println("RES === " + response.body()?.articles.toString())
               _response.postValue(response.body()!!.articles);
            }else{
                Log.d("tag","errorrrrrrr:${response.code()}")
            }
        }

    }
}