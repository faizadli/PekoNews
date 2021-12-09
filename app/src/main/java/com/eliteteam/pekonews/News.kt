package com.eliteteam.pekonews

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class News(
    var description: String = "",
    var name: String = "",
    var photo: Int?,
    var date: String = ""
) : Parcelable
