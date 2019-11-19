package com.myapplication.myapplication.response

import com.google.gson.annotations.SerializedName
import com.myapplication.myapplication.models.Cv
import java.util.ArrayList

class CvListApiResponse {

    @SerializedName("cv_list")
    var cvArrayList: ArrayList<Cv>? = null
}