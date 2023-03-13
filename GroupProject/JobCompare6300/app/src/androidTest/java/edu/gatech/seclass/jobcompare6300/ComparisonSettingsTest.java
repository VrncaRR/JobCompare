
package edu.gatech.seclass.jobcompare6300;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.ext.junit.runners.AndroidJUnit4;

import static org.junit.Assert.assertEquals;

import android.os.Looper;

@RunWith(AndroidJUnit4.class)
public class ComparisonSettingsTest {

    ComparisonSettings settings;

    @Before
    public void setUp() throws Exception{

        Looper.prepare();
        settings = new ComparisonSettings();

    }


    // Verify that the default weights are 1
    @Test
    public void testDefaultValues() {

        //Looper.prepare();
        assertEquals(1, settings.getSalaryWeight(), 0.0);
        assertEquals(1, settings.getBonusWeight(), 0.0);
        assertEquals(1, settings.getRSUWeight(), 0.0);
        assertEquals(1, settings.getRelocationStipendWeight(), 0.0);
        assertEquals(1, settings.getPTOWeight(), 0.0);

    }

    // Test getSalaryWeight()
    @Test
    public void testGetSalaryWeight() {

        assertEquals(1, settings.getSalaryWeight(), 0.0);
    }

    // Test getBonusWeight()
    @Test
    public void testGetBonusWeight() {

        assertEquals(1, settings.getBonusWeight(), 0.0);

    }

    // Test getRSUWeight()
    @Test
    public void testGetRSUWeight() {

        assertEquals(1, settings.getRSUWeight(), 0.0);
    }

    // Test getRelocationStipendWeight()
    @Test
    public void testGetRelocationStipendWeight() {

        assertEquals(1, settings.getRelocationStipendWeight(), 0.0);


    }

    // Test getPTOWeight()
    @Test
    public void testGetPTOWeight() {

        assertEquals(1, settings.getPTOWeight(), 0.0);

    }


}