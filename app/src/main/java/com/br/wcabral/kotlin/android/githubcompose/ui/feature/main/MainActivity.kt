package com.br.wcabral.kotlin.android.githubcompose.ui.feature.main

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.unit.dp
import com.br.wcabral.kotlin.android.githubcompose.ui.theme.GithubComposeTheme
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            GithubComposeTheme {
                Surface(color = MaterialTheme.colors.background) {
                    SimpleApp()
                }
            }
        }
    }
}


@Composable
fun SimpleApp() {


    Row(
        horizontalArrangement = Arrangement.Center, modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight(),
        verticalAlignment = Alignment.CenterVertically
    ) {

        val counter = remember {
            mutableStateOf(1)
        }


        Button(onClick = {

            counter.value--
        }) {
            Text(text = "Down")
        }


        Spacer(modifier = Modifier.width(36.dp))

        Text(text = counter.value.toString(), modifier = Modifier.testTag("Content"))


        Spacer(modifier = Modifier.width(36.dp))


        Button(onClick = {
            counter.value++
        }) {
            Text(text = "Up")
        }
    }

}



@Composable
fun SimpleListApp() {


    val list = (0..30).toList()

    LazyColumn(modifier = Modifier.testTag("mylist")) {

        items(list) {

            Row (modifier = Modifier.padding(16.dp)){
                    Text(text = "I am number ")
                    Text(text =  it.toString() )
            }
        }
    }

}

@Composable
fun SimpleAsyncApp() {
    val coroutineScope = rememberCoroutineScope()


    Row(
        horizontalArrangement = Arrangement.Center, modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight(),
        verticalAlignment = Alignment.CenterVertically
    ) {

        val counter = remember {
            mutableStateOf(1)
        }


        Button(onClick = {

            coroutineScope.launch {
                withContext(Dispatchers.IO) {
                    delay(1000)
                }
                counter.value--
            }
        }) {
            Text(text = "Down")
        }


        Spacer(modifier = Modifier.width(36.dp))

        Text(text = counter.value.toString(), modifier = Modifier.testTag("Content"))


        Spacer(modifier = Modifier.width(36.dp))


        Button(onClick = {
            coroutineScope.launch {
                withContext(Dispatchers.IO) {
                    delay(1000)
                }
                counter.value++
            }
        }) {
            Text(text = "Up")
        }
    }

}
