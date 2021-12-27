package com.example.composeapp.data.database.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

data class ScheduleRecord(
    val appointment: Item?,
    val payment: PaymentX?
)

data class NutritionWithFollowUp(
    val nutrition: ScheduleRecord?,
    val appointment: ScheduleRecord?
)

data class PaymentX(
    val payType: String?,
    val status: String?,
    val verificationUrl: String?,
    val paymentId: String?,
    val redirectUrl: String?
)

data class NutritionRequest(
    val appointmentId: String?,
    val payType: String?,
    val tokenId: String?,
    val promoCode: String?
)

@Parcelize
data class Patient(
    val HMO_member: Boolean?,
    val HMO_membership: String?,
    val HMO_membership_ID: String?,
    val birthday: String?,
    val carespanId: String?,
    val comment: String?,
    val familyName: String?,
    val gender: String?,
    val givenName: String?,
    val id: String?,
    val relationship: String?
) : Parcelable

@Parcelize
data class Practitioner(
    val avatar: String?,
    val carespanId: String?,
    val hospitalId: String?,
    val hospitalName: String?,
    val id: String?,
    val name: String?,
    val specialisation: List<String>?,
    val joinSubscription: Boolean?,
    val nutritionPrice: Float?,
    val isNutritionist: Boolean?,
    val pointsPerNutrition: Float?,
    val isJoinCampaign: Boolean? = false
) : Parcelable

@Parcelize
data class Payment(
    val amount: Float?,
    val currency: String?,
    val detail: Detail?,
    val method: String?,
    val paySuccessAt: Long?,
    val payUrl: String?,
    val paymentId: String?,
    val penalty: Penalty?,
    val price: Price?,
    val refundAmount: Float?,
    val status: String?
) : Parcelable

@Parcelize
data class Detail(
    val email: String?,
    val firstName: String?,
    val lastName: String?,
    val masked: String?,
    val middleName: String?,
    val msisdn: String?,
    val last4: String?,
    val scheme: String?,
    val first6: String?,
    val issuer: String?
) : Parcelable

@Parcelize
data class Penalty(
    val deduction: Float?,
    val message: String,
    val reason: String,
    val recharge: Float?,
    val refundAmount: Float?
) : Parcelable

@Parcelize
data class Price(
    val VATFee: Float?,
    val consultationFee: Float?,
    val paid: Float?,
    val discountInfo: DiscountInfo?,
    val nutritionPrice: Float?,
    val platformFee: Float?,
    val points: Float?,
    val total: Float?
) : Parcelable

@Parcelize
data class DiscountInfo(
    val amount: Float?,
    val code: String?,
    val name: String?,
    val originAmount: Float?,
    val type: String?,
    val value: Float?
) : Parcelable