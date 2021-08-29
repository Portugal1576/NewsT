package com.example.portugal1576.ui.fragments.news

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.PageKeyedDataSource
import androidx.paging.PagedList
import com.example.portugal1576.model.News
import com.example.portugal1576.model.Status
import com.example.portugal1576.repository.Repository
import com.example.portugal1576.repository.mDataSource
import kotlinx.coroutines.launch
import java.util.concurrent.Executors

class NewsViewModel: ViewModel() {
    lateinit var pagedList: PagedList<News>
    var list: List<News> = emptyList()
    private val _status: MutableLiveData<Status> = MutableLiveData()
    val status: LiveData<Status> get() = _status

init{
    _status.value = Status.EMPTY
    getNews()
}

    private fun getNews() {
        _status.value = Status.LOADING
        val dataSource: PageKeyedDataSource<Int, News> = mDataSource(viewModelScope)
        val config = PagedList.Config.Builder().build()
        val pagetList: PagedList<News> = PagedList.Builder<Int, News>(dataSource, config)
            .setNotifyExecutor(Executors.newSingleThreadExecutor())
            .setFetchExecutor(Executors.newSingleThreadExecutor())
            .build()
        this.pagedList = pagetList
        _status.value = Status.SUCCESS


    }

}