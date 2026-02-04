package com.example.core.navigation

import androidx.navigation3.runtime.NavKey

/**
 * Обрабатывает события навигации (вперед и назад), обновляя состояние навигации.
 *
 * @param state — состояние навигации, которое будет обновляться в ответ на события.
 */
class Navigator(val state: NavigationState) {

    /**
     * Перейти к ключу навигации (NavKey).
     *
     * @param key — ключ навигации, по которому нужно перейти.
     */
    fun navigate(key: NavKey) {
        when (key) {
            state.currentTopLevelKey -> clearSubStack() // Очистить подстек, если это текущий верхний уровень
            in state.topLevelKeys -> goToTopLevel(key) // Перейти на другой верхний уровень
            else -> goToKey(key) // Перейти к обычному экрану
        }
    }

    /**
     * Вернуться к предыдущему ключу навигации.
     */
    fun goBack() {
        when (state.currentKey) {
            state.startKey -> error("You cannot go back from the start route")
            state.currentTopLevelKey -> {
                // Мы находимся в корне текущего подстека, возвращаемся к предыдущему
                // стеку верхнего уровня.
                state.topLevelStack.removeLastOrNull()
            }
            else -> state.currentSubStack.removeLastOrNull()
        }
    }

    /**
     * Перейти к ключу, не являющемуся верхним уровнем.
     */
    private fun goToKey(key: NavKey) {
        state.currentSubStack.apply {
            // Удаляем ключ, если он уже есть в стеке, чтобы добавить его в самый конец.
            remove(key)
            add(key)
        }
    }

    /**
     * Перейти к стеку верхнего уровня.
     */
    private fun goToTopLevel(key: NavKey) {
        state.topLevelStack.apply {
            if (key == state.startKey) {
                // Это начальный ключ. Очищаем стек, чтобы он стал единственным элементом.
                clear()
            } else {
                // Удаляем ключ, если он уже есть в стеке, чтобы добавить его в конец.
                remove(key)
            }
            add(key)
        }
    }

    /**
     * Очистка всех элементов в текущем подстеке, кроме корневого.
     */
    private fun clearSubStack() {
        state.currentSubStack.run {
            if (size > 1) subList(1, size).clear()
        }
    }
}
