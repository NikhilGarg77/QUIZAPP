package com.example.project;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

public class DBHandler extends SQLiteOpenHelper {

    // creating a constant variables for our database.
    // below variable is for our database name.
    private static final String DB_NAME = "addQues.db";

    // below int is our database version
    private static final int DB_VERSION = 1;

    // below variable is for our table name.
    private static final String TABLE_NAME = "newQues";

    // below variable is for our id column.
    private static final String ID_COL = "id";

    // below variable is for our course name column
    private static final String QUESTION = "question";

    // below variable id for our course duration column.
    private static final String CHOICE1 = "choice1";

    // below variable for our course description column.
    private static final String CHOICE2 = "choice2";

    // below variable is for our course tracks column.
    private static final String CHOICE3 = "choice3";
    private static final String CHOICE4 = "choice4";
    private static final String ANSWER = "answer";

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
                + QUESTION + " TEXT,"
                + CHOICE1 + " TEXT,"
                + CHOICE2 + " TEXT,"
                + CHOICE3 + " TEXT,"
                + CHOICE4 + " TEXT,"
                + ANSWER + " TEXT)";

        // at last we are calling a exec sql
        // method to execute above sql query
        db.execSQL(query);
    }

    // this method is use to add new course to our sqlite database.
    public void addNewCourse(String question, String choice1, String choice2, String choice3, String choice4, String answer) {

        // on below line we are creating a variable for
        // our sqlite database and calling writable method
        // as we are writing data in our database.
        SQLiteDatabase db = this.getWritableDatabase();

        // on below line we are creating a
        // variable for content values.
        ContentValues values = new ContentValues();

        // on below line we are passing all values
        // along with its key and value pair.
        values.put(QUESTION, question);
        values.put(CHOICE1, choice1);
        values.put(CHOICE2, choice2);
        values.put(CHOICE3, choice3);
        values.put(CHOICE4, choice4);
        values.put(ANSWER, answer);

        // after adding all values we are passing
        // content values to our table.
        db.insert(TABLE_NAME, null, values);

        // at last we are closing our
        // database after adding database.
        db.close();
    }

    // we have created a new method for reading all the courses.
    public ArrayList<com.example.project.QuestionModal> readCourses() {
        // on below line we are creating a
        // database for reading our database.
        SQLiteDatabase db = this.getReadableDatabase();

        // on below line we are creating a cursor with query to read data from database.
        Cursor cursorQues = db.rawQuery("SELECT * FROM " + TABLE_NAME, null);

        // on below line we are creating a new array list.
        ArrayList<com.example.project.QuestionModal> questionModalArrayList = new ArrayList<>();

        // moving our cursor to first position.
        if (cursorQues.moveToFirst()) {
            do {
                // on below line we are adding the data from cursor to our array list.
                questionModalArrayList.add(new com.example.project.QuestionModal(cursorQues.getString(1),
                        cursorQues.getString(2),
                        cursorQues.getString(3),
                        cursorQues.getString(4),
                        cursorQues.getString(5),
                        cursorQues.getString(6)));
            } while (cursorQues.moveToNext());
            // moving our cursor to next.
        }
        // at last closing our cursor
        // and returning our array list.
        cursorQues.close();
        return questionModalArrayList;
    }


    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // this method is called to check if the table exists already.
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }
}