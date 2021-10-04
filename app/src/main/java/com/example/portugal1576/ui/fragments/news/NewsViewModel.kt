package com.example.portugal1576.ui.fragments.news

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.portugal1576.model.News
import com.example.portugal1576.model.Status
import com.example.portugal1576.repository.Repository
import kotlinx.coroutines.launch

class NewsViewModel : ViewModel() {

    private var page = 0
    var list: MutableList<News> = mutableListOf()

    private val _status: MutableLiveData<Status> = MutableLiveData()
    private val _status2: MutableLiveData<Status> = MutableLiveData()
    val status: LiveData<Status> get() = _status
    val status2: LiveData<Status> get() = _status2


    init {
        _status.value = Status.EMPTY
        _status2.value = Status.EMPTY
        getNews()
    }

    private fun getNews() {
        _status.value = Status.LOADING
        viewModelScope.launch {
            try {
                list = Repository.instance.getNews().toMutableList()
                if (list.isEmpty()) _status.value = Status.ERROR
                else _status.value = Status.SUCCESS
            } catch (e: Exception) {
                _status.value = Status.ERROR
            }
        }
    }

    fun onScrolled() {

        _status2.value = Status.LOADING
        viewModelScope.launch {
            try {
                list = Repository.instance.getNewsPaggin(page).toMutableList()
                page++
                _status2.value = Status.SUCCESS
            } catch (e: Exception) {
                _status2.value = Status.ERROR
            }
        }

    }

}