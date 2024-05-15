package com.msid.mvvmcompose.repository

import androidx.compose.runtime.MutableState
import com.msid.mvvmcompose.api.Api
import com.msid.mvvmcompose.model.Comments
import com.msid.mvvmcompose.model.CommentsItem
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import javax.inject.Inject

class CommentsRepository @Inject constructor(private val api: Api) {

    private val _comments = MutableStateFlow<List<CommentsItem>>(emptyList())
    val comments : StateFlow<List<CommentsItem>>
        get()= _comments

    suspend fun getComments(){
        val response = api.getComments()
        if (response.isSuccessful){
            _comments.emit(response.body()!!)
        }
    }
}