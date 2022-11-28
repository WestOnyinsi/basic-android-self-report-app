package com.example.eshahidiv10;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

public class DBHandler extends SQLiteOpenHelper {

    // creating a constant variables for our database.
    // below variable is for our database name.
    private static final String DB_NAME = "db";

    // below is our database version
    private static final int DB_VERSION = 1;

    // below is our table name.
    private static final String TABLE_NAME = "myactivity";

    // below is our id column.
    private static final String ID_COL = "id";

    // below variable is for our activity name column
    private static final String NAME_COL = "name";

    // below variable id for our date column.
    private static final String DATE_COL = "date";

    // below variable is for our location column.
    private static final String LOCATION_COL = "location";

    // below variable for our time column.
    private static final String TIME_COL = "time";

    // below variable for our reporter column.
    private static final String REPORTER_COL = "reporter";

    // below variable for our report description column.
    private static final String DESCRIPTION_COL = "description";


    // creating a constructor for our database handler.
    public DBHandler(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    // below method is for creating a database by running a sqlite query
    @Override
    public void onCreate(SQLiteDatabase db) {

        // on below line we are creating
        // an sqlite query and we are
        // setting our column names
        // along with their data types.
        String query = "CREATE TABLE " + TABLE_NAME + " ("
                + ID_COL + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + NAME_COL + " TEXT,"
                + DATE_COL + " TEXT,"
                + LOCATION_COL + " TEXT,"
                + TIME_COL + " TEXT,"
                + REPORTER_COL + " TEXT,"
                + DESCRIPTION_COL + " TEXT)";

        // at last we are calling a exec sql
        // method to execute above sql query
        db.execSQL(query);
    }

    // this method is use to add new activity to our sqlite database.
    public void addNewActivity(String activityName, String activityDate, String activityLocation, String activityTime, String activityReporter, String activityDescription ) {

        // on below line we are creating a variable for our sqlite database and calling writable method as we are writing data in our database.
        SQLiteDatabase db = this.getWritableDatabase();

        // on below line we are creating a variable for content values.
        ContentValues values = new ContentValues();

        // on below line we are passing all values
        // along with their key and value pair.
        values.put(NAME_COL, activityName);
        values.put(DATE_COL, activityDate);
        values.put(LOCATION_COL, activityLocation);
        values.put(TIME_COL, activityTime);
        values.put(REPORTER_COL, activityReporter);
        values.put(DESCRIPTION_COL, activityDescription);


        // after adding all values we are passing
        // content values to our table.
        db.insert(TABLE_NAME, null, values);

        // at last we are closing our
        // database after adding database.
        db.close();
    }

    // we have created a new method for reading all the activities
    public ArrayList<Modal> readActivities() {
        // on below line we are creating a
        // database for reading our database.
        SQLiteDatabase db = this.getReadableDatabase();

        // on below line we are creating a cursor with query to read data from database.
        Cursor cursorActivities = db.rawQuery("SELECT * FROM " + TABLE_NAME, null);

        // on below line we are creating a new array list.
        ArrayList<Modal> ModalArrayList = new ArrayList<>();

        // moving our cursor to first position.
        if (cursorActivities.moveToFirst()) {
            do {
                // on below line we are adding the data from cursor to our array list.
                ModalArrayList.add(new Modal(
                        cursorActivities.getString(1),
                        cursorActivities.getString(2),
                        cursorActivities.getString(3),
                        cursorActivities.getString(4),
                        cursorActivities.getString(5),
                        cursorActivities.getString(6)));
            } while (cursorActivities.moveToNext());
            // moving our cursor to next.
        }
        // at last closing our cursor
        // and returning our array list.
        cursorActivities.close();
        return ModalArrayList;
    }

    // below is the method for updating our activities
    public void updateActivity(String originalActivityName, String activityName, String activityDate, String activityLocation, String activityTime, String activityReporter, String activityDescription) {

        // calling a method to get writable database.
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();

        // on below line we are passing all values
        // along with its key and value pair.
        values.put(NAME_COL, activityName);
        values.put(DATE_COL, activityDate);
        values.put(LOCATION_COL, activityLocation);
        values.put(TIME_COL, activityTime);
        values.put(REPORTER_COL, activityReporter);
        values.put(DESCRIPTION_COL, activityDescription);

        // on below line we are calling a update method to update our database and passing our values.
        // and we are comparing it with name of our activity which is stored in original name variable.
        db.update(TABLE_NAME, values, "name=?", new String[]{originalActivityName});
        db.close();
    }

    // below is the method for deleting our activity
    public void deleteActivity(String activityName) {

        // on below line we are creating
        // a variable to write our database.
        SQLiteDatabase db = this.getWritableDatabase();

        // on below line we are calling a method to delete our
        // activity and we are comparing it with our activity name.
        db.delete(TABLE_NAME, "name=?", new String[]{activityName});
        db.close();
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // this method is called to check if the table exists already.
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }
}
