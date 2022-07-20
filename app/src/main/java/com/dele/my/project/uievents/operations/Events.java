package com.dele.my.project.uievents.operations;

import android.content.Context;
import android.util.Log;

import com.dele.my.project.uievents.operations.db.StudentsRecord;
import com.dele.my.project.uievents.operations.pojo.Student;
import com.dele.my.project.uievents.operations.utils.AppConstants;
import com.dele.my.project.uievents.operations.utils.Utils;

import java.util.ArrayList;

@SuppressWarnings("unused")
public class Events {

    private final StudentsRecord studentsRecord;

    public Events(Context context) {
        studentsRecord = new StudentsRecord(context);
    }

    public void createStudent() {
        String uuid = Utils.generateRandomString(8);
        Student newStudent = new Student(uuid, "John Winchester - " + uuid, "johndavid@gmail.com " + uuid, "11199 " + uuid);
        long hasInserted = studentsRecord.createStudent(newStudent);
        if (hasInserted >= 1) {
            Log.d(AppConstants.UI_EVENTS_LOG, "createStudent: The record has been inserted");
        }
        else {
            Log.d(AppConstants.UI_EVENTS_LOG, "createStudent: The record was not inserted");
        }
    }

    public void viewStudents() {
        ArrayList<Student> allStudents = studentsRecord.getAllStudents();
        allStudents.forEach(student -> {
            Log.d(AppConstants.UI_EVENTS_LOG, "viewStudents: " + student.toString());
        });
    }

}
