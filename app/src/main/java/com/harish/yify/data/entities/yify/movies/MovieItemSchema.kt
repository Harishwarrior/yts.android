package com.harish.yify.data.entities.yify.movies

import com.harish.yify.data.entities.yify.BaseMovie
import com.google.gson.annotations.SerializedName

class MovieItemSchema : BaseMovie() {
    @SerializedName("summary")
    var summary: String? = null
    @SerializedName("synopsis")
    var synopsis: String? = null
    @SerializedName("state")
    var state: String? = null
}