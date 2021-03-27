package com.harish.yify.data.entities.yify.movie

import com.google.gson.annotations.SerializedName

class MovieMiddleSchema {
    @SerializedName("movie")
    var movie: MovieSchema? = null
}