package com.br.wcabral.kotlin.android.githubcompose.ui.feature.main

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.unit.dp
import com.br.wcabral.kotlin.android.githubcompose.ui.navigation.AppNavigation
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
                    SimpleAsyncApp()
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
        }, modifier = Modifier.testTag("downbutton")) {
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

            Column(modifier = Modifier.padding(16.dp).testTag("column")) {

                Text(text = "I am number $it", modifier = Modifier.testTag("title"))
                Divider()
                Text(text = "Desc $it", modifier = Modifier.testTag("desc"))
                Divider()
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
