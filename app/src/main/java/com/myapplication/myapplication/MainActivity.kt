package com.myapplication.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.view.Gravity
import android.view.View
import android.widget.ProgressBar
import android.widget.Toast
import androidx.appcompat.widget.Toolbar
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.myapplication.myapplication.adapters.CvListRecyclerViewAdapter
import com.myapplication.myapplication.apicalls.CvApiAdapter
import com.myapplication.myapplication.models.Cv
import com.myapplication.myapplication.response.CvListApiResponse
import com.myapplication.myapplication.utils.DataUtils
import kotlinx.android.synthetic.main.content_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.lang.ref.WeakReference
import java.util.ArrayList

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        registerViews()
    }

    private fun registerViews() {
        val toolbar = findViewById<Toolbar>(R.id.toolbar)
        setSupportActionBar(toolbar)

        fetchCvsFromGist()
    }

    private fun showToast(txt: String) {
        if (TextUtils.isEmpty(txt)) return
        val toast = Toast.makeText(this, txt, Toast.LENGTH_SHORT)
        toast.setGravity(Gravity.CENTER_HORIZONTAL or Gravity.CENTER_VERTICAL, 0, 0)
        toast.show()
    }

    /**
     *
     * Fetch Cvs from gist using Retrofit
     *
     */
    private fun fetchCvsFromGist() {
        if (!checkInternetConnection()) {
            showToast(getString(R.string.no_connection))
            recyclerViewCvList.visibility = View.GONE
            return
        }
        showProgressDialog()
        val cvApiService = CvApiAdapter.getApiService()
        val call = cvApiService.cvList
        call.enqueue(object : Callback<CvListApiResponse> {
            override fun onResponse(call: Call<CvListApiResponse>,
                                    response: Response<CvListApiResponse>) {
                hideProgressDialog()
                if (response.body() != null) {
                    setAdapter(response.body()?.cvArrayList)
                }
            }

            override fun onFailure(call: Call<CvListApiResponse>, t: Throwable) {
                hideProgressDialog()
            }
        })
    }

    private fun showProgressDialog() {
        progressBar.visibility = View.VISIBLE
    }

    private fun hideProgressDialog() {
        progressBar.visibility = View.GONE
    }

    fun checkInternetConnection(): Boolean {
        return DataUtils.isInternetAvailable(applicationContext)
    }

    /**
     * Method to build the adapter and set it to the recyclerview
     * @param cvArrayList Cv list
     */
    private fun setAdapter(cvArrayList: ArrayList<Cv>?) {
        if (cvArrayList == null || cvArrayList.isEmpty()) return
        recyclerViewCvList.visibility = View.VISIBLE
        // Pass Weak ref to avoid mem leaks
        val cvListRecyclerViewAdapter = CvListRecyclerViewAdapter(
            WeakReference(this),
            cvArrayList)
        recyclerViewCvList.layoutManager = LinearLayoutManager(this)
        recyclerViewCvList.adapter = cvListRecyclerViewAdapter
    }
}
