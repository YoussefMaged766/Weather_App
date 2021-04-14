package com.example.weatherapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback

class MainActivity : AppCompatActivity() {
    lateinit var adapter: adapter
    lateinit var layoutManager: RecyclerView.LayoutManager
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        recycler()
        getdatafromapi()


    }

    fun getdatafromapi() {
        apimanager.getwebbservices().getWeather("London,uk", "e4204a9069ecb8022a758134ae5c46ba")
            .enqueue(object : Callback<Response> {
                override fun onResponse(
                    call: Call<Response>,
                    response: retrofit2.Response<Response>
                ) {
                    if (response.isSuccessful) {
                        txtname.text = response.body()?.name
                        adapter.getdata(response.body()?.weather as MutableList<WeatherItem>)
                        Log.e("TAG", "onResponse: " + response.body()?.weather)
                    } else {
                        Toast.makeText(this@MainActivity, response.message(), Toast.LENGTH_LONG)
                            .show()
                    }


                }

                override fun onFailure(call: Call<Response>, t: Throwable) {
                    Toast.makeText(this@MainActivity, t.localizedMessage, Toast.LENGTH_LONG).show()
                }

            })

    }

    fun recycler(){

        adapter = adapter()
        layoutManager = LinearLayoutManager(this, RecyclerView.VERTICAL, false)
        recycler.adapter = adapter
        recycler.layoutManager=layoutManager
    }
}