package edu.gatech.seclass.jobcompare6300;

import android.app.Activity;

public class ComparisonSettings extends Activity {

    private int salaryWeight=1;
    private int bonusWeight=1;
    private int RSUWeight=1;
    private int relocationStipendWeight=1;
    private int PTOWeight=1;

    public ComparisonSettings() {

        this.salaryWeight = 1;
        this.bonusWeight = 1;
        this.RSUWeight = 1;
        this.relocationStipendWeight = 1;
        this.PTOWeight = 1;

    }

    public ComparisonSettings(int salaryWeight, int bonusWeight, int RSUWeight,
                              int relocationStipendWeight, int PTOWeight) {

        this.salaryWeight = salaryWeight;
        this.bonusWeight = bonusWeight;
        this.RSUWeight = RSUWeight;
        this.relocationStipendWeight = relocationStipendWeight;
        this.PTOWeight = PTOWeight;
    }

    public int getSalaryWeight() {
        return salaryWeight;
    }

    public void setSalaryWeight(int salaryWeight) {
        this.salaryWeight = salaryWeight;
    }

    public int getBonusWeight() {
        return bonusWeight;
    }

    public void setBonusWeight(int bonusWeight) {
        this.bonusWeight = bonusWeight;
    }

    public int getRSUWeight() {
        return RSUWeight;
    }

    public void setRSUWeight(int RSUWeight) {
        this.RSUWeight = RSUWeight;
    }

    public int getRelocationStipendWeight() {
        return relocationStipendWeight;
    }

    public void setRelocationStipendWeight(int relocationStipendWeight) {
        this.relocationStipendWeight = relocationStipendWeight;
    }

    public int getPTOWeight() {
        return PTOWeight;
    }

    public void setPTOWeight(int PTOWeight) {
        this.PTOWeight = PTOWeight;
    }
}
