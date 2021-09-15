package com.example.portugal1576.repository

import android.app.Application
import com.example.portugal1576.model.News
import com.example.portugal1576.repository.network.api

//наследуемся от апликейшин, чтобы класс жил, пока приложение работает
class Repository: Application() {

    init {
        instance = this
    }

    companion object {
        @Volatile
        lateinit var instance: Repository
    }

    //эта функция возвращает наш ретрофит его конвертирует в List<News>

    suspend fun getNews(): List<News>{
        return api.news.get()
    }
    suspend fun getNewsPaggin(page: Int): List<News>{
        return api.news.getPagin(page)
    }
}