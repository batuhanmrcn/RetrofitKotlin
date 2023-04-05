package com.example.kotlinretrofit.service

import com.example.kotlinretrofit.model.CryptoModel
import retrofit2.Call
import retrofit2.http.GET

interface CryptoAPI {

        //get,post,update,delete

    @GET("atilsamancioglu/K21-JSONDataSet/master/crypto.json")
    fun getData():Call<List<CryptoModel>>

}