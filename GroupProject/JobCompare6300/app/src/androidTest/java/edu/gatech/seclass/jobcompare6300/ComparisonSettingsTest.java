
package edu.gatech.seclass.jobcompare6300;

import android.content.Context;

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
public class ComparisonSettingsTest {

    @Rule
    public ActivityScenarioRule<ComparisonSettings> activityTestRule = new ActivityScenarioRule<ComparisonSettings>(ComparisonSettings.class);

    // Verify that the default weights are 1
    @Test
    public void testDefaultValues() {

    }

    // Test getSalaryWeight()
    @Test
    public void testGetSalaryWeight() {

    }

    // Test getBonusWeight()
    @Test
    public void testGetBonusWeight() {

    }

    // Test getRSUWeight()
    @Test
    public void testGetRSUWeight() {

    }

    // Test getRelocationStipendWeight()
    @Test
    public void testGetRelocationStipendWeight() {

    }

    // Test getPTOWeight()
    @Test
    public void testGetPTOWeight() {

    }


}