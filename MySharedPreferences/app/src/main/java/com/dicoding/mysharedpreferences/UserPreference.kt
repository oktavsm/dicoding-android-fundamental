package com.dicoding.mysharedpreferences

import android.content.Context
import androidx.core.content.edit

internal class UserPreference(context: Context) {
    companion object{
        private const val PREFS_NAME = "user_pref"
        private const val NAME = "name"
        private const val EMAIL = "email"
        private const val AGE = "age"
        private const val PHONE_NUMBER = "phone"
        private const val LOVE_MU = "isLove"
    }
private val preference = context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE)

    fun setUser(value: UserModel){
        preference.edit {
            putString(NAME, value.name)
            putString(EMAIL, value.email)
            putInt(AGE, value.age)
            putString(PHONE_NUMBER, value.phoneNumber)
            putBoolean(LOVE_MU, value.isLove)
        }
    }

    fun getUser(): UserModel{
        val model = UserModel()
        model.name = preference.getString(NAME, "")
        model.email = preference.getString(EMAIL, "")
        model.age = preference.getInt(AGE, 0)
        model.phoneNumber = preference.getString(PHONE_NUMBER, "")
        model.isLove = preference.getBoolean(LOVE_MU, false)

        return model
    }
}

