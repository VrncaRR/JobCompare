package edu.gatech.seclass.jobcompare6300;

import android.content.Context;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.replaceText;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isEnabled;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.ext.junit.runners.AndroidJUnit4;



import org.junit.Rule;
import org.junit.Test;
import static org.junit.Assert.assertEquals;
@RunWith(AndroidJUnit4.class)
public class ListJobsTest {

    @Rule
    public ActivityScenarioRule<EnterOffer> activityTestRule = new ActivityScenarioRule<EnterOffer>(EnterOffer.class);

    // Verify that the edit text fields used in the enteroffer screen are blank after choosing "add another offer"
    @Test
    public void verifyEmptyInputs() {
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

}

