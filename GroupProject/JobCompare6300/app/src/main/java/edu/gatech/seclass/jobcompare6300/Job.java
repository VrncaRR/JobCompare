package edu.gatech.seclass.jobcompare6300;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

public class Job implements Parcelable{

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
    private float score;

    private void calculateSalaryAdjusted() {
        this.yearlySalaryAdjusted = (this.yearlySalary/costOfLiving)*100;
    }
    private void calculateBonusAdjusted() {
        this.yearlyBonusAdjusted = (this.yearlyBonus/costOfLiving)*100;
    }

    //constructor 1 excludes score
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

    //constructor  2 use parcel
    public Job(Parcel parcel) {
        this.title = parcel.readString();
        this.company = parcel.readString();
        this.location = parcel.readString();
        this.costOfLiving = parcel.readInt();
        this.yearlySalary = parcel.readFloat();
        this.yearlyBonus=parcel.readFloat();
        this.rsu=parcel.readFloat();
        this.relocationStipend=parcel.readFloat();
        this.isCurrentJob=parcel.readBoolean();
        this.yearlySalaryAdjusted=parcel.readFloat();
        this.yearlyBonusAdjusted=parcel.readFloat();
        this.pto = parcel.readInt();
        this.score =parcel.readFloat();

    }

    public static final Parcelable.Creator<Job> CREATOR = new Parcelable.Creator<Job>() {
        @Override
        public Job createFromParcel(Parcel in) {
            return new Job(in);
        }

        @Override
        public Job[] newArray(int size) {
            return new Job[size];
        }
    };

    public void calculateScore(int salaryW, int bounsW, int rsuW, int stipendW, int ptoW){
        float sum = (float)(salaryW + bounsW + rsuW + stipendW + ptoW);

        this.score= (salaryW*this.yearlySalaryAdjusted + bounsW*this.yearlyBonusAdjusted
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

    public float getScore() {
        return score;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(@NonNull Parcel parcel, int i) {

        parcel.writeString(title);
        parcel.writeString(company);
        parcel.writeString(location);
        parcel.writeInt(costOfLiving);
        parcel.writeFloat(yearlySalary);
        parcel.writeFloat(yearlyBonus);
        parcel.writeFloat(rsu);
        parcel.writeFloat(relocationStipend);
        parcel.writeBoolean(isCurrentJob);
        parcel.writeFloat(yearlySalaryAdjusted);
        parcel.writeFloat(yearlyBonusAdjusted);
        parcel.writeInt(pto);
        parcel.writeFloat(score);
    }

}
