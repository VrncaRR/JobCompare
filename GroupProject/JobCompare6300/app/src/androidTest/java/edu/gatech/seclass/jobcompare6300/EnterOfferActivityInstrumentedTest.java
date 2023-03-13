package edu.gatech.seclass.jobcompare6300;

import android.content.Context;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.List;
import java.util.ArrayList;


import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.replaceText;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.isEnabled;
import static androidx.test.espresso.matcher.ViewMatchers.withClassName;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.platform.app.InstrumentationRegistry;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;


@RunWith(AndroidJUnit4.class)
public class EnterOfferActivityInstrumentedTest {

    private DatabaseHelper database;

    @Before
    public void setUp() throws Exception {
        InstrumentationRegistry.getInstrumentation().getTargetContext().deleteDatabase("JobOfferComparison.db");
        database = new DatabaseHelper(InstrumentationRegistry.getInstrumentation().getTargetContext());
    }

    @After
    public void tearDown() throws Exception {
        database.close();
    }

    @Rule
    public ActivityScenarioRule<EnterOffer> activityTestRule = new ActivityScenarioRule<EnterOffer>(EnterOffer.class);


    @Test
    public void verifyEmptyInputsAddAnother() {
        onView(withId(R.id.anotherOfferButton)).perform(click());
        onView(withId(R.id.entryOfferTitle)).check(matches(withText("")));
        onView(withId(R.id.entryOfferCompany)).check(matches(withText("")));
        onView(withId(R.id.entryOfferLocation)).check(matches(withText("")));
        onView(withId(R.id.entryOfferCOL)).check(matches(withText("")));
        onView(withId(R.id.entryOfferSalary)).check(matches(withText("")));
        onView(withId(R.id.entryOfferRSU)).check(matches(withText("")));
        onView(withId(R.id.entryOfferTitle)).check(matches(withText("")));
        onView(withId(R.id.entryOfferRelo)).check(matches(withText("")));
        onView(withId(R.id.entryOfferPCH)).check(matches(withText("")));
    }

    // Verify that screen does not change if user tries to add an offer with blank fields
    @Test
    public void verifyEmptyOfferError() {
        onView(withId(R.id.entryOfferTitle)).perform(replaceText(""));
        onView(withId(R.id.entryOfferCompany)).perform(replaceText(""));
        onView(withId(R.id.entryOfferLocation)).perform(replaceText(""));
        onView(withId(R.id.entryOfferCOL)).perform(replaceText(""));
        onView(withId(R.id.entryOfferSalary)).perform(replaceText(""));
        onView(withId(R.id.entryOfferRSU)).perform(replaceText(""));
        onView(withId(R.id.entryOfferTitle)).perform(replaceText(""));
        onView(withId(R.id.entryOfferRelo)).perform(replaceText(""));
        onView(withId(R.id.entryOfferPCH)).perform(replaceText(""));
        onView(withId(R.id.divider)).check(matches((isDisplayed())));
    }

    // Verify the correct data fields are shown when selecting the "add another job" button
    @Test
    public void verifyOfferDataFieldsShown() {
        onView(withId(R.id.textView2)).check(matches(withText("Enter Job Offer")));
        onView(withId(R.id.textView4)).check(matches(withText("Company")));
        onView(withId(R.id.textView8)).check(matches(withText("Location")));
        onView(withId(R.id.textView9)).check(matches(withText("Cost Of Living")));
    }


    // Verify the correct buttons are shown on the "add a job offer" screen
    @Test
    public void verifyJobOfferBtnsShown() {
        onView(withId(R.id.saveOfferButton)).check(matches(isEnabled()));
        onView(withId(R.id.offerCancelButton)).check(matches(isEnabled()));
        onView(withId(R.id.anotherOfferButton)).check(matches(isEnabled()));
        onView(withId(R.id.OfferMainMenuButton)).check(matches(isEnabled()));
        onView(withId(R.id.compareOfferButton)).check(matches(isEnabled()));
    }

}



