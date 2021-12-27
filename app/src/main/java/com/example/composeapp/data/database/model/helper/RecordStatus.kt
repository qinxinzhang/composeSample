package com.example.composeapp.data.database.model.helper

object RecordStatus {
    const val SERVER_BOOKED = "Booked"
    const val SERVER_MISSED_BY_PATIENT = "Patient_missed"
    const val SERVER_MISSED_BY_DOCTOR = "Practitioner_missed"
    const val SERVER_STARTED = "Started"
    const val SERVER_COMPLETED = "Completed"
    const val SERVER_CANCELLED_BY_DOCTOR = "Practitioner_cancelled"
    const val SERVER_CANCELLED_BY_PATIENT = "Patient_cancelled"
    const val SERVER_BOOKING = "Booking"
    const val SERVER_FAILED = "Failed"

    const val STATUS_MISSED = "Missed"
    const val STATUS_CANCELLED = "Cancelled"
    const val STATUS_UPCOMING = "Upcoming"
    const val STATUS_ALL = "All"
    const val STATUS_PENDING = "Pending"
}