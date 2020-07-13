package com.kefelon.loodosmovie.ui.moviesearch

import com.kefelon.loodosmovie.data.model.MovieModel

interface SearchNavigator {

    fun onSearch()

    fun goDetail(moview: MovieModel, position: Int)
}