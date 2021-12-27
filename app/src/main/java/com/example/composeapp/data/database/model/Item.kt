package com.example.composeapp.data.database.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Item(
    val createAt: Long?,
    val end: String?,
    val id: String?,
    val uuid: String?,
    val operations: List<Operation>?,
    val orderStatus: String?,
    val oncallStatus: String?,
    val patient: Patient?,
    val payment: Payment?,
    val practitioner: Practitioner?,
    val start: String?,
    val status: String?,
    val updateAt: Long?,
    val videoUrl: VideoUrl?,
    val feedback: Feedback?,
    val encounterId: String?,
    val type: String?,
    val timeLimit: Long?,
    val nutritionFile: String?,
    val contactLimitH: Long?,
    val nutrition: Nutrition?,
    val beforeId: String?
) : Parcelable

@Parcelize
data class Operation(
    val at: Long?,
    val content: String?,
    val type: String?
) : Parcelable

@Parcelize
data class Cancellation(
    val carespanId: String,
    val reason: String,
    val role: String,
    val uid: String
) : Parcelable

data class RecordBean(
    val Count: Int?,
    val Items: List<Item>?,
    val ScannedCount: Int?
)

@Parcelize
data class VideoUrl(
    val doctor: String?,
    val patient: String?
) : Parcelable

@Parcelize
data class Feedback(
    val options: List<Option>?,
    val supplement: String?,
    val type: String?
) : Parcelable

@Parcelize
data class Option(
    val id: Int?,
    val name: String?
) : Parcelable

@Parcelize
data class Nutrition(
    val beforeId: String?,
    val createAt: Long?,
    val id: String?,
    val operations: List<Operation>?,
    val orderStatus: String?,
    val patient: Patient?,
    val patientId: String?,
    val payment: Payment?,
    val practitioner: Practitioner?,
    val practitionerId: String?,
    val status: String?,
    val type: String?,
    val updateAt: Long?,
    val uuid: String?
) : Parcelable
