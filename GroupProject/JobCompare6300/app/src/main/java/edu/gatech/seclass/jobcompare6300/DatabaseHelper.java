package edu.gatech.seclass.jobcompare6300;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Looper;
import android.util.Log;

import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class DatabaseHelper extends SQLiteOpenHelper {


    /*schema:
    OFFER_TABLE
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

    COMPARISON_SETTING_TABLE SCHEMA
    ID: 0
    SALARY_WEIGHT 1
    BONUS_WEIGHT 2
    RSU_WEIGHT 3
    RELOCATION_STIPEND_WEIGHT 4
    PTO_WEIGHT 5

    comparison setting table: only one record with id = 1 will be kept in the table.
    whenever the comparison setting is updated,
    the record in the comparison_setting_table will be updated, too.

    * */

    private static final int DATABASE_VERSION = 2;
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
    private static final String COMPARISON_TABLE = "COMPARISON_TABLE";
    private static final String COLUMN_SALARY_WEIGHT = "SALARY_WEIGHT";
    private static final String COLUMN_BONUS_WEIGHT = "BONUS_WEIGHT";
    private static final String COLUMN_RSU_WEIGHT = "RSU_WEIGHT";
    private static final String COLUMN_RELOCATION_STIPEND_WEIGHT = "RELOCATION_STIPEND_WEIGHT";
    private static final String COLUMN_PTO_WEIGHT = "PTO_WEIGHT";

    public DatabaseHelper(@Nullable Context context) {
        super(context, "JobOfferComparison.db", null, DATABASE_VERSION);
    }

    public void deleteDB(@Nullable Context context) {
        context.deleteDatabase("JobOfferComparison.db");
    }

    //this is called the first time a database is accessed. There should be code in there to create a new database
    @Override
    public void onCreate(SQLiteDatabase db) {

        String createJobOfferTableStatement = "CREATE TABLE " + OFFER_TABLE + " ( " + COLUMN_ID + " INTEGER PRIMARY KEY, "
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

        String createComparisonSettingStatement = "CREATE TABLE " + COMPARISON_TABLE + " ( " + COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                COLUMN_SALARY_WEIGHT + " INTEGER, " +
                COLUMN_BONUS_WEIGHT + " INTEGER, " +
                COLUMN_RSU_WEIGHT + " INTEGER, " +
                COLUMN_RELOCATION_STIPEND_WEIGHT + " INTEGER, " +
                COLUMN_PTO_WEIGHT + " INTEGER )";

        db.execSQL(createJobOfferTableStatement);
        db.execSQL(createComparisonSettingStatement);
    }

    //this is called if the database version number changes. It prevents previous users apps from crashing when you change the database design
    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }

    private ContentValues extractOfferContentValues(Job offer) {

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

    private ContentValues extractComparisonSettingsContentValues(ComparisonSettings settings) {

        ContentValues cv = new ContentValues();

        //set the id = 1, always
        cv.put(COLUMN_ID, 1);
        cv.put(COLUMN_SALARY_WEIGHT, settings.getSalaryWeight());
        cv.put(COLUMN_BONUS_WEIGHT, settings.getBonusWeight());
        cv.put(COLUMN_RSU_WEIGHT, settings.getRSUWeight());
        cv.put(COLUMN_RELOCATION_STIPEND_WEIGHT, settings.getRelocationStipendWeight());
        cv.put(COLUMN_PTO_WEIGHT, settings.getPTOWeight());

        return cv;
    }

    public boolean addJobOffer(Job offer) {

        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = extractOfferContentValues(offer);

        cv.put(COLUMN_IS_CURRENT_JOB, offer.isCurrentJob());

        long insert = db.insert(OFFER_TABLE, null, cv);
        //close db when done
        db.close();

        return insert==-1L? false: true;
    }
    public boolean updateCurrentJob(Job offer) {

        //the current job record's COLUMN_IS_CURRENT_JOB is always 1,
        //select COLUMN_IS_CURRENT_JOB = 1 from database and update the record
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = extractOfferContentValues(offer);
        String selection = COLUMN_IS_CURRENT_JOB + " =? ";
        String[] selectionArgs = {"1"};

        int count = db.update(OFFER_TABLE, cv, selection, selectionArgs);
        //close db when done
        db.close();
        return count == 1? true: false;
    }
    public boolean addComparisonSetting(ComparisonSettings settings) {
        //add new comparison setting to the database
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = extractComparisonSettingsContentValues(settings);

        long insert = db.insert(COMPARISON_TABLE, null, cv);
        //close db when done
        db.close();
        return insert==-1L? false: true;
    }

    public boolean updateComparisonSetting(ComparisonSettings settings) {

        //only one setting record will be kept,  id = 1,
        //select id = 1 from database and update the comparison setting record
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = extractComparisonSettingsContentValues(settings);
        String selection = COLUMN_ID + " =? ";
        String[] selectionArgs = {"1"};

        int count = db.update(COMPARISON_TABLE, cv, selection, selectionArgs);
        //close db when done
        db.close();
        return count == 1? true: false;
    }

    public List<Job> getAll() {

        List<Job> list = new ArrayList<>();
        String query = " SELECT * FROM " + OFFER_TABLE;

        //get current setting and use weight to calculate score
        ComparisonSettings currentSettings = getCurrentSetting();

        //only readable database is needed here, getWritableDatabase locks the data file so other precesses
        //may not access it
        SQLiteDatabase db = this.getReadableDatabase();

        //add score to the offer
        //sort list
        Cursor cursor = db.rawQuery(query, null);

        //loop through the cursor (result set) and create new job objects. Put then into the result list
        //proceed through the database one at a time
        while(cursor.moveToNext()) {
            boolean isCurrentJob = cursor.getInt(10) == 1? true: false;

            Job offer = new Job(cursor.getString(1), cursor.getString(2), cursor.getString(3),
                    cursor.getInt(4), cursor.getFloat(5), cursor.getFloat(6), cursor.getFloat(7),
                    cursor.getFloat(8), cursor.getInt(9), isCurrentJob);

            //calculate score
            offer.calculateScore(currentSettings.getSalaryWeight(), currentSettings.getBonusWeight(),
                    currentSettings.getRSUWeight(), currentSettings.getRelocationStipendWeight(),
                    currentSettings.getPTOWeight());

            list.add(offer);
        }

        //close both cursor and db when done
        cursor.close();
        db.close();

        //sort the list descending
        list.sort((a,b)-> (int) (b.getScore() - a.getScore()));
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
        //close both cursor and db when done
        cursor.close();
        db.close();
        return currentJob;
    }

    public ComparisonSettings getCurrentSetting() {

        //get current comparison setting, if there is no current comparison setting,
        //return default comparison setting
        String query = " SELECT * FROM " + COMPARISON_TABLE + " WHERE " + COLUMN_ID + " = 1";
        ComparisonSettings currentSetting = null;
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.rawQuery(query, null);


        if(cursor.moveToFirst()) {
            //current comparison setting exists, return current comparison setting
            currentSetting = new ComparisonSettings(cursor.getInt(1), cursor.getInt(2), cursor.getInt(3),
                    cursor.getInt(4), cursor.getInt(5));
        } else {

            //no current comparison setting, return default settings
            //and add the default setting to db
            currentSetting = new ComparisonSettings();
            addComparisonSetting(currentSetting);

        }
        //close both cursor and db when done
        cursor.close();
        db.close();
        return currentSetting;
    }

    public boolean resetComparisonSetting()
    {
        SQLiteDatabase db = this.getWritableDatabase();
        String deleteStatement = " DELETE FROM " + COMPARISON_TABLE;
        db.execSQL(deleteStatement);

        ContentValues cv = extractComparisonSettingsContentValues(new ComparisonSettings());
        long insert = db.insert(COMPARISON_TABLE, null, cv);

        //close db when done
        db.close();
        return insert==-1L? false: true;
    }

    public Job getRecentAddedJob() {

        String query = " SELECT * FROM " + OFFER_TABLE + " ORDER BY " + COLUMN_ID + " DESC LIMIT 1 ";
        SQLiteDatabase db = this.getReadableDatabase();

        Job recentJob = null;
        Cursor cursor = db.rawQuery(query, null);

        if(cursor.moveToFirst()) {

            boolean isCurrentJob = cursor.getInt(10) == 1? true: false;
            recentJob = new Job(cursor.getString(1), cursor.getString(2), cursor.getString(3),
                    cursor.getInt(4), cursor.getFloat(5), cursor.getFloat(6), cursor.getFloat(7),
                    cursor.getFloat(8), cursor.getInt(9), isCurrentJob);
        }
        //close both cursor and db when done
        cursor.close();
        db.close();
        return recentJob;

    }

    public int countJobOffers() {

        String query = " SELECT COUNT ( * ) FROM " + OFFER_TABLE ;
        SQLiteDatabase db = this.getReadableDatabase();
        int count = 0;

        Cursor cursor = db.rawQuery(query, null);

        if(cursor.moveToFirst()) {

            count = cursor.getInt(0);
        }
        //close both cursor and db when done
        cursor.close();
        db.close();
        return count;

    }
}
