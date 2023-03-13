package edu.gatech.seclass.jobcompare6300;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import android.os.Looper;

import androidx.test.platform.app.InstrumentationRegistry;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;


public class JobTest {

    private Job testJob;

    @Before
    public void setUp() throws Exception {

        testJob = new Job("SDE 1", "Amazon", "Seattle",
                25, 200000F, 20000F, 16853.3F,
                5000, 20, true);
        Looper.prepare();
    }


    // Test score calculation with default values
    @Test
    public void testCalcScoreWithDefaults() {

        ComparisonSettings setting = new ComparisonSettings();

        float sum = (float)(setting.getSalaryWeight() + setting.getBonusWeight() + setting.getRSUWeight() + setting.getPTOWeight() + setting.getRelocationStipendWeight());

        float score = (setting.getSalaryWeight()* testJob.getYearlySalaryAdjusted() + setting.getRSUWeight()* testJob.getRsu()/4
                + setting.getBonusWeight()* testJob.getYearlyBonusAdjusted() + setting.getRelocationStipendWeight() * testJob.getRelocationStipend() +
                setting.getPTOWeight() * setting.getPTOWeight()*testJob.getYearlySalaryAdjusted()* testJob.getPto()/260)/sum;

        testJob.calculateScore(setting.getSalaryWeight(), setting.getBonusWeight(), setting.getRSUWeight(), setting.getRelocationStipendWeight(), setting.getPTOWeight());
        assertEquals(score, testJob.getScore(), 0.0);
    }

    // Test getScore()
    @Test
    public void testGetScore() {

        Looper.prepare();

        ComparisonSettings setting = new ComparisonSettings();

        float sum = (float)(setting.getSalaryWeight() + setting.getBonusWeight() + setting.getRSUWeight() + setting.getPTOWeight() + setting.getRelocationStipendWeight());

        float score = (setting.getSalaryWeight()* testJob.getYearlySalaryAdjusted() + setting.getRSUWeight()* testJob.getRsu()/4
                + setting.getBonusWeight()* testJob.getYearlyBonusAdjusted() + setting.getRelocationStipendWeight() * testJob.getRelocationStipend() +
                setting.getPTOWeight() * setting.getPTOWeight()*testJob.getYearlySalaryAdjusted()* testJob.getPto()/260)/sum;

        testJob.calculateScore(setting.getSalaryWeight(), setting.getBonusWeight(), setting.getRSUWeight(), setting.getRelocationStipendWeight(), setting.getPTOWeight());
        assertEquals(score, testJob.getScore(), 0.0);

    }

    // Test getPTO()
    @Test
    public void testGetPto() {

        assertEquals(20, testJob.getPto(), 0.0);

    }

    // Test getYearlyBonusAdjusted()
    @Test
    public void testGetYearlyBonusAdjusted() {

        assertEquals((testJob.getYearlyBonus()/(testJob.getCostOfLiving()*1.0)*100), testJob.getYearlyBonusAdjusted(), 0.0);

    }

    // Test getYearlySalaryAdjusted()
    @Test
    public void testGetYearlySalaryAdjusted() {

        assertEquals((testJob.getYearlySalary()/(testJob.getCostOfLiving()*1.0)*100), testJob.getYearlySalaryAdjusted(), 0.0);

    }

    // Test getIsCurrentJob()
    @Test
    public void testGetIsCurrentJob() {

        assertTrue(testJob.isCurrentJob());

    }

    // Test getRelocationStipend()
    @Test
    public void testGetRelocationStipend() {

        assertEquals(5000, testJob.getRelocationStipend(), 0);

    }

    // Test getRSU()
    @Test
    public void testGetRSU() {

        assertEquals(16853.3F, testJob.getRsu(), 0);

    }

    // Test getYearlyBonus()
    @Test
    public void testGetYearlyBonus() {

        assertEquals(20000F, testJob.getYearlyBonus(), 0);

    }

    // Test getYearlySalary()
    @Test
    public void testGetYearlySalary() {

        assertEquals(20000F, testJob.getYearlyBonus(), 0);


    }

    // Test getCostOfLiving()
    @Test
    public void testGetCostOfLiving() {

        assertEquals(25, testJob.getCostOfLiving(), 0);

    }

    // Test getLocation()
    @Test
    public void testGetLocation() {

        assertEquals("Test getLocation function", "Seattle", testJob.getLocation());
    }

    // Test getCompany()
    @Test
    public void testGetCompany() {

        assertEquals("Test getCompany function", "Amazon", testJob.getCompany());

    }

    // Test getTitle()
    @Test
    public void testGetTitle() {

        assertEquals("Test getTitle function", "SDE 1", testJob.getTitle());

    }
}
