package com.myapplication.myapplication

import com.myapplication.myapplication.apicalls.CvApiAdapter
import com.myapplication.myapplication.response.CvListApiResponse
import kotlinx.android.synthetic.main.content_main.*
import org.junit.Assert.*
import org.junit.Before
import org.junit.Test
import org.mockito.Mockito.mock
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivityTest {

    private var mainActivity: MainActivity? = null

    @Before
    @Throws(Exception::class)
    fun setUp() {
        mainActivity = mock(MainActivity::class.java)
    }

    @Test
    @Throws(Exception::class)
    fun activityNotNull() {
        assertNotNull(mainActivity)
    }

    @Test
    fun fetchCvsFromGist() {
        val cvApiService = CvApiAdapter.getApiService()
        val call = cvApiService.cvList
        call.enqueue(object : Callback<CvListApiResponse> {
            override fun onResponse(
                call: Call<CvListApiResponse>,
                response: Response<CvListApiResponse>
            ) {
                assertTrue(response.isSuccessful && response.body() != null)
            }

            override fun onFailure(call: Call<CvListApiResponse>, t: Throwable) {
            }
        })
    }
}