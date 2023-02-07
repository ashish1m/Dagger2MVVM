package com.example.dagger2mvvm.retrofit

import com.example.dagger2mvvm.model.Product
import retrofit2.Response
import retrofit2.http.GET

interface FakerAPI {

    companion object {
        const val products = "/products"
    }

    @GET(products)
    suspend fun getProducts(): Response<List<Product>>
}