package com.myapplication.myapplication.models

import android.os.Parcel
import android.os.Parcelable
import java.util.ArrayList

class Company(val companyName: String?, val companyLogo: String?, val role: String?, val tenure: String?, val location: String?,
val responsibilities: ArrayList<String>, val achievements: ArrayList<String>) : Parcelable {
    constructor(parcel: Parcel) : this(
    parcel.readString(),
    parcel.readString(),
    parcel.readString(),
    parcel.readString(),
    parcel.readString(),
    parcel.createStringArrayList() as ArrayList<String>,
    parcel.createStringArrayList() as ArrayList<String>
    )

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(companyName)
        parcel.writeString(companyLogo)
        parcel.writeString(role)
        parcel.writeString(tenure)
        parcel.writeString(location)
        parcel.writeStringList(responsibilities)
        parcel.writeStringList(achievements)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object {
        @JvmField
        val CREATOR = object : Parcelable.Creator<Company> {
            override fun createFromParcel(parcel: Parcel): Company {
                return Company(parcel)
            }

            override fun newArray(size: Int): Array<Company?> {
                return arrayOfNulls(size)
            }
        }
    }
}