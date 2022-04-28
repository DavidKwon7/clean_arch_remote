package com.example.myapplicationtest11.data.remote.api

import com.example.myapplicationtest11.data.remote.model.User
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Path

interface GithubApi {
    @GET("users/{owner}/repos")
    fun getRepo(@Path("owner") owner: String): Single<List<User>>
}