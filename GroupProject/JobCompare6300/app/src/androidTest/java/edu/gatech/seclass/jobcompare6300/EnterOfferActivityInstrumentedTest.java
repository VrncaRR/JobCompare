package edu.gatech.seclass.jobcompare6300;

import android.content.Context;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.replaceText;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.platform.app.InstrumentationRegistry;

import static org.junit.Assert.assertEquals;

@RunWith(AndroidJUnit4.class)
public class EnterOfferActivityInstrumentedTest {

    @Rule
    public ActivityScenarioRule<EnterOffer> activityTestRule = new ActivityScenarioRule<EnterOffer>(EnterOffer.class);

    // Verify that the edit text fields used in the enteroffer screen are blank after choosing "add another offer"
    @Test
    public void verifyEmptyInputs() {
        //specifies the button with id = R.id.anotherOfferButton
        onView(withId(R.id.anotherOfferButton)).perform(click());
        //specifies the edittext with id = R.id.entryOfferTitle
        onView(withId(R.id.entryOfferTitle)).check(matches(withText("")));
    }

    // Verify that error message is set if an offer title of length 0 is attempted.
    @Test
    public void verifyEmptyTitleError() {
        onView(withId(R.id.entryOfferTitle)).perform(replaceText(""));
        onView(withId(R.id.saveOfferButton)).perform(click());
        onView(withId(R.id.entryOfferTitle)).check(matches(withText("Invalid Entry")));
    }

    @Test
    public void verify() {
        onView(withId(R.id.entryOfferTitle)).perform(replaceText(""));
        onView(withId(R.id.saveOfferButton)).perform(click());
        onView(withId(R.id.entryOfferTitle)).check(matches(withText("Invalid Entry")));
    }
}

