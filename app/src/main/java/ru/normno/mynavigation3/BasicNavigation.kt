package ru.normno.mynavigation3

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.lifecycle.viewmodel.navigation3.rememberViewModelStoreNavEntryDecorator
import androidx.navigation3.runtime.entry
import androidx.navigation3.runtime.entryProvider
import androidx.navigation3.runtime.rememberSavedStateNavEntryDecorator
import androidx.navigation3.ui.NavDisplay
import androidx.navigation3.ui.rememberSceneSetupNavEntryDecorator

@Composable
fun BasicNavigation() {
//    val backStack = remember {
//        mutableStateListOf<Screen>(Screen.Home)
//    }
//    val backStack = rememberNavBackStack<Screen>(Screen.Home)

    val viewModel = viewModel<MyViewModel>()
    val backStack = viewModel.backStack
    NavDisplay(
        backStack = backStack,
        onBack = {
            backStack.removeLastOrNull()
        },
        entryDecorators = listOf(
            rememberSceneSetupNavEntryDecorator(),
            rememberSavedStateNavEntryDecorator(),
            rememberViewModelStoreNavEntryDecorator(),
        ),
        entryProvider =
            entryProvider {
                entry<Screen.Home> {
                    HomeScreen(
                        onBackStack = {
                            backStack.add(Screen.Details(id = "123"))
                        }
                    )
                }
                entry<Screen.Details> { details ->
                    val viewModel = viewModel<DetailsViewModel>()
                    DetailScreen(
                        id = details.id,
                    )
                }
            }
//        { key ->
//            when (key) {
//                is Screen.Details -> NavEntry(key) {
//                    DetailScreen(
//                        id = key.id,
//                    )
//                }
//
//                Screen.Home -> NavEntry(key) {
//                    HomeScreen(
//                        onBackStack = {
//                            backStack.add(key)
//                        }
//                    )
//                }
//            }
//        }
    )
}

@Composable
fun DetailScreen(
    id: String,
) {
    Box(
        modifier = Modifier
            .background(MaterialTheme.colorScheme.tertiaryContainer)
            .fillMaxSize(),
        contentAlignment = Alignment.Center,
    ) {
        Text(
            text = "Details $id"
        )
    }
}

@Composable
fun HomeScreen(
    onBackStack: () -> Unit,
) {
    Box(
        modifier = Modifier
            .background(MaterialTheme.colorScheme.secondaryContainer)
            .fillMaxSize(),
        contentAlignment = Alignment.Center,
    ) {
        Button(
            onClick = onBackStack,
        ) {
            Text(
                text = "Go to Details"
            )
        }
    }
}