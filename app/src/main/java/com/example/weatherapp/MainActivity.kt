package com.example.weatherapp

import android.opengl.Visibility
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.core.view.isVisible
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.weatherapp.adapter.adapter
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

btnsend.setOnClickListener {
    prgress.visibility = View.VISIBLE
    getdatafromapi()
}

    }

    fun getdatafromapi() {
        apimanager.getwebbservices().getWeather("e4204a9069ecb8022a758134ae5c46ba",txtid.text.toString())
            .enqueue(object : Callback<Response> {
                override fun onResponse(
                    call: Call<Response>,
                    response: retrofit2.Response<Response>
                ) {
                    if (response.isSuccessful) {
                        adapter.getdata(response.body()?.weather as MutableList<WeatherItem>)



                        Log.e("TAG", "onResponse: " + response.body()?.weather)
                    } else {
                        Toast.makeText(this@MainActivity, response.message(), Toast.LENGTH_LONG)
                            .show()
                        prgress.visibility = View.GONE
                    }


                }

                override fun onFailure(call: Call<Response>, t: Throwable) {
                    Toast.makeText(this@MainActivity, t.localizedMessage, Toast.LENGTH_LONG).show()
                    prgress.visibility = View.GONE
                }

            })
            apimanager.getwebbservices().
            getcity("e4204a9069ecb8022a758134ae5c46ba",txtid.text.toString()).enqueue(object : Callback<Response>{
                override fun onResponse(
                    call: Call<Response>,
                    response: retrofit2.Response<Response>
                ) {
                    if (response.isSuccessful){
                        nametextview.visibility = View.VISIBLE
                        degreetextview.visibility=View.VISIBLE
                        speedtextview.visibility = View.VISIBLE
                        prgress.visibility = View.GONE
                        txtname.text = response.body()?.name
                        txtdegree.text = response.body()?.wind?.deg.toString()
                        txtspeed.text = response.body()?.wind?.speed.toString()

                    }
                    else {
                        Toast.makeText(this@MainActivity, response.message(), Toast.LENGTH_LONG)
                            .show()
                        prgress.visibility = View.GONE
                    }
                }

                override fun onFailure(call: Call<Response>, t: Throwable) {
                    Toast.makeText(this@MainActivity, t.localizedMessage, Toast.LENGTH_LONG).show()
                    prgress.visibility = View.GONE
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