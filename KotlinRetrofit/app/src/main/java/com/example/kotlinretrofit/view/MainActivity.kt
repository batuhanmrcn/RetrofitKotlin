package com.example.kotlinretrofit.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.kotlinretrofit.R
import com.example.kotlinretrofit.adapter.FeedRecyclerAdapter
import com.example.kotlinretrofit.databinding.ActivityMainBinding
import com.example.kotlinretrofit.model.CryptoModel
import com.example.kotlinretrofit.service.CryptoAPI
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : AppCompatActivity() {

    private val BASE_URL = "https://raw.githubusercontent.com/"
    private var  cryptoModels: ArrayList<CryptoModel>? = null
    private lateinit var binding : ActivityMainBinding
    private lateinit var adapter : FeedRecyclerAdapter



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)


        adapter = FeedRecyclerAdapter()
        binding.recyclerView.adapter = adapter


        loadData()



    }

    private fun loadData(){
        //retrofit objemizi oluşturuyoruz.
        val retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        val service = retrofit.create(CryptoAPI::class.java)
        val call = service.getData()

        call.enqueue(object : Callback<List<CryptoModel>>{
            override fun onResponse(
                call: Call<List<CryptoModel>>,
                response: Response<List<CryptoModel>>
            ) {

                if (response.isSuccessful){
                    response.body()?.let {
                        cryptoModels = ArrayList(it)
                        adapter.setData(cryptoModels)



                    }
                }




            }

            override fun onFailure(call: Call<List<CryptoModel>>, t: Throwable) {
                t.printStackTrace()
            }

        })

    }
}