package ua.kiss.mvvm_learn.view.less02

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class TestActivityViewModel: ViewModel() {
    val textUpdater:MutableLiveData<String> by lazy { MutableLiveData<String>() }

    fun updateString() {
        textUpdater.postValue("Hello Kotlin")
    }
}