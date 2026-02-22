package com.dicoding.mynotesapp.entity

import android.os.Parcelable

@kotlinx.parcelize.Parcelize
data class Note(
    var id: Int =0,
    var title: String? = null,
    var description: String? = null,
    var date: String? = null
) : Parcelable