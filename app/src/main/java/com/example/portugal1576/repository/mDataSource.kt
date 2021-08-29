package com.example.portugal1576.repository

import androidx.paging.PageKeyedDataSource
import com.example.portugal1576.model.News
import com.example.portugal1576.repository.network.api
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

class mDataSource(private val scope: CoroutineScope) : PageKeyedDataSource<Int, News>() {

    override fun loadInitial(
        params: LoadInitialParams<Int>,
        callback: LoadInitialCallback<Int, News>
    ) {
        var list = emptyList<News>()
        scope.launch {
            list = api.news.getPagin(0)
        }
        callback.onResult(list, null, 1)

    }

    override fun loadBefore(params: LoadParams<Int>, callback: LoadCallback<Int, News>) {

    }

    override fun loadAfter(params: LoadParams<Int>, callback: LoadCallback<Int, News>) {
        var list = emptyList<News>()
        scope.launch {
            list = api.news.getPagin(params.key)
        }
        callback.onResult(list, (params.key+1))
    }
}