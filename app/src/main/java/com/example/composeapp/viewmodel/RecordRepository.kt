package com.example.composeapp.viewmodel

import com.example.composeapp.NETWORK_RESPONSE_STATUS_OK
import com.example.composeapp.data.database.model.RecordBean
import com.example.composeapp.network.beans.RecordsResponse

class RecordRepository {
    private var records: RecordsResponse? = null
    suspend fun getRecordList(idToken: String): RecordsResponse? {

        val response = RecordWebService.getRecordList(idToken)
        records = if (response.isSuccess) {
            var c = response.baseResponse?.c

            /**
             *  if the account is registered as a doctor, redesign the response,
             *  show no records
             */
            if (c == REGISTERED_AS_A_DOCTOR) {
                c = 200
                response.baseResponse?.d =
                    RecordBean(Count = 0, Items = emptyList(), ScannedCount = 0)
            }

            if (c == null || c != NETWORK_RESPONSE_STATUS_OK) {
                null
            } else {
                response
            }
        } else {
            null
        }
        return records
    }

    companion object {

        const val REGISTERED_AS_A_DOCTOR = 50001

        private lateinit var instance: RecordRepository

        fun getInstance(): RecordRepository {
            if (!Companion::instance.isInitialized) {
                synchronized(RecordRepository::class.java) {
                    if (!Companion::instance.isInitialized) {
                        instance = RecordRepository()
                    }
                }
            }
            return instance
        }
    }
}