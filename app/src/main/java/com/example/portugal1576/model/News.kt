package com.example.portugal1576.model

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class News(
    @Json(name = "click_url")
    val click_url: String?,
    @Json(name = "img")
    val img: String?,
    @Json(name = "time")
    val time: String?,
    @Json(name = "title")
    val title: String?,
    @Json(name = "top")
    val top: String?,
    @Json(name = "type")
    val type: String?,

    var viewType: Int = 1

)