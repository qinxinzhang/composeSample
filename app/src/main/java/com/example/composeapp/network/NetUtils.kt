package com.example.composeapp.network

import com.example.composeapp.data.database.model.RecordBean
import com.example.composeapp.network.beans.BaseResponse
import com.example.composeapp.network.beans.RawRecordsResponse
import com.example.composeapp.network.beans.RecordsResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import kotlin.coroutines.resume
import kotlin.coroutines.resumeWithException
import kotlin.coroutines.suspendCoroutine


suspend fun networkCallRecords(call: Call<BaseResponse<RecordBean>>): RecordsResponse {
    val response = RecordsResponse()
    try {
        val rawResponse = call.getRecordListAwait()
        response.date = rawResponse.header?.get(GET_RECORDS_TIME)
        response.baseResponse = rawResponse.baseResponse
    } catch (e: Exception) {
        response.exception = e
        e.printStackTrace()
    }
    response.isSuccess =
        (response.exception == null)
    return response
}
//for get appointment record list api
private const val GET_RECORDS_TIME = "Date"
suspend fun Call<BaseResponse<RecordBean>>.getRecordListAwait(): RawRecordsResponse {
    val rawResponse = RawRecordsResponse()
    return suspendCoroutine { continuation ->
        enqueue(object : Callback<BaseResponse<RecordBean>> {
            override fun onResponse(
                call: Call<BaseResponse<RecordBean>>,
                response: Response<BaseResponse<RecordBean>>
            ) {
                val header = response.headers()
                val body = response.body()
                rawResponse.baseResponse = body
                rawResponse.header = header
                continuation.resume(rawResponse)
            }

            override fun onFailure(call: Call<BaseResponse<RecordBean>>, t: Throwable) {
                continuation.resumeWithException(t)
            }
        })
    }
}
