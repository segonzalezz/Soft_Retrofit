package com.segonzalezz.soft_retrofit

import android.app.Activity
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.segonzalezz.soft_retrofit.model.Post
import com.segonzalezz.soft_retrofit.network.RetrofitInstance
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : Activity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d("MY_APP_LOG", "onCreate ejecutado correctamente")

        // Llamada a la API para obtener los posts
        RetrofitInstance.api.getPosts().enqueue(object : Callback<List<Post>> {
            override fun onResponse(call: Call<List<Post>>, response: Response<List<Post>>) {
                if (response.isSuccessful) {
                    response.body()?.forEach { post ->
                        Log.d("MY_APP_LOG", "Post ID: ${post.id}, Title: ${post.title}")
                    }
                } else {
                    Log.e("MY_APP_LOG", "Error en la respuesta: ${response.code()}")
                }
            }

            override fun onFailure(call: Call<List<Post>>, t: Throwable) {
                Log.e("MY_APP_LOG", "Error en la solicitud: ${t.message}")
            }
        })
    }
}

