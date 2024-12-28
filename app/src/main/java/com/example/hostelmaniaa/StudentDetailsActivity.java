package com.example.hostelmaniaa;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class StudentDetailsActivity extends AppCompatActivity {
    private EditText etStudentName, etUSN, etDOB, etRoomNo;
    private SQLiteDatabase database;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_details);

        etStudentName = findViewById(R.id.et_student_name);
        etUSN = findViewById(R.id.et_usn);
        etDOB = findViewById(R.id.et_dob);
        etRoomNo = findViewById(R.id.et_room_no);

        // Initialize the database
        HostelDatabaseHelper dbHelper = new HostelDatabaseHelper(this);
        database = dbHelper.getWritableDatabase();

        findViewById(R.id.btn_submit).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                saveStudentDetails();
            }
        });
    }

    private void saveStudentDetails() {
        String name = etStudentName.getText().toString().trim();
        String usn = etUSN.getText().toString().trim();
        String dob = etDOB.getText().toString().trim();
        String roomNo = etRoomNo.getText().toString().trim();

        if (name.isEmpty() || usn.isEmpty() || dob.isEmpty() || roomNo.isEmpty()) {
            Toast.makeText(this, "Please fill in all fields", Toast.LENGTH_SHORT).show();
            return;
        }

        ContentValues values = new ContentValues();
        values.put("name", name);
        values.put("usn", usn);
        values.put("dob", dob);
        values.put("room_no", roomNo);

        long newRowId = database.insert("students", null, values);

        if (newRowId != -1) {
            Toast.makeText(this, "Student details saved successfully", Toast.LENGTH_SHORT).show();
            etStudentName.setText("");
            etUSN.setText("");
            etDOB.setText("");
            etRoomNo.setText("");
        } else {
            Toast.makeText(this, "Failed to save student details", Toast.LENGTH_SHORT).show();
        }
    }
}
