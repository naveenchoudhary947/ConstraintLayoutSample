package com.drishinfo.constraintlayoutsample

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

/**
 * Created by Drish Infotech on 11/17/18.
This class is used in this project
 */
@Parcelize
data class Contact(
    @SerializedName("Category") val Category: String,
    @SerializedName("Date") val Date: String,
    @SerializedName("Desc") val Desc: String,
    @SerializedName("Email") val Email: String,
    @SerializedName("Image") val Image: String,
    @SerializedName("Name") val Name: String
) : Parcelable