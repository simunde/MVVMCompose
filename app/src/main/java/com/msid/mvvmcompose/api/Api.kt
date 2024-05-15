package com.msid.mvvmcompose.api

import com.msid.mvvmcompose.model.Comments
import com.msid.mvvmcompose.model.CommentsItem
import retrofit2.Response
import retrofit2.http.GET

interface Api {

    @GET("/comments")
    suspend fun getComments():  Response<List<CommentsItem>>
}