package edu.gatech.seclass.jobcompare6300;

public class Job {

    private String title;
    private String company;
    private String location;
    private int costOfLiving;
    private float yearlySalary;
    private float yearlyBonus;
    private float rsu;
    private float relocationStipend;
    private boolean isCurrentJob;
    private float yearlySalaryAdjusted;
    private float yearlyBonusAdjusted;
    private int pto;

    public String getTitle() {
        return title;
    }

    public String getCompany() {
        return company;
    }

    public String getLocation() {
        return location;
    }

    public int getCostOfLiving() {
        return costOfLiving;
    }

    public float getYearlySalary() {
        return yearlySalary;
    }

    public float getYearlyBonus() {
        return yearlyBonus;
    }

    public float getRsu() {
        return rsu;
    }

    public float getRelocationStipend() {
        return relocationStipend;
    }

    public boolean isCurrentJob() {
        return isCurrentJob;
    }

    public float getYearlySalaryAdjusted() {
        return yearlySalaryAdjusted;
    }

    public float getYearlyBonusAdjusted() {
        return yearlyBonusAdjusted;
    }

    public int getPto() {
        return pto;
    }

    private static int currentJobID;

    private void calculateSalaryAdjusted() {
        this.yearlySalaryAdjusted = (this.yearlySalary/costOfLiving)*100;
    }
    private void calculateBonusAdjusted() {
        this.yearlyBonusAdjusted = (this.yearlyBonus/costOfLiving)*100;
    }

    public Job(String title, String company, String location,
               int costOfLiving, float yearlySalary, float yearlyBonus,
               float rsu, float relocationStipend, int pto, boolean isCurrentJob) {
        this.title = title;
        this.company = company;
        this.location = location;
        this.costOfLiving = costOfLiving;
        this.yearlySalary = yearlySalary;
        this.yearlyBonus = yearlyBonus;
        this.rsu = rsu;
        this.relocationStipend = relocationStipend;
        this.pto = pto;
        this.isCurrentJob = isCurrentJob;
        calculateSalaryAdjusted();
        calculateBonusAdjusted();
    }

    public float calculateScore(int salaryW, int bounsW, int rsuW, int stipendW, int ptoW){
        float sum = (float)(salaryW + bounsW + rsuW + stipendW + ptoW);

        return (salaryW*this.yearlySalaryAdjusted + bounsW*this.yearlyBonusAdjusted
                + rsuW*rsu/4 + stipendW*relocationStipend + ptoW *pto*yearlySalaryAdjusted/260)/sum;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public void setCostOfLiving(int costOfLiving) {
        this.costOfLiving = costOfLiving;
        calculateSalaryAdjusted();
        calculateBonusAdjusted();
    }

    public void setYearlySalary(float yearlySalary) {
        this.yearlySalary = yearlySalary;
        calculateSalaryAdjusted();
    }

    public void setYearlyBonus(float yearlyBonus) {
        this.yearlyBonus = yearlyBonus;
        calculateBonusAdjusted();
    }

    public void setRsu(float rsu) {
        this.rsu = rsu;
    }

    public void setRelocationStipend(float relocationStipend) {
        this.relocationStipend = relocationStipend;
    }

    public void setCurrentJob(boolean currentJob) {
        isCurrentJob = currentJob;
    }

    public void setPto(int pto) {
        this.pto = pto;
    }


}
