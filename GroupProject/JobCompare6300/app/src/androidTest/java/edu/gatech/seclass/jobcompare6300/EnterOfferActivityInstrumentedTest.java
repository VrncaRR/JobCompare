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
public class EnterOfferActivityInstrumentedTest {

    @Rule
    public ActivityScenarioRule<EnterOffer> activityTestRule = new ActivityScenarioRule<EnterOffer>(EnterOffer.class);

    // Verify that data entry fields are reset to be blank after 1) a job offer is added and
    // 2) the user chooses "add another offer"
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

    // Verify that error message appears if the user tries to add a job offer with any empty fields.
    @Test
    public void verifyEmptyOfferError() {
        onView(withId(R.id.entryOfferTitle)).perform(replaceText(""));
        onView(withId(R.id.saveOfferButton)).perform(click());
        onView(withId(R.id.entryOfferTitle)).check(matches(withText("Invalid Entry")));
    }

    // erify that error message appears if the user tries to add or edit a current job with any empty fields.
    @Test
    public void verifyEmptyCurJobError() {
        onView(withId(R.id.entryOfferTitle)).perform(replaceText(""));
        onView(withId(R.id.saveOfferButton)).perform(click());
        onView(withId(R.id.entryOfferTitle)).check(matches(withText("Invalid Entry")));
    }

    // Verify the correct data fields are shown when selecting the "add another job" button
    @Test
    public void verifyOfferDataFieldsShown() {

    }

    // Verify the correct data fields are shown when selecting the "add/edit a current job" button
    @Test
    public void verifyCurJobDataFieldsShown() {

    }

    // Verify that entering details of a current job (for the first time) and hitting the cancel button
        // does not result in the details persisting in the text fields.
    @Test
    public void verifyCurJobClearDataOnCancel() {

    }

    // Verify that entering details of a job offer and hitting the cancel button
    // does not result in the details persisting in the text fields.
    @Test
    public void verifyOfferClearDataOnCancel() {

    }

    // Verify that adding a job results in that job being present in the db
    @Test
    public void verifyAddCurJobToDatabase() {

    }

    // Verify that adding a job offer results in that job being present in the db
    @Test
    public void verifyAddOfferToDatabase() {

    }

    // Verify the correct buttons are shown on the "add a job offer" screen
    @Test
    public void verifyJobOfferBtnsShown() {

    }

    // Verify the correct buttons are shown on the "add/edit current job" screen
    @Test
    public void verifyCurJobBtnsShown() {

    }
}



