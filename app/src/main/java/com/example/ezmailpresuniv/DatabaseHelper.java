package com.example.ezmailpresuniv;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHelper extends SQLiteOpenHelper {

    // Database Name
    private static final String DATABASE_NAME = "UserDB";

    // Database Version
    private static final int DATABASE_VERSION = 2; // Incremented version for schema change

    // Table Names
    private static final String TABLE_USERS = "users";

    // Common column names
    private static final String KEY_ID = "id";
    private static final String KEY_EMAIL = "email";
    private static final String KEY_PASSWORD = "password";
    private static final String KEY_IS_ADMIN = "is_admin"; // New column for admin flag

    // Table create statement
    private static final String CREATE_TABLE_USERS = "CREATE TABLE " + TABLE_USERS +
            "(" + KEY_ID + " INTEGER PRIMARY KEY AUTOINCREMENT," +
            KEY_EMAIL + " TEXT," +
            KEY_PASSWORD + " TEXT," +
            KEY_IS_ADMIN + " INTEGER DEFAULT 0)"; // Default to regular user

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        // Creating required tables
        db.execSQL(CREATE_TABLE_USERS);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // Drop older table if existed
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_USERS);

        // Create tables again
        onCreate(db);
    }

    // Method to add a new user to the database
    public long addUser(String email, String password, int isAdmin) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(KEY_EMAIL, email);
        values.put(KEY_PASSWORD, password);
        values.put(KEY_IS_ADMIN, isAdmin);

        // Inserting Row
        long id = db.insert(TABLE_USERS, null, values);
        db.close(); // Closing database connection
        return id;
    }

    // Method to check if a user exists in the database
    public boolean checkUser(String email, String password) {
        SQLiteDatabase db = this.getReadableDatabase();

        // Define a projection that specifies which columns from the database
        // you will actually use after this query.
        String[] projection = {KEY_ID};

        // Filter results WHERE "email" = 'email' AND "password" = 'password' AND "is_admin" = 0
        String selection = KEY_EMAIL + " = ?" + " AND " + KEY_PASSWORD + " = ?" + " AND " + KEY_IS_ADMIN + " = 0";
        String[] selectionArgs = {email, password};

        Cursor cursor = db.query(
                TABLE_USERS,                       // The table to query
                projection,                        // The array of columns to return (pass null to get all)
                selection,                         // The columns for the WHERE clause
                selectionArgs,                     // The values for the WHERE clause
                null,                              // Don't group the rows
                null,                              // Don't filter by row groups
                null                               // The sort order
        );

        boolean userExists = cursor.moveToFirst();
        cursor.close();
        db.close();
        return userExists;
    }

    // Method to check if a user is an admin
    public boolean checkAdmin(String email, String password) {
        SQLiteDatabase db = this.getReadableDatabase();

        // Define a projection that specifies which columns from the database
        // you will actually use after this query.
        String[] projection = {KEY_ID};

        // Filter results WHERE "email" = 'email' AND "password" = 'password' AND "is_admin" = 1
        String selection = KEY_EMAIL + " = ?" + " AND " + KEY_PASSWORD + " = ?" + " AND " + KEY_IS_ADMIN + " = 1";
        String[] selectionArgs = {email, password};

        Cursor cursor = db.query(
                TABLE_USERS,                       // The table to query
                projection,                        // The array of columns to return (pass null to get all)
                selection,                         // The columns for the WHERE clause
                selectionArgs,                     // The values for the WHERE clause
                null,                              // Don't group the rows
                null,                              // Don't filter by row groups
                null                               // The sort order
        );

        boolean adminExists = cursor.moveToFirst();
        cursor.close();
        db.close();
        return adminExists;
    }
}
