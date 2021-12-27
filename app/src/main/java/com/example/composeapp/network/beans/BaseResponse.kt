package com.example.composeapp.network.beans

import com.example.composeapp.data.database.model.*
import okhttp3.Headers

/**
 * @param c Code
 * @param m Message
 * @param d Data
 * */
class BaseResponse<T> {
    var c: Int = 0
    var m: String? = null
    var d: T? = null
}

open class WrapperResponse<T> {
    open var baseResponse: BaseResponse<T>? = null
    open var exception: Exception? = null
    open var isSuccess: Boolean = true
}

class RawRecordsResponse {
    var baseResponse: BaseResponse<RecordBean>? = null
    var header: Headers? = null
}

class RawRecordItemResponse {
    var baseResponse: BaseResponse<Item>? = null
    var header: Headers? = null
}

class RecordItemResponse {
    var date: String? = null
    var item: Item? = null
}

class RecordsResponse : WrapperResponse<RecordBean>() {
    var date: String? = null
}

class RawChangeAppointmentResponse {
    var baseResponse: BaseResponse<ScheduleRecord>? = null
    var header: Headers? = null
}

class ChangeAppointmentResponse : WrapperResponse<ScheduleRecord>() {
    var date: String? = null
}

class RawCancelAppointmentResponse {
    var baseResponse: BaseResponse<Item>? = null
    var header: Headers? = null
}

class CancelAppointmentResponse : WrapperResponse<Item>() {
    var date: String? = null
}