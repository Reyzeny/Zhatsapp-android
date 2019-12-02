package com.reyzeny.zhatsapp;


import android.content.Intent;

import androidx.test.espresso.matcher.ViewMatchers;
import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.rule.ActivityTestRule;

import com.reyzeny.zhatsapp.Home.HomeActivity;

import org.hamcrest.Matcher;
import org.hamcrest.Matchers;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;

import java.util.ArrayList;
import java.util.Objects;

import kotlin.jvm.JvmField;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.swipeLeft;
import static androidx.test.espresso.action.ViewActions.swipeRight;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDescendantOfA;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static androidx.test.espresso.matcher.ViewMatchers.assertThat;
import static org.hamcrest.core.AllOf.allOf;
import static org.hamcrest.core.IsNull.notNullValue;

@RunWith(AndroidJUnit4.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class MainActivityTest {
    @Rule
    public ActivityTestRule<HomeActivity> homeActivityActivityTestRule = new ActivityTestRule<>(HomeActivity.class, true, true);
    private HomeActivity homeActivity;

    @Before
    public void setUp() {
        homeActivity = homeActivityActivityTestRule.getActivity();
        assertThat(homeActivity, notNullValue());
    }

    @Test
    public void swipePage() {
        onView(withId(R.id.home_viewpager)).check(matches(isDisplayed()));
        onView(withId(R.id.home_viewpager)).perform(swipeLeft());
        onView(withId(R.id.home_viewpager)).perform(swipeRight());
        onView(withId(R.id.home_viewpager)).perform(swipeRight());
    }

    @Test
    public void checkTabLayoutDisplayed() {
        onView(withId(R.id.home_tabs)).perform(click()).check(matches(isDisplayed()));
    }

    @Test
    public void testChatTab() {
        onView(allOf(withText("CHATS"), isDescendantOfA(withId(R.id.home_tabs)))).perform(click()).check(matches(isDisplayed()));
        assertThat(Objects.requireNonNull(homeActivity.getCurrentFragmentTitle()).toString(), Matchers.equalTo("CHATS"));
    }

    @Test
    public void testStatusTab() {
        onView(allOf(withText("STATUS"), isDescendantOfA(withId(R.id.home_tabs)))).perform(click()).check(matches(isDisplayed()));
        assertThat(Objects.requireNonNull(homeActivity.getCurrentFragmentTitle()).toString(), Matchers.equalTo("STATUS"));
    }

    @Test
    public void testCallTab() {
        onView(allOf(withText("CALLS"), isDescendantOfA(withId(R.id.home_tabs)))).perform(click()).check(matches(isDisplayed()));
        assertThat(Objects.requireNonNull(homeActivity.getCurrentFragmentTitle()).toString(), Matchers.equalTo("CALLS"));
    }

}
