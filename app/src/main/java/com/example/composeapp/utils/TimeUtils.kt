package com.example.composeapp.utils

import android.text.format.DateFormat
import java.text.ParseException
import java.text.SimpleDateFormat
import java.util.*

object TimeUtils {

    fun parseStringToTime(string: String, pattern: String): Long {
        try {
            SimpleDateFormat(pattern, Locale.US).parse(string)?.let {
                return it.time
            }
        } catch (e: Exception) {
            e.printStackTrace()
        }
        return 0L
    }

    fun parseTimeToString(time: Long, pattern: String): String {
        try {
            return SimpleDateFormat(pattern, Locale.getDefault()).format(Date(time))
        } catch (e: Exception) {
            e.printStackTrace()
        }
        return ""
    }

    fun parseDateToString(date: Date, pattern: String): String {
        try {
            return SimpleDateFormat(pattern, Locale.getDefault()).format(date)
        } catch (e: Exception) {
            e.printStackTrace()
        }
        return ""
    }

    fun parseTimeToEnglishString(time: Long, pattern: String): String {
        try {
            return SimpleDateFormat(pattern, Locale.US).format(Date(time))
        } catch (e: Exception) {
            e.printStackTrace()
        }
        return ""
    }

    /**
     * convert date format from "MMM-dd-yyyy HH:mm:ss" to "MM-dd-yyyy"
     */

    fun formatDateToDate(originalTime: String): String {
        val form = SimpleDateFormat("MMM-dd-yyyy HH:mm:ss", Locale.US)
        val date: Date?
        var result = ""

        try {
            date = form.parse(originalTime)
            result = SimpleDateFormat("MM-dd-yyyy", Locale.US).format(date!!)

        } catch (e: ParseException) {
            e.printStackTrace()
        }
        return result

    }

    /**
     * convert date format to "MMM dd, yyyy"
     */

    fun formatDateToMonth(originalTime: String): String {
        val form = SimpleDateFormat("yyyy-MM-dd h:mm:ss", Locale.US)
        val date: Date?
        var result = ""
        try {
            date = form.parse(originalTime)
            result = SimpleDateFormat("MMM dd, yyyy", Locale.US).format(date!!)
        } catch (e: ParseException) {
            e.printStackTrace()
        }
        return result
    }

    /**
     * convert date format to "MMM dd, yyyy HH:mm:ss"
     */

