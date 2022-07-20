package com.dele.my.project.uievents;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.dele.my.project.uievents.operations.Events;
import com.dele.my.project.uievents.operations.utils.AppConstants;

public class HomeActivity extends AppCompatActivity {

    private Button addStudentButton, viewStudentButton;
    private Events events;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        setupViews();
        handleAddStudent();
        handleViewStudents();
    }

    private void setupViews() {
        addStudentButton = findViewById(R.id.addStudentBtn);
        viewStudentButton = findViewById(R.id.viewStudentsBtn);
        events = new Events(this);
    }

    private void handleAddStudent() {
        addStudentButton.setOnClickListener(view -> {
            events.createStudent();
            Log.d(AppConstants.UI_EVENTS_LOG, "handleAddStudent: We just handled add student click");
        });
    }

    private void handleViewStudents() {
        viewStudentButton.setOnClickListener(view -> {
            events.viewStudents();
            Log.d(AppConstants.UI_EVENTS_LOG, "handleViewStudents: We just handled view student click");
        });
    }

}