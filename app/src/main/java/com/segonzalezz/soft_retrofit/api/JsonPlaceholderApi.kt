package com.segonzalezz.soft_retrofit.api

import com.segonzalezz.soft_retrofit.model.Post
import retrofit2.http.GET
import retrofit2.Call

interface JsonPlaceholderApi {
    @GET("posts")
    fun getPosts(): Call<List<Post>>
}