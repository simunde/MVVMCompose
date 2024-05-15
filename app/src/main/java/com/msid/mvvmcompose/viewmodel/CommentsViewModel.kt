package com.msid.mvvmcompose.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.msid.mvvmcompose.model.CommentsItem
import com.msid.mvvmcompose.repository.CommentsRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CommentsViewModel @Inject constructor(private val repository: CommentsRepository): ViewModel(){


    val comments: StateFlow<List<CommentsItem>>
        get() = repository.comments

    init {
        viewModelScope.launch {
            val comments = repository.getComments()
        }

    }

}