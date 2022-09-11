package com.example.newsapp.di

import com.example.newsapp.api.NewsApi
import com.example.newsapp.repository.NewsRepository
import com.example.newsapp.utils.Constant
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {
    @Provides
    fun provideBaseUrl()=Constant.BASE_URL

    @Provides
    @Singleton
    fun provideRetrofitInstance(BASE_URL:String):NewsApi=
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build().
            create(NewsApi::class.java)

    //singleton yapı app boyu repo bir kere oluşturulcak ve içinde servis ile gelicek
    //reponun nesnesini her viewmodelda ayrı ayrı oluşturmak zorunda kalmıyoruz.
    @Provides

    fun providesRepository(
        apiService:NewsApi
    ) = NewsRepository(apiService)
}