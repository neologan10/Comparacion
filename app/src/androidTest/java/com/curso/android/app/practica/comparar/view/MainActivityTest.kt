package com.curso.android.app.practica.comparar.view

import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.espresso.Espresso
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.ext.junit.rules.ActivityScenarioRule
import com.curso.android.app.practica.comparar.R
import org.junit.Assert.*

import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class MainActivityTest {

    @get: Rule
    var rule: ActivityScenarioRule<*> = ActivityScenarioRule(MainActivity::class.java)

    @Before
    fun setUp() {
    }

    @After
    fun tearDown() {
    }

    @Test
    fun mainActivity_textEquals() {
        Espresso.onView(
            ViewMatchers.withId(R.id.text1)
        ).perform(
            ViewActions.typeText("Android 2023")
        )

        Espresso.onView(
            ViewMatchers.withId(R.id.text2)
        ).perform(
            ViewActions.typeText("Android 2023")
        )

        Espresso.closeSoftKeyboard()

        Espresso.onView(
            ViewMatchers.withId(R.id.compararButton)
        ).perform(
            ViewActions.click()
        )

        Espresso.onView(
            ViewMatchers.withId(R.id.result)
        ).check(
            ViewAssertions.matches(
                ViewMatchers.withText("Las frases son iguales")
            )
        )
    }

    @Test
    fun mainActivity_textDifferent() {
        Espresso.onView(
            ViewMatchers.withId(R.id.text1)
        ).perform(
            ViewActions.typeText("Curso Android 2023")
        )

        Espresso.onView(
            ViewMatchers.withId(R.id.text2)
        ).perform(
            ViewActions.typeText("Android 2023")
        )

        Espresso.closeSoftKeyboard()

        Espresso.onView(
            ViewMatchers.withId(R.id.compararButton)
        ).perform(
            ViewActions.click()
        )

        Espresso.onView(
            ViewMatchers.withId(R.id.result)
        ).check(
            ViewAssertions.matches(
                ViewMatchers.withText("Las frases son distintas")
            )
        )
    }
}