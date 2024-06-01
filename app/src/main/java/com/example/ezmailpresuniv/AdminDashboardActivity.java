package com.example.ezmailpresuniv;

import android.database.Cursor;
import android.os.Bundle;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

public class AdminDashboardActivity extends AppCompatActivity {

    private DatabaseHelper databaseHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_dashboard);

        // Initialize DatabaseHelper
        databaseHelper = new DatabaseHelper(this);

        // Display a welcome message for the admin
        TextView welcomeMessageTextView = findViewById(R.id.welcomeMessageTextView);
        welcomeMessageTextView.setText("Welcome Admin!");

        // Retrieve active users from the database
        List<String> activeUsers = getActiveUsers();

        // Get the table layout
        TableLayout tableLayout = findViewById(R.id.tableLayout);

        // Add each active user to the table
        for (String user : activeUsers) {
            TableRow row = new TableRow(this);

            TextView textView = new TextView(this);
            textView.setText(user);
            row.addView(textView);

            TextView statusTextView = new TextView(this);
            statusTextView.setText(" is Online");
            statusTextView.setTextColor(getResources().getColor(android.R.color.darker_gray));
            row.addView(statusTextView);

            tableLayout.addView(row);
        }
    }

    // Method to retrieve active users from the database
    private List<String> getActiveUsers() {
        List<String> activeUsers = new ArrayList<>();
        // Query the database to get active users
        // This is just a placeholder, you need to implement the actual database query
        // For example:
        Cursor cursor = databaseHelper.getReadableDatabase().rawQuery(
                "SELECT username FROM users WHERE is_active = 1", null);
        if (cursor != null && cursor.moveToFirst()) {
            do {
                String username = cursor.getString(cursor.getColumnIndex("username"));
                activeUsers.add(username);
            } while (cursor.moveToNext());
            cursor.close();
        }
        return activeUsers;
    }
}
