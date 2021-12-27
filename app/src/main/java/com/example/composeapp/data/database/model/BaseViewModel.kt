package com.example.composeapp.data.database.model

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel


open class BaseViewModel : ViewModel() {
    protected val _isLoadingLiveData: MutableLiveData<Boolean> = MutableLiveData(false)
    val isLoadingLiveData: LiveData<Boolean> = _isLoadingLiveData

    protected val _isNetworkFailedLiveData: MutableLiveData<Boolean> = MutableLiveData(false)
    val isNetworkFailedLiveData: LiveData<Boolean> = _isNetworkFailedLiveData

}