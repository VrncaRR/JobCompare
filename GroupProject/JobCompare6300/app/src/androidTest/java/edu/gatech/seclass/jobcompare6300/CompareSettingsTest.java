
package edu.gatech.seclass.jobcompare6300;

import android.content.Context;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.replaceText;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.withClassName;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.platform.app.InstrumentationRegistry;

import static org.junit.Assert.assertEquals;

@RunWith(AndroidJUnit4.class)

public class CompareSettingsTest {

        private DatabaseHelper database;

        @Before
        public void setUp() throws Exception {
                InstrumentationRegistry.getInstrumentation().getTargetContext().deleteDatabase("JobOfferComparison.db");
                database = new DatabaseHelper(InstrumentationRegistry.getInstrumentation().getTargetContext());
        }

        @Rule
        public ActivityScenarioRule<CompareSettings> activityTestRule = new ActivityScenarioRule<CompareSettings>(CompareSettings.class);

        // Test that default weights appear as 1
        @Test
        public void testDefaultWeightsShown() {

        }

        // Test that correct data fields are shown
        @Test
        public void testInputFieldsShown() {

        }

        // Test that correct buttons are shown
        @Test
        public void testBtnsShown() {

        }

        // Test that the db is updated if the user modifies weights and clicks save
        @Test
        public void testDBUpdateOnModify() {

        }

        // Test that the db doesn't update if the user modifies weights and hits cancel
        @Test
        public void testDBUpdateOnCancel() {

        }

        // Test that user-inputted values don't persist in the text fields if the user hits the cancel button
        @Test
        public void testDataFieldsOnCancel() {

        }

        // Test that new values are shown if the user inputs values and clicks save
        @Test
        public void testDataFieldsOnSave() {

        }

}


















