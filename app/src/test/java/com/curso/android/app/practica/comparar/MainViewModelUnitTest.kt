package com.curso.android.app.practica.comparar

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.curso.android.app.practica.comparar.view.MainViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.test.*
import org.junit.After
import org.junit.Assert.*
import org.junit.Before
import org.junit.Rule
import org.junit.Test

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
@OptIn(kotlinx.coroutines.ExperimentalCoroutinesApi::class)
class MainViewModelUnitTest {

    private lateinit var viewModel: MainViewModel

    @get:Rule
    val instantTaskRule = InstantTaskExecutorRule()
    private val dispatcher = StandardTestDispatcher()

    @Before
    fun setup() {
        Dispatchers.setMain(dispatcher)
        viewModel = MainViewModel()
    }

    @After
    fun tearDown() {
        Dispatchers.resetMain()
    }


    @Test
    fun mainViewModel_TestDifferents1() = runTest {
        val text1 = "curso de android"
        val text2 = "Curso de Android"
        launch {
            viewModel.compararTexts(text1, text2)
        }
        advanceUntilIdle()
        val value = viewModel.comparar.value?.result
        assertEquals("Las frases son distintas", value)
    }

    @Test
    fun mainViewModel_TestDifferents2() = runTest {
        val text1 = "curso de android"
        val text2 = "curso de androides"
        launch {
            viewModel.compararTexts(text1, text2)
        }
        advanceUntilIdle()
        val value = viewModel.comparar.value?.result
        assertEquals("Las frases son distintas", value)
    }

    @Test
    fun mainViewModel_TestEquals() = runTest {
        val text1 = "Curso de Android 2023"
        val text2 = "Curso de Android 2023"
        launch {
            viewModel.compararTexts(text1, text2)
        }
        advanceUntilIdle()
        val value = viewModel.comparar.value?.result
        assertEquals("Las frases son iguales", value)
    }

}