package com.example.myapplicationtest11.data.remote

import com.example.myapplicationtest11.data.remote.model.User
import com.example.myapplicationtest11.data.remote.source.GithubSource
import com.example.myapplicationtest11.domain.repository.GithubRepository
import io.reactivex.Single

class GithubRepositoryImpl(private val githubSource: GithubSource) : GithubRepository {
    override fun getGithub(owner: String): Single<List<User>> =
        githubSource.getGithub(owner)
}