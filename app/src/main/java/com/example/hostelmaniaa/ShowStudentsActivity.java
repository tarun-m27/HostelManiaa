package com.example.hostelmaniaa;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class ShowStudentsActivity extends AppCompatActivity {
    private TextView tvStudentList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_students);

        tvStudentList = findViewById(R.id.tv_student_list);

        // Initialize the database and fetch student details
        HostelDatabaseHelper dbHelper = new HostelDatabaseHelper(this);
        SQLiteDatabase database = dbHelper.getReadableDatabase();
        displayStudents(database);
    }

    private void displayStudents(SQLiteDatabase database) {
        StringBuilder studentData = new StringBuilder();
        Cursor cursor = database.rawQuery("SELECT * FROM students ORDER BY room_no", null);

        if (cursor.moveToFirst()) {
            do {
                String name = cursor.getString(cursor.getColumnIndexOrThrow("name"));
                String usn = cursor.getString(cursor.getColumnIndexOrThrow("usn"));
                String dob = cursor.getString(cursor.getColumnIndexOrThrow("dob"));
                String roomNo = cursor.getString(cursor.getColumnIndexOrThrow("room_no"));

                studentData.append("Room No: ").append(roomNo).append("\n")
                        .append("Name: ").append(name).append("\n")
                        .append("USN: ").append(usn).append("\n")
                        .append("DOB: ").append(dob).append("\n\n");
            } while (cursor.moveToNext());
        } else {
            studentData.append("No student details available.");
        }

        cursor.close();
        tvStudentList.setText(studentData.toString());
    }
}
