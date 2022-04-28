package com.example.myapplicationtest11.domain.use_cases

import com.example.myapplicationtest11.domain.repository.GithubRepository

class GetUserRepoUseCase (private val githubRepository: GithubRepository) {
    fun execute(owner: String) =
        githubRepository.getGithub(owner = owner)
}