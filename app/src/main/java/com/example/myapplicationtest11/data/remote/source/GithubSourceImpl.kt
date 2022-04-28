package com.example.myapplicationtest11.data.remote.source

import com.example.myapplicationtest11.data.remote.api.GithubApi
import com.example.myapplicationtest11.data.remote.model.User
import io.reactivex.Single

class GithubSourceImpl (private val githubApi: GithubApi) : GithubSource {
    override fun getGithub(owner: String): Single<List<User>> =
        githubApi.getRepo(owner = owner)
}