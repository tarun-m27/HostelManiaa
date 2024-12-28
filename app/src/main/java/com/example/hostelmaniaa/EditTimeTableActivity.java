package com.example.hostelmaniaa;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;

public class EditTimeTableActivity extends AppCompatActivity {

    private EditText mondayMealEditText, tuesdayMealEditText, wednesdayMealEditText, thursdayMealEditText, fridayMealEditText, saturdayMealEditText, sundayMealEditText;
    private SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_timetable);

        sharedPreferences = getSharedPreferences("TimetablePrefs", MODE_PRIVATE);

        // Initialize EditText fields for meal input
        mondayMealEditText = findViewById(R.id.mondayMealEditText);
        tuesdayMealEditText = findViewById(R.id.tuesdayMealEditText);
        wednesdayMealEditText = findViewById(R.id.wednesdayMealEditText);
        thursdayMealEditText = findViewById(R.id.thursdayMealEditText);
        fridayMealEditText = findViewById(R.id.fridayMealEditText);
        saturdayMealEditText = findViewById(R.id.saturdayMealEditText);
        sundayMealEditText = findViewById(R.id.sundayMealEditText);

        // Load current timetable values
        mondayMealEditText.setText(sharedPreferences.getString("Monday", ""));
        tuesdayMealEditText.setText(sharedPreferences.getString("Tuesday", ""));
        wednesdayMealEditText.setText(sharedPreferences.getString("Wednesday", ""));
        thursdayMealEditText.setText(sharedPreferences.getString("Thursday", ""));
        fridayMealEditText.setText(sharedPreferences.getString("Friday", ""));
        saturdayMealEditText.setText(sharedPreferences.getString("Saturday", ""));
        sundayMealEditText.setText(sharedPreferences.getString("Sunday", ""));

        // Save changes button
        Button saveButton = findViewById(R.id.saveButton);
        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putString("Monday", mondayMealEditText.getText().toString());
                editor.putString("Tuesday", tuesdayMealEditText.getText().toString());
                editor.putString("Wednesday", wednesdayMealEditText.getText().toString());
                editor.putString("Thursday", thursdayMealEditText.getText().toString());
                editor.putString("Friday", fridayMealEditText.getText().toString());
                editor.putString("Saturday", saturdayMealEditText.getText().toString());
                editor.putString("Sunday", sundayMealEditText.getText().toString());
                editor.apply();

                // Close the activity
                finish();
            }
        });
    }
}
