package com.example.ass

import io.reactivex.Observable
import retrofit2.http.GET

interface INetworkAPI {

    @GET("test/view.json")
    fun getAllPosts(): Observable<List<Test>>
}