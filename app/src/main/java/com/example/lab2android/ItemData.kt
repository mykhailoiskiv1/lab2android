package com.example.lab2android

import kotlinx.android.parcel.Parcelize
import android.os.Parcelable

@Parcelize
data class ItemData(
    val title: String,
    val description: String,
    val imageUrl: String,
    val additionalInfo: String
) : Parcelable
