package com.turkoglu.themovie.data.remote.dto

import com.google.gson.annotations.SerializedName

data class PopularResponse(
    val page: Int, // 1
    val results: List<Result>,
    @SerializedName("total_pages")
    val totalPages: Int, // 982
    @SerializedName("total_results")
    val totalResults: Int // 19629
)