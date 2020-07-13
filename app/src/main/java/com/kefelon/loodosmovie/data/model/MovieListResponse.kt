package com.kefelon.loodosmovie.data.model

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class MovieListResponse(
    @SerializedName("totalResults")
    val totalResults: Int,

    @SerializedName("Response")
    val isResponseSuccess: String,

    @SerializedName("Search")
    val searchList: List<MovieModel>
)