package edu.gatech.seclass.jobcompare6300;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class DatabaseHelper extends SQLiteOpenHelper {


    /*schema:
    ID: 0
    TITLE: 1
    COMPANY: 2
    LOCATION: 3
    COST_OF_LIVING: 4
    YEARLY_SALARY:5
    YEARLY_BONUS 6
    RSU 7
    RELOCATION_STIPEND 8
    PTO 9
    IS_CURRENT_JOB 10
    * */
    private static final String OFFER_TABLE = "OFFER_TABLE";
    private static final String COLUMN_TITLE = "TITLE";
    private static final String COLUMN_COMPANY = "COMPANY";
    private static final String COLUMN_COST_OF_LIVING = "COST_OF_LIVING";
    private static final String COLUMN_YEARLY_SALARY = "YEARLY_SALARY";
    private static final String COLUMN_YEARLY_BONUS = "YEARLY_BONUS";
    private static final String COLUMN_RSU = "RSU";
    private static final String COLUMN_LOCATION = "LOCATION";
    private static final String COLUMN_RELOCATION_STIPEND = "RE" + COLUMN_LOCATION + "_STIPEND";
    private static final String COLUMN_PTO = "PTO";
    private static final String COLUMN_IS_CURRENT_JOB = "IS_CURRENT_JOB";
    private static final String COLUMN_ID = "ID";

    public DatabaseHelper(@Nullable Context context) {
        super(context, "JobOfferComparison.db", null, 1);
    }

    //this is called the first time a database is accessed. There should be code in there to create a new database
    @Override
    public void onCreate(SQLiteDatabase db) {

        String createTableStatement = "CREATE TABLE " + OFFER_TABLE + " ( " + COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + COLUMN_TITLE + " TEXT, "
                + COLUMN_COMPANY + " TEXT, "
                + COLUMN_LOCATION + " TEXT, "
                + COLUMN_COST_OF_LIVING + " INTEGER, "
                + COLUMN_YEARLY_SALARY + " REAL, "
                + COLUMN_YEARLY_BONUS + " REAL, "
                + COLUMN_RSU + " REAL, "
                + COLUMN_RELOCATION_STIPEND + " REAL, "
                + COLUMN_PTO + " INTEGER, "
                + COLUMN_IS_CURRENT_JOB + " INTEGER )";

        db.execSQL(createTableStatement);
    }

    //this is called if the database version number changes. It prevents previous users apps from crashing when you change the database design
    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }

    private ContentValues createContentValues(Job offer) {

        ContentValues cv = new ContentValues();

        cv.put(COLUMN_TITLE, offer.getTitle());
        cv.put(COLUMN_COMPANY, offer.getCompany());
        cv.put(COLUMN_LOCATION, offer.getLocation());
        cv.put(COLUMN_COST_OF_LIVING, offer.getCostOfLiving());
        cv.put(COLUMN_YEARLY_SALARY, offer.getYearlySalary());
        cv.put(COLUMN_YEARLY_BONUS, offer.getYearlyBonus());
        cv.put(COLUMN_RSU, offer.getRsu());
        cv.put(COLUMN_RELOCATION_STIPEND, offer.getRelocationStipend());
        cv.put(COLUMN_PTO, offer.getPto());

        return cv;
    }

    public boolean addJobOffer(Job offer) {

        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = createContentValues(offer);

        cv.put(COLUMN_IS_CURRENT_JOB, offer.isCurrentJob());

        long insert = db.insert(OFFER_TABLE, null, cv);

        return insert==-1L? false: true;
    }

    public boolean updateCurrentJob(Job offer) {

        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = createContentValues(offer);
        String selection = COLUMN_IS_CURRENT_JOB + " =? ";
        String[] selectionArgs = {"1"};

        int count = db.update(OFFER_TABLE, cv, selection, selectionArgs);
        return count == 1? true: false;
    }


    public List<Job> getAll() {

        List<Job> list = new ArrayList<>();
        String query = " SELECT * FROM " + OFFER_TABLE;

        //only readable database is needed here, getWritableDatabase locks the data file so other precesses
        //may not access it
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.rawQuery(query, null);

        //cursor.moveToFirst returns a true if there were items selected
        if(cursor.moveToFirst()) {

            //loop through the cursor (result set) and create new job objects. Put then into the result list
            //proceed through the database one at a time
            while(cursor.moveToNext()) {
                boolean isCurrentJob = cursor.getInt(10) == 1? true: false;
                Job offer = new Job(cursor.getString(1), cursor.getString(2), cursor.getString(3),
                        cursor.getInt(4), cursor.getFloat(5), cursor.getFloat(6), cursor.getFloat(7),
                        cursor.getFloat(8), cursor.getInt(9), isCurrentJob);

                list.add(offer);
            }
        } else {
            //failure, don't add anything to the list
        }

        cursor.close();

        return list;
    }

    public Job getCurrentJob() {

        String query = " SELECT * FROM " + OFFER_TABLE + " WHERE " + COLUMN_IS_CURRENT_JOB + " = 1";
        SQLiteDatabase db = this.getReadableDatabase();

        Job currentJob = null;
        Cursor cursor = db.rawQuery(query, null);

        if(cursor.moveToFirst()) {

            boolean isCurrentJob = cursor.getInt(10) == 1? true: false;
            currentJob = new Job(cursor.getString(1), cursor.getString(2), cursor.getString(3),
                    cursor.getInt(4), cursor.getFloat(5), cursor.getFloat(6), cursor.getFloat(7),
                    cursor.getFloat(8), cursor.getInt(9), isCurrentJob);
        }
        return currentJob;
    }


}
