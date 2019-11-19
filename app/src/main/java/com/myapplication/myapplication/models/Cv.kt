package com.myapplication.myapplication.models

import android.os.Build
import android.os.Parcel
import android.os.Parcelable
import java.util.ArrayList

class Cv(val name: String?, val email: String?, val phone: String?, val linkedIn: String?,
         val profSummary: ArrayList<String>, val techSkills: ArrayList<String>,
         val companies: ArrayList<Company>
) : Parcelable {

    constructor(parcel: Parcel) : this(
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.createStringArrayList() as ArrayList<String>,
        parcel.createStringArrayList() as ArrayList<String>,
        parcel.createTypedArrayList(Company.CREATOR) as ArrayList<Company>
    )

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(name)
        parcel.writeString(email)
        parcel.writeString(phone)
        parcel.writeString(linkedIn)
        parcel.writeStringList(profSummary)
        parcel.writeStringList(techSkills)
        if (Build.VERSION.SDK_INT >= 29) {
            parcel.writeParcelableList(companies, flags)
        } else {
            parcel.writeList(companies as List<Company>)
        }
    }


    override fun describeContents(): Int {
        return 0
    }

    companion object {
        @JvmField
        val CREATOR = object : Parcelable.Creator<Cv> {
            override fun createFromParcel(parcel: Parcel): Cv {
                return Cv(parcel)
            }

            override fun newArray(size: Int): Array<Cv?> {
                return arrayOfNulls(size)
            }
        }
    }
}