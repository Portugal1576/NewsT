package com.example.portugal1576.ui.fragments.news

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.portugal1576.model.News
import com.example.portugal1576.model.Status
import com.example.portugal1576.repository.Repository
import kotlinx.coroutines.launch

class NewsViewModel: ViewModel() {
    var list: List<News> = emptyList()
    private val _status: MutableLiveData<Status> = MutableLiveData()
    val status: LiveData<Status> get() = _status

init{
    _status.value = Status.EMPTY
    getNews()
}

    private fun getNews() {
        _status.value = Status.LOADING
        viewModelScope.launch {
            try {
                list = Repository.instance.getNews()
                if (list.isEmpty()){
                    _status.value = Status.ERROR

                }
                else {
                    _status.value = Status.SUCCESS
                }            }
            catch (e:Exception) {
                Log.e("MyLog", e.toString())
                _status.value = Status.ERROR
            }
        }
    }
}