package com.example.hostelmaniaa;

import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import com.google.android.material.button.MaterialButton;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        MaterialButton studentDetailsBtn = findViewById(R.id.studentDetailsBtn);
        MaterialButton showStudentsBtn = findViewById(R.id.showStudentsBtn);
        MaterialButton timeTableBtn = findViewById(R.id.timeTableBtn);

        studentDetailsBtn.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, StudentDetailsActivity.class);
            startActivity(intent);
        });

        showStudentsBtn.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, ShowStudentsActivity.class);
            startActivity(intent);
        });

        timeTableBtn.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, TimeTableActivity.class);
            startActivity(intent);
        });
    }
}



//package com.example.hostelmaniaa;
//
//import android.content.Intent;
//import android.os.Bundle;
//import androidx.appcompat.app.AppCompatActivity;
//import com.google.android.material.button.MaterialButton;
//
//public class MainActivity extends AppCompatActivity {
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);
//
//        MaterialButton studentDetailsBtn = findViewById(R.id.studentDetailsBtn);
//        MaterialButton showStudentsBtn = findViewById(R.id.showStudentsBtn);
//        MaterialButton timeTableBtn = findViewById(R.id.timeTableBtn); // New Button
//
//        // Open Student Details Activity
//        studentDetailsBtn.setOnClickListener(v -> {
//            Intent intent = new Intent(MainActivity.this, StudentDetailsActivity.class);
//            startActivity(intent);
//        });
//
//        // Open Show Students Activity
//        showStudentsBtn.setOnClickListener(v -> {
//            Intent intent = new Intent(MainActivity.this, ShowStudentsActivity.class);
//            startActivity(intent);
//        });
//
//        // Open Time Table Activity
//        timeTableBtn.setOnClickListener(v -> {
//            Intent intent = new Intent(MainActivity.this, TimeTableActivity.class);
//            startActivity(intent);
//        });
//    }
//}
