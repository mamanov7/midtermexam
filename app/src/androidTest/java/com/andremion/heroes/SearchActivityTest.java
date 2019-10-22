/*
 * Copyright (c) 2017. André Mion
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.andremion.heroes;

import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import com.andremion.heroes.ui.search.view.SearchActivity;
import com.andremion.heroes.util.DataConstants;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.closeSoftKeyboard;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isDescendantOfA;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static com.andremion.heroes.actions.CustomActions.typeQuery;
import static org.hamcrest.Matchers.allOf;
import static org.hamcrest.Matchers.is;

@RunWith(AndroidJUnit4.class)
public class SearchActivityTest {

    @Rule
    public final ActivityTestRule mActivityRule = new ActivityTestRule<>(SearchActivity.class);

    @Test
    public void testPerformSearch() {
        // Type the text in the search field
        onView(withId(R.id.search)).perform(typeQuery(DataConstants.CHARACTER_TO_FIND), closeSoftKeyboard());
        // Check if the list is displayed
        onView(withId(R.id.recycler)).check(matches(isDisplayed()));
        // Check if there is one View item with expected value
        //noinspection unchecked
        onView(allOf(isDescendantOfA(withId(R.id.recycler)), withText(is(DataConstants.CHARACTER_TO_FIND))));
    }
}