    fun formatDateToMonthAndTime(originalTime: String): String {
        val form = SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.US)
        val date: Date?
        var result = ""
        try {
            date = form.parse(originalTime)
            result = SimpleDateFormat("MMM dd, yyyy HH:mm:ss", Locale.US).format(date!!)
        } catch (e: ParseException) {
            e.printStackTrace()
        }
        return result
    }

    /**
     * convert date format to "h:mm a"
     */
    fun formatDateToTime(originalTime: String): String {
        val form = SimpleDateFormat("MMM-dd-yyyy h:mm:ss a", Locale.US)
        val date: Date?
        var result = ""
        try {
            date = form.parse(originalTime)
            result = SimpleDateFormat("h:mm a", Locale.US).format(date!!)

        } catch (e: ParseException) {
            e.printStackTrace()
        }

        return result
    }

    /**
     * parse time stamp to "mm/dd/yyyy"
     */
    fun getCurrentDate(): String {
        val cal = Calendar.getInstance(Locale.US)
        cal.timeInMillis = System.currentTimeMillis()
        return DateFormat.format("MM/dd/yyyy", cal).toString()
    }


    fun getCurrentDateWithFormat(): String {
        val calendar = Calendar.getInstance(Locale.getDefault())
        val year = calendar.get(Calendar.YEAR)
        val month = calendar.get(Calendar.MONTH) + 1
        val day = calendar.get(Calendar.DAY_OF_MONTH)
        val newMonth = if (month < 10) "0$month" else month.toString()
        val newDay = if (day < 10) "0$day" else day.toString()
        return "$year-$newMonth-$newDay"
    }

    /**
     * get format day date string
     */
    fun getCovid19FormatDayDate(timeDay: Long): String {
        try {
            val simpleDateFormat =
                SimpleDateFormat("EEEE, MMMM dd, yyyy", Locale.ENGLISH)
            return simpleDateFormat.format(timeDay)
        } catch (e: ParseException) {
            e.printStackTrace()
        }
        return ""
    }

    fun getAgeWithBirthDay(birthDate: Long): Int {
        val calendar = Calendar.getInstance()
        val currentYear = calendar.get(Calendar.YEAR)
        val currentMonth = calendar.get(Calendar.MONTH) + 1
        val currentDay = calendar.get(Calendar.DATE)
        calendar.time = Date(birthDate)
        val birthYear = calendar.get(Calendar.YEAR)
        val birthMonth = calendar.get(Calendar.MONTH) + 1
        val birthDay = calendar.get(Calendar.DATE)
        val yearMinus = currentYear - birthYear
        val monthMinus = currentMonth - birthMonth
        val dayMinus = currentDay - birthDay
        if (yearMinus <= 0) {
            return 0
        }
        if (monthMinus < 0) {
            return yearMinus - 1
        } else if (monthMinus == 0) {
            if (dayMinus < 0) {
                return yearMinus - 1
            }
        }
        return yearMinus
    }


    /**
     * parse time stamp as "April/dd/yyyy"
     * unit is millisecond
     */
    fun getTimeDate(timeMillis: Long): String {
        return DateFormat.format("MM/dd/yyyy", timeMillis).toString()
    }

    fun convertPatientBirthday(birthDate: String): String {
        val form = SimpleDateFormat("MMM dd, yyyy", Locale.US)
        val date: Date?
        var result = ""
        try {
            date = form.parse(birthDate)
            result = SimpleDateFormat("yyyy/MM/dd", Locale.US).format(date!!)
        } catch (e: ParseException) {
            e.printStackTrace()
        }
        return result
    }

    /**
     * convert challenge "yyyy-MM-dd" to "MMM-dd, yyyy"
     */
    fun convertChallengeTime(challengeTime: String): String {
        val form = SimpleDateFormat("yyyy-MM-dd", Locale.US)
        val date: Date?
        var result = ""
        try {
            date = form.parse(challengeTime)
            result = SimpleDateFormat("MMM dd, yyyy", Locale.US).format(date!!)
        } catch (e: ParseException) {
            e.printStackTrace()
        }
        return result
    }

    fun convertBadgeTime(challengeTime: String): String {
        val form = SimpleDateFormat("yyyy-MM-dd", Locale.US)
        val date: Date?
        var result = ""
        try {
            date = form.parse(challengeTime)
            result = SimpleDateFormat("MMM dd", Locale.US).format(date!!)
        } catch (e: ParseException) {
            e.printStackTrace()
        }
        return result
    }



    fun calculateMonth(month: Int): String {
        return when (month) {
            0 -> "Jan"
            1 -> "Feb"
            2 -> "Mar"
            3 -> "Apr"
            4 -> "May"
            5 -> "Jun"
            6 -> "Jul"
            7 -> "Aug"
            8 -> "Sep"
            9 -> "Oct"
            10 -> "Nov"
            11 -> "Dec"
            else -> ""
        }
    }

    fun calculateWeek(week: Int): String {
        return when (week) {
            1 -> "SUN"
            2 -> "MON"
            3 -> "TUE"
            4 -> "WED"
            5 -> "THU"
            6 -> "FRI"
            7 -> "SAT"
            else -> ""
        }
    }

    fun revertMonth(month: String): Int {
        return when (month) {
            "Jan" -> 1
            "Feb" -> 2
            "Mar" -> 3
            "Apr" -> 4
            "May" -> 5
            "Jun" -> 6
            "Jul" -> 7
            "Aug" -> 8
            "Sep" -> 9
            "Oct" -> 10
            "Nov" -> 11
            "Dec" -> 12
            else -> 0
        }
    }

    fun getCurrentDateRatioInRange(startTime: Long, endTime: Long): Float {
        val currentTime = Calendar.getInstance().timeInMillis
        return (currentTime - startTime).toFloat() / (endTime - startTime).toFloat()
    }

    const val ONE_DAY_MILLIS = 1000 * 60 * 60 * 24L
    const val PREGNANCY_DAYS = 280L

    const val SELECT_DATE_FORMAT: String = "yyyy/MM/dd"
    const val PROMPT_DATE_FORMAT: String = "dd MMM, yyyy"
    const val FORMAT_MMM_DD_YYYY: String = "MMM dd, yyyy"
    const val FORMAT_MMM_DD: String = "MMM dd"

}