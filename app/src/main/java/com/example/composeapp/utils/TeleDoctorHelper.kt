package com.example.composeapp.utils

import android.annotation.SuppressLint
import com.example.composeapp.data.database.model.helper.RecordStatus
import com.example.composeapp.data.database.model.helper.RecordType
import java.text.SimpleDateFormat
import java.util.*
import java.util.concurrent.TimeUnit

object TeleDoctorHelper {
    private val UPCOMING_THRESHOLD = TimeUnit.MINUTES.toMillis(15)
    private val HAPPENING_NOW_THRESHOLD = TimeUnit.MINUTES.toMillis(10)
    const val CURRENT_TIME = "EEE, dd MMM yyyy HH:mm:ss z"

    @SuppressLint("ConstantLocale")
    private val formatter: SimpleDateFormat =
        SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss", Locale.getDefault())

    fun convertRecordStatus(status: String?, current: String?, start: String?, end: String?): Int {
        val currentTimeStamp = TimeUtils.parseStringToTime(current.toString(), CURRENT_TIME)
        val startTimeStamp = dateFormatToLong(start.toString()) ?: 0L
        val endTimeStamp = dateFormatToLong(end.toString()) ?: 0L
        return when (status.toString()) {
            RecordStatus.SERVER_BOOKED -> {
                if (currentTimeStamp < (startTimeStamp - UPCOMING_THRESHOLD)) {
                    RecordType.TYPE_UPCOMING
                } else if (currentTimeStamp < startTimeStamp && currentTimeStamp >= (startTimeStamp - UPCOMING_THRESHOLD)) {
                    RecordType.TYPE_HAPPENING_SOON
                } else if (currentTimeStamp >= startTimeStamp && currentTimeStamp < (startTimeStamp + HAPPENING_NOW_THRESHOLD)) {
                    RecordType.TYPE_HAPPENING_NOW
                } else {
                    RecordType.TYPE_MISSED
                }
            }
            RecordStatus.SERVER_STARTED -> {
                if (currentTimeStamp < startTimeStamp && currentTimeStamp >= (startTimeStamp - UPCOMING_THRESHOLD)) {
                    RecordType.TYPE_HAPPENING_SOON
                } else if (currentTimeStamp >= startTimeStamp && currentTimeStamp < (startTimeStamp + HAPPENING_NOW_THRESHOLD)) {
                    RecordType.TYPE_HAPPENING_NOW
                } else if (currentTimeStamp > endTimeStamp) {
                    RecordType.TYPE_PENDING_RESULT
                } else {
                    RecordType.TYPE_HAPPENING_NOW
                }
            }
            RecordStatus.SERVER_MISSED_BY_PATIENT, RecordStatus.SERVER_MISSED_BY_DOCTOR -> RecordType.TYPE_MISSED
            RecordStatus.SERVER_CANCELLED_BY_DOCTOR, RecordStatus.SERVER_CANCELLED_BY_PATIENT -> RecordType.TYPE_CANCELLED
            RecordStatus.SERVER_BOOKING -> RecordType.TYPE_BOOKING
            RecordStatus.SERVER_COMPLETED -> RecordType.TYPE_COMPLETED
            //just ignore [RecordType.TYPE_COMPLETED_FEEDBACK] won't be used here
            else -> RecordType.TYPE_MISSED
        }
    }

    fun dateFormatToLocalTime(time: String): String {
        try {
            formatter.parse(time)?.let {
                return SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.getDefault()).format(it)
            }
        } catch (e: Exception) {
            e.printStackTrace()
        }
        return ""
    }

    fun dateFormat(time: String): Date? {
        try {
            return formatter.parse(time)
        } catch (e: Exception) {
            e.printStackTrace()
        }
        return null
    }

    fun dateFormatToLong(time: String): Long? {
        try {
            return formatter.parse(time)?.time
        } catch (e: Exception) {
            e.printStackTrace()
        }
        return null
    }
}