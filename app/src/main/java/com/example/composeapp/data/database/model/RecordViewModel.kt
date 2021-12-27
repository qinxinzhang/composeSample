package com.example.composeapp.data.database.model

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.composeapp.network.beans.RecordsResponse
import com.example.composeapp.viewmodel.RecordRepository
import kotlinx.coroutines.launch

class RecordViewModel : BaseViewModel() {

    private val repository = RecordRepository()

    var recordResponse: RecordsResponse by mutableStateOf(RecordsResponse())

    fun getRecordList(
        idToken: String
    ) {
        viewModelScope.launch {
            val record = repository.getRecordList(idToken)
            if (record != null) {
                recordResponse = record
            }
        }
    }

}