package com.dicoding.mynotesapps.helper

import java.text.SimpleDateFormat

object DateHelper {
    fun getCurrentDate(): String{
        val dateFormat = SimpleDateFormat("yyyy/MM/dd HH:mm:ss")
        val date = java.util.Date()
        return dateFormat.format(date)
    }

}