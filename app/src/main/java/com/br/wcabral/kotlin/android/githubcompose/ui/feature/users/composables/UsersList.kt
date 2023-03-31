package com.br.wcabral.kotlin.android.githubcompose.ui.feature.users.composables

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.tooling.preview.Preview
import com.br.wcabral.kotlin.android.githubcompose.data.model.User
import com.br.wcabral.kotlin.android.githubcompose.data.model.buildUserPreview

@Composable
fun UsersList(
    users: List<User>,
    onItemClick: (User) -> Unit
) {

    LazyColumn(modifier = Modifier
        .fillMaxSize()
        .testTag("githublist")) {
        itemsIndexed(users) { index, user ->
            UsersListItem(user = user, index, onItemClick = onItemClick)
        }
    }

}

@Preview(showBackground = true)
@Composable
fun UsersListPreview() {
    val users = List(3) { buildUserPreview() }
    UsersList(users = users) {}
}
