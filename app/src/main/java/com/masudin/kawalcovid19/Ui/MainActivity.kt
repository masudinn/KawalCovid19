package com.masudin.kawalcovid19.Ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.LinearLayout
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.masudin.kawalcovid19.API.ApiClient
import com.masudin.kawalcovid19.API.ApiService
import com.masudin.kawalcovid19.Adapters.RecyclerAdapter
import com.masudin.kawalcovid19.Model.Corona
import com.masudin.kawalcovid19.R
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        showProgress()

        loadData()

    }

    private fun loadData() {
        val api : ApiService = ApiClient().apiService
        val call : Call<Corona> = api.getCorona()
        call.enqueue(object : Callback<Corona> {
            override fun onFailure(call: Call<Corona>, t: Throwable) {
                dismissProgress()
                Toast.makeText(this@MainActivity, "Error ${t.message}", Toast.LENGTH_SHORT).show()
            }

            override fun onResponse(call: Call<Corona>, response: Response<Corona>) {
                dismissProgress()
                val lManager = LinearLayoutManager(this@MainActivity)
                val adapterView = RecyclerAdapter(response.body()!!, this@MainActivity)
                rv.layoutManager = lManager
                rv.adapter = adapterView
            }

        })
    }

    private fun showProgress() {
        progressBar.visibility = View.VISIBLE
    }

    private fun dismissProgress() {
        progressBar.visibility = View.GONE
    }


}