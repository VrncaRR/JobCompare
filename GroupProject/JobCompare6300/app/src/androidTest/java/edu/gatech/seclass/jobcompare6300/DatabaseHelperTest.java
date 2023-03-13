package edu.gatech.seclass.jobcompare6300;

import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.platform.app.InstrumentationRegistry;

import org.junit.Before;
import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

@RunWith(AndroidJUnit4.class)
public class DatabaseHelperTest {

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

    @Test
    public void testGetCurrentJob() throws Exception {
        database.addJobOffer(new Job("Staff Engineer", "Google", "NYC",
                22, 250000, 40000, 500, 2000, 20, true));
        Job currJobResult = database.getCurrentJob();
        assertEquals("Staff Engineer", currJobResult.getTitle());
        assertEquals("Google", currJobResult.getCompany());
        assertEquals("NYC", currJobResult.getLocation());
        assertEquals(22, currJobResult.getCostOfLiving(), 0);
        assertEquals(250000, currJobResult.getYearlySalary(), 0);
        assertEquals(40000, currJobResult.getYearlyBonus(), 0);
        assertEquals(500, currJobResult.getRsu(), 0);
        assertEquals(2000, currJobResult.getRelocationStipend(), 0);
        assertEquals(20, currJobResult.getPto(), 0);
        assertTrue(currJobResult.isCurrentJob());
    }

}
