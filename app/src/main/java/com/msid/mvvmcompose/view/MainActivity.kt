package com.msid.mvvmcompose.view

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.msid.mvvmcompose.api.Api
import com.msid.mvvmcompose.ui.theme.MVVMComposeTheme
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import javax.inject.Inject


@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    @Inject
    lateinit var api: Api

    override fun onCreate(savedInstanceState: Bundle?) {


        super.onCreate(savedInstanceState)

        GlobalScope.launch {
            val response  = api.getComments()
            Log.d("CommentsResponse", response.body().toString())
        }
        enableEdgeToEdge()
        setContent {
            MVVMComposeTheme {

            }
        }
    }
}

