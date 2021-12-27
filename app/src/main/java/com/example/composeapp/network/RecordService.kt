package com.example.composeapp.network

import com.example.composeapp.AUTHORIZATION
import com.example.composeapp.data.database.model.RecordBean
import com.example.composeapp.network.beans.BaseResponse
import retrofit2.Call
import retrofit2.http.*

interface RecordService {

    @Headers("Content-Type: application/json")
    @GET("appointment")
    fun getRecordList(
        @Header(AUTHORIZATION) idToken: String,
        @Query("pageSize") pageSize: Int = 100,
        @Query("pageIndex") pageIndex: Int = -1
    ): Call<BaseResponse<RecordBean>>

}