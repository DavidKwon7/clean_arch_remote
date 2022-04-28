package com.example.myapplicationtest11.data.remote.source

import com.example.myapplicationtest11.data.remote.model.User
import io.reactivex.Single

interface GithubSource {
    fun getGithub(owner: String): Single<List<User>>
}