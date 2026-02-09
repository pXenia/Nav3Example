package com.example.core.navigation

import androidx.compose.animation.ContentTransform
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
import androidx.compose.ui.unit.IntOffset
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
            if (navigationState.shouldShowBottomBar) {
                NavBottomBar(
                    selectedKey = navigationState.topLevelRoute,
                    onSelectKey = {
                        navigator.navigate(it)
                    }
                )
            }
        }
    ) { padding ->
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

                    entry<Route.SelectColor> { key ->
                        SelectColorScreen(
                            stackSize = navigator.getCurrentStackSize(),
                            onBack = { navigator.goBack() },
                            addNewScreen = { navigator.navigate(Route.SelectColor(key.id + 1)) },
                            onResetToRoot = {
                                navigator.popUpTo(
                                    route = navigationState.topLevelRoute,
                                    inclusive = false
                                )
                            }
                        )
                    }
                }
            ),
            transitionSpec = { NavigationAnimations.defaultTransitionSpec() },
            popTransitionSpec = { NavigationAnimations.defaultPopTransitionSpec() },
            predictivePopTransitionSpec = { NavigationAnimations.defaultPopTransitionSpec() }
        )
    }
}

object NavigationAnimations {
    const val DURATION_MS = 1000
    const val SLIDE_OUT = 3

    fun slideInSpec() = tween<IntOffset>(DURATION_MS)
    fun fadeSpec() = tween<Float>(DURATION_MS)

    fun defaultTransitionSpec(): ContentTransform {
        return slideInHorizontally(
            initialOffsetX = { it },
            animationSpec = slideInSpec()
        ) togetherWith slideOutHorizontally(
            targetOffsetX = { -it / SLIDE_OUT},
            animationSpec = slideInSpec()
        ) + fadeOut(animationSpec = fadeSpec())
    }

    fun defaultPopTransitionSpec(): ContentTransform {
        return slideInHorizontally(
            initialOffsetX = { -it / SLIDE_OUT },
            animationSpec = slideInSpec()
        ) + fadeIn(animationSpec = fadeSpec()) togetherWith slideOutHorizontally(
            targetOffsetX = { it },
            animationSpec = slideInSpec()
        )
    }
}
