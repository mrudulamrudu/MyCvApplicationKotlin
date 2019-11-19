package com.myapplication.myapplication.apicalls

import com.myapplication.myapplication.response.CvListApiResponse
import retrofit2.Call
import retrofit2.http.GET

interface CvApiService {

    @get:GET("mrudulamrudu/8f2fc3d93dad42892ef38d54eec4d163/raw/c848b38c7700b44e0bc8fb1031d103f56146f87d/cv_list.json")
    val cvList: Call<CvListApiResponse>
}