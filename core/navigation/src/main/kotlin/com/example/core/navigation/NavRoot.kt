package com.example.core.navigation

import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.slideInHorizontally
import androidx.compose.animation.slideOutHorizontally
import androidx.compose.animation.togetherWith
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.navigation3.runtime.entryProvider
import androidx.navigation3.ui.NavDisplay
import com.example.featuredetail.impl.presentation.presentation.AddTaskScreen
import com.example.featuredetail.impl.presentation.presentation.TaskScreen
import com.example.featureone.impl.presentation.TaskListScreen
import com.example.featuretwo.impl.presentation.SelectColorScreen

@Composable
fun NavRoot(
    modifier: Modifier = Modifier
) {
    val navigationState = rememberNavigationState(
        startRoute = Route.TaskList,
        topLevelRoutes = topLevelNavItems.keys
    )
    val navigator = remember {
        Navigator(navigationState)
    }

    Scaffold(
        bottomBar = {
            NavBottomBar(
                selectedKey = navigationState.topLevelRoute,
                onSelectKey = {
                    navigator.navigate(it)
                }
            )
        }
    ) { padding ->
        val duration = 1000
        NavDisplay(
            modifier = modifier.fillMaxSize().padding(padding),
            onBack = navigator::goBack,
            entries = navigationState.toEntries(
                entryProvider {
                    entry<Route.TaskDetails> { key ->
                        TaskScreen(
                            id = key.id,
                            onButtonBackClick = { navigator.goBack() },
                        )
                    }

                    entry<Route.AddTask> {
                        AddTaskScreen(
                            onBack = { navigator.goBack() },
                        )
                    }

                    entry<Route.TaskList> {
                        TaskListScreen(
                            onItemClick = { navigator.navigate(Route.TaskDetails(it)) },
                            onAddTaskClick = { navigator.navigate(Route.AddTask) },
                        )
                    }

                    entry<Route.SelectColor> {
                        SelectColorScreen()
                    }
                }
            ),
            transitionSpec = {
                slideInHorizontally(
                    initialOffsetX = { it },
                    animationSpec = tween(duration)
                ) togetherWith slideOutHorizontally(
                    targetOffsetX = { -it / 3 },
                    animationSpec = tween(duration)
                ) + fadeOut(animationSpec = tween(duration))
            },
            popTransitionSpec = {
                slideInHorizontally(
                    initialOffsetX = { -it / 3 },
                    animationSpec = tween(duration)
                ) + fadeIn(animationSpec = tween(duration)) togetherWith slideOutHorizontally(
                    targetOffsetX = { it },
                    animationSpec = tween(duration)
                )
            },
            predictivePopTransitionSpec = {
                slideInHorizontally(
                    initialOffsetX = { -it / 3 },
                    animationSpec = tween(duration)
                ) + fadeIn(animationSpec = tween(duration)) togetherWith slideOutHorizontally(
                    targetOffsetX = { it },
                    animationSpec = tween(duration)
                )
            }
        )
    }
}
