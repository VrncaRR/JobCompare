package edu.gatech.seclass.jobcompare6300;

import android.content.Context;
import android.content.Intent;

import androidx.test.InstrumentationRegistry;
import androidx.test.espresso.intent.rule.IntentsTestRule;
import androidx.test.runner.AndroidJUnit4;

import org.junit.Test;
import org.junit.Rule;

import androidx.test.core.app.ActivityScenario;
import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.closeSoftKeyboard;
import static androidx.test.espresso.action.ViewActions.typeText;
import static androidx.test.espresso.intent.Intents.intended;
import static androidx.test.espresso.intent.matcher.IntentMatchers.hasAction;
import static androidx.test.espresso.intent.matcher.IntentMatchers.hasData;
import static androidx.test.espresso.intent.matcher.IntentMatchers.toPackage;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static org.hamcrest.core.AllOf.allOf;
import static org.junit.Assert.*;


public class ListJobsIntentTest {

//    @Rule
//    public ActivityScenario<ListJobs> rule = new ActivityScenario<>(ListJobs.class);


    // Validate the intent that starts the comparejobs action.
    @Test
    public void testIntentMatches() {

    }

    // Test that the intent was launched
    @Test
    public void testIntentLaunch() {

    }

    // Test the intent result
    @Test
    public void testIntentResult() {

    }
}
