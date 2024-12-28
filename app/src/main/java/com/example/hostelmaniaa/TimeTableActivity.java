package com.example.hostelmaniaa;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Button;
import android.view.View;
import android.content.Intent;
import androidx.appcompat.app.AppCompatActivity;
import java.util.Calendar;

public class TimeTableActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_timetable);

        // Get the current day of the week
        Calendar calendar = Calendar.getInstance();
        int dayOfWeek = calendar.get(Calendar.DAY_OF_WEEK);

        // Find all TextViews for each day
        TextView mondayTextView = findViewById(R.id.mondayTextView);
        TextView mondayMealTextView = findViewById(R.id.mondayMealTextView);
        TextView tuesdayTextView = findViewById(R.id.tuesdayTextView);
        TextView tuesdayMealTextView = findViewById(R.id.tuesdayMealTextView);
        TextView wednesdayTextView = findViewById(R.id.wednesdayTextView);
        TextView wednesdayMealTextView = findViewById(R.id.wednesdayMealTextView);
        TextView thursdayTextView = findViewById(R.id.thursdayTextView);
        TextView thursdayMealTextView = findViewById(R.id.thursdayMealTextView);
        TextView fridayTextView = findViewById(R.id.fridayTextView);
        TextView fridayMealTextView = findViewById(R.id.fridayMealTextView);
        TextView saturdayTextView = findViewById(R.id.saturdayTextView);
        TextView saturdayMealTextView = findViewById(R.id.saturdayMealTextView);
        TextView sundayTextView = findViewById(R.id.sundayTextView);
        TextView sundayMealTextView = findViewById(R.id.sundayMealTextView);

        // Get saved timetable from SharedPreferences
        SharedPreferences sharedPreferences = getSharedPreferences("TimetablePrefs", MODE_PRIVATE);
        mondayMealTextView.setText(sharedPreferences.getString("Monday", "No meals"));
        tuesdayMealTextView.setText(sharedPreferences.getString("Tuesday", "No meals"));
        wednesdayMealTextView.setText(sharedPreferences.getString("Wednesday", "No meals"));
        thursdayMealTextView.setText(sharedPreferences.getString("Thursday", "No meals"));
        fridayMealTextView.setText(sharedPreferences.getString("Friday", "No meals"));
        saturdayMealTextView.setText(sharedPreferences.getString("Saturday", "No meals"));
        sundayMealTextView.setText(sharedPreferences.getString("Sunday", "No meals"));

        // Highlight today's timetable
        switch (dayOfWeek) {
            case Calendar.MONDAY:
                mondayTextView.setTextColor(getResources().getColor(R.color.today_highlight));
                mondayMealTextView.setTextColor(getResources().getColor(R.color.today_highlight));
                break;
            case Calendar.TUESDAY:
                tuesdayTextView.setTextColor(getResources().getColor(R.color.today_highlight));
                tuesdayMealTextView.setTextColor(getResources().getColor(R.color.today_highlight));
                break;
            case Calendar.WEDNESDAY:
                wednesdayTextView.setTextColor(getResources().getColor(R.color.today_highlight));
                wednesdayMealTextView.setTextColor(getResources().getColor(R.color.today_highlight));
                break;
            case Calendar.THURSDAY:
                thursdayTextView.setTextColor(getResources().getColor(R.color.today_highlight));
                thursdayMealTextView.setTextColor(getResources().getColor(R.color.today_highlight));
                break;
            case Calendar.FRIDAY:
                fridayTextView.setTextColor(getResources().getColor(R.color.today_highlight));
                fridayMealTextView.setTextColor(getResources().getColor(R.color.today_highlight));
                break;
            case Calendar.SATURDAY:
                saturdayTextView.setTextColor(getResources().getColor(R.color.today_highlight));
                saturdayMealTextView.setTextColor(getResources().getColor(R.color.today_highlight));
                break;
            case Calendar.SUNDAY:
                sundayTextView.setTextColor(getResources().getColor(R.color.today_highlight));
                sundayMealTextView.setTextColor(getResources().getColor(R.color.today_highlight));
                break;
        }

        // Edit timetable button
        Button editTimetableButton = findViewById(R.id.editTimetableButton);
        editTimetableButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Start EditTimeTableActivity
                Intent intent = new Intent(TimeTableActivity.this, EditTimeTableActivity.class);
                startActivity(intent);
            }
        });
    }
}





//package com.example.hostelmaniaa;
//
//import android.content.SharedPreferences;
//import android.os.Bundle;
//import android.view.View;
//import android.widget.Button;
//import android.widget.EditText;
//import android.widget.TextView;
//import androidx.appcompat.app.AppCompatActivity;
//
//public class TimeTableActivity extends AppCompatActivity {
//
//    private EditText morningMealEditText, afternoonMealEditText, nightMealEditText;
//    private Button saveButton;
//    private TextView timetableTextView;
//    private SharedPreferences sharedPreferences;
//    private static final String PREFS_NAME = "HostelTimeTablePrefs";
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_timetable);
//
//        // Initialize views
//        morningMealEditText = findViewById(R.id.morningMealEditText);
//        afternoonMealEditText = findViewById(R.id.afternoonMealEditText);
//        nightMealEditText = findViewById(R.id.nightMealEditText);
//        saveButton = findViewById(R.id.saveButton);
//        timetableTextView = findViewById(R.id.timetableTextView);
//
//        // SharedPreferences for storing timetable
//        sharedPreferences = getSharedPreferences(PREFS_NAME, MODE_PRIVATE);
//
//        // Load and display today's timetable
//        loadTimetable();
//
//        // Save button action
//        saveButton.setOnClickListener(v -> {
//            saveTimetable();
//        });
//    }
//
//    private void loadTimetable() {
//        // Retrieve saved timetable for today
//        String morning = sharedPreferences.getString("morningMeal", "No meal scheduled");
//        String afternoon = sharedPreferences.getString("afternoonMeal", "No meal scheduled");
//        String night = sharedPreferences.getString("nightMeal", "No meal scheduled");
//
//        // Display the timetable
//        timetableTextView.setText("Today's Food Timetable:\n\nMorning: " + morning + "\nAfternoon: " + afternoon + "\nNight: " + night);
//    }
//
//    private void saveTimetable() {
//        // Get the input from EditTexts
//        String morningMeal = morningMealEditText.getText().toString();
//        String afternoonMeal = afternoonMealEditText.getText().toString();
//        String nightMeal = nightMealEditText.getText().toString();
//
//        // Save the data in SharedPreferences
//        SharedPreferences.Editor editor = sharedPreferences.edit();
//        editor.putString("morningMeal", morningMeal);
//        editor.putString("afternoonMeal", afternoonMeal);
//        editor.putString("nightMeal", nightMeal);
//        editor.apply();
//
//        // Reload the timetable to show the updated meals
//        loadTimetable();
//    }
//}
