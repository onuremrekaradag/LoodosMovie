package com.kefelon.loodosmovie.ui.moviesearch

import androidx.lifecycle.MutableLiveData
import com.kefelon.loodosmovie.base.BaseViewModel
import com.kefelon.loodosmovie.data.model.MovieModel
import com.kefelon.loodosmovie.data.remote.services.OMDBApiService
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class SearchViewModel @Inject constructor() : BaseViewModel() {


    @Inject
    lateinit var movieService: OMDBApiService

    val movies = MutableLiveData<List<MovieModel>>()

    val showLoading = MutableLiveData<Boolean>()

    override fun start() = Unit

    override fun stop() {
        disposable.dispose()
    }

    fun getMovieList(searchString: String) {
        showLoading.value = true
        val dp = movieService.getMovies(searchQuery = searchString)
            .subscribeOn(Schedulers.newThread())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeOn(Schedulers.io())
            .subscribe { response ->
                if (response.isResponseSuccess == "True")
                    if (response.searchList.isNotEmpty())
                        movies.value = response.searchList
                    else
                        movies.value = emptyList()
                else
                    movies.value = emptyList()
                showLoading.value = false
            }
        disposable.add(dp);
    }
}

