package com.example.composeapp.viewmodel

import com.example.composeapp.network.RecordService
import com.example.composeapp.network.ServiceCreator
import com.example.composeapp.network.beans.RecordsResponse
import com.example.composeapp.network.networkCallRecords

object RecordWebService {
    private val recordService = ServiceCreator.create(RecordService::class.java)

    suspend fun getRecordList(
        idToken: String
    ): RecordsResponse {
        val call = recordService.getRecordList(idToken)
        return networkCallRecords(call)
    }

}