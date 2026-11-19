package com.example.ladymobile.data.api

import com.example.ladymobile.data.model.PicsumPhotoModel
import retrofit2.http.GET
import retrofit2.http.Query

interface PicsumApiService {
    @GET("v2/list")
    suspend fun getPhotos(
        @Query("page") page: Int = 1,
        @Query("limit") limit: Int = 30
    ): List<PicsumPhotoModel>
}
