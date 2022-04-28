package com.example.myapplicationtest11.presentation.main

import android.util.Log
import android.widget.Toast
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.myapplicationtest11.data.remote.model.User
import com.example.myapplicationtest11.domain.use_cases.GetUserRepoUseCase
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.rxkotlin.addTo
import io.reactivex.schedulers.Schedulers
import timber.log.Timber

class MainViewModel (private val getUserRepoUseCase: GetUserRepoUseCase) : ViewModel() {
    private val _eventUserRepo = MutableLiveData<List<User>>()
    val eventUserRepo : LiveData<List<User>> get() = _eventUserRepo

    private val compositeDisposable = CompositeDisposable()

    fun getUserRepo(owner: String) {
        getUserRepoUseCase.execute(owner = owner)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({userRepo ->
                if (userRepo.isEmpty()) {
                    Timber.e("error")
                } else {
                    _eventUserRepo.value = userRepo as List<User> // 맞나?
                }
            }, {
                Timber.e("getUserRepo: $it")
            }
        ).addTo(compositeDisposable)
    }
}