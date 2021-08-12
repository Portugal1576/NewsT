package com.example.portugal1576.repository.network

import com.example.portugal1576.model.News
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET

//JSON конвертор
private val moshi = Moshi.Builder()
    .add(KotlinJsonAdapterFactory())
    .build()

//Retrofit
private val retrofit = Retrofit.Builder()
    .baseUrl("http://188.40.167.45:3001/")
    .addConverterFactory(MoshiConverterFactory.create(moshi))
    .build()

interface NewsRetrofit{
    @GET (".")
    suspend fun get(): List<News>


}

// используем этот обьект для нашего запроса
object api{
    val news: NewsRetrofit by lazy {
        retrofit.create(NewsRetrofit::class.java)
    }
}




