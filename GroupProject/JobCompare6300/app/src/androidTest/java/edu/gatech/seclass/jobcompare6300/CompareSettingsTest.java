
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
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withClassName;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;

import androidx.test.espresso.ViewAction;
import androidx.test.espresso.action.ViewActions;
import androidx.test.espresso.matcher.ViewMatchers;
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
                onView(withId(R.id.entrySalaryWeight)).check(matches(withText("1")));
                onView(withId(R.id.entryBonusWeight)).check(matches(withText("1")));
                onView(withId(R.id.entryRSUWeight)).check(matches(withText("1")));
                onView(withId(R.id.entryReloWeight)).check(matches(withText("1")));
                onView(withId(R.id.entryPCHWeight)).check(matches(withText("1")));
        }

        // Test that correct data fields are shown
        @Test
        public void testInputFieldsShown() {
                onView(withText("Salary")).check(matches(isDisplayed()));
                onView(withText("Bonus")).check(matches(isDisplayed()));
                onView(withText("Restricted Stock Units")).check(matches(isDisplayed()));
                onView(withText("Relocation Stipend")).check(matches(isDisplayed()));
                onView(withText("Personal Choice Holidays")).check(matches(isDisplayed()));
        }

        // Test that correct buttons are shown
        @Test
        public void testBtnsShown() {
                onView(withText("Save")).check(matches(isDisplayed()));
                onView(withText("Cancel")).check(matches(isDisplayed()));
        }

        // Test that the db is updated if the user modifies weights and clicks save
        @Test
        public void testDBUpdateOnModify() {
                //Enter 2 for all settings
                onView(ViewMatchers.withId(R.id.entrySalaryWeight)).perform(ViewActions.typeText("2"));
                onView(ViewMatchers.withId(R.id.entryBonusWeight)).check(matches(withText("2")));
                onView(ViewMatchers.withId(R.id.entryRSUWeight)).check(matches(withText("2")));
                onView(ViewMatchers.withId(R.id.entryReloWeight)).check(matches(withText("2")));
                onView(ViewMatchers.withId(R.id.entryPCHWeight)).check(matches(withText("2")));
                onView(withId(R.id.saveSettingsButton)).perform(ViewActions.click());
/*
                DatabaseHelper dbHelper = new DatabaseHelper(ComparisonSettings.this);
                //get current comparison setting, if no, get default comparison setting
                ComparisonSettings settings = dbHelper.getCurrentSetting();

                String salaryW = Integer.toString(settings.getSalaryWeight());
                String bonusW = Integer.toString(settings.getSalaryWeight());
                String rSUW = Integer.toString(settings.getSalaryWeight());
                String reloW = Integer.toString(settings.getSalaryWeight());
                String pCHW = Integer.toString(settings.getSalaryWeight());

                onView(withId(R.id.entrySalaryWeight)).check(matches(withText(salaryW)));
                onView(withId(R.id.entryBonusWeight)).check(matches(withText(bonusW)));
                onView(withId(R.id.entryRSUWeight)).check(matches(withText(rSUW)));
                onView(withId(R.id.entryReloWeight)).check(matches(withText(reloW)));
                onView(withId(R.id.entryPCHWeight)).check(matches(withText(pCHW)));
*/
        }

        // Test that the db doesn't update if the user modifies weights and hits cancel
        @Test
        public void testDBUpdateOnCancel() {

        }

        // Test that user-inputted values don't persist in the text fields if the user hits the cancel button
        @Test
        public void testDataFieldsOnCancel() {
                //Enter 2 for all settings
                onView(ViewMatchers.withId(R.id.entrySalaryWeight)).perform(ViewActions.typeText("2"));
                onView(ViewMatchers.withId(R.id.entryBonusWeight)).perform(ViewActions.typeText("2"));
                onView(ViewMatchers.withId(R.id.entryRSUWeight)).perform(ViewActions.typeText("2"));
                onView(ViewMatchers.withId(R.id.entryReloWeight)).perform(ViewActions.typeText("2"));
                onView(ViewMatchers.withId(R.id.entryPCHWeight)).perform(ViewActions.typeText("2"));
                //Click Cancel
                onView(withId(R.id.SettingsCancelButton)).perform(ViewActions.click());
                //Check that weights return to 1
                onView(withId(R.id.entrySalaryWeight)).check(matches(withText("1")));
                onView(withId(R.id.entryBonusWeight)).check(matches(withText("1")));
                onView(withId(R.id.entryRSUWeight)).check(matches(withText("1")));
                onView(withId(R.id.entryReloWeight)).check(matches(withText("1")));
                onView(withId(R.id.entryPCHWeight)).check(matches(withText("1")));



        }

        // Test that new values are shown if the user inputs values and clicks save
        @Test
        public void testDataFieldsOnSave() {

        }

}


















