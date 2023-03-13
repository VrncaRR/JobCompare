package edu.gatech.seclass.jobcompare6300;

import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

public class JobWrapper implements Parcelable {

    private Job job;

    private boolean isSelected;

    public JobWrapper(Job job, boolean isSelected) {
        this.job = job;
        this.isSelected = isSelected;
    }

    protected JobWrapper(Parcel in) {

        job = in.readParcelable(null);
        isSelected = in.readBoolean();
    }

    public static final Creator<JobWrapper> CREATOR = new Creator<JobWrapper>() {
        @Override
        public JobWrapper createFromParcel(Parcel in) {
            return new JobWrapper(in);
        }

        @Override
        public JobWrapper[] newArray(int size) {
            return new JobWrapper[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(@NonNull Parcel parcel, int i) {
        parcel.writeParcelable(job,PARCELABLE_WRITE_RETURN_VALUE);
        parcel.writeBoolean(isSelected);

    }

    public Job getJob() {
        return job;
    }

    public void setJob(Job job) {
        this.job = job;
    }

    public boolean isSelected() {
        return isSelected;
    }

    public void setSelected(boolean selected) {
        isSelected = selected;
    }
}
