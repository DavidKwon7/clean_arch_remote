package com.example.myapplicationtest11.domain.repository

import com.example.myapplicationtest11.data.remote.model.User
import io.reactivex.Single

interface GithubRepository {
    fun getGithub(owner: String) : Single<List<User>>
}