package com.drishinfo.constraintlayoutsample

import com.google.gson.annotations.SerializedName

data class ContactsResponse(
    @SerializedName("Contacts") val Contacts: List<Contact>
)

