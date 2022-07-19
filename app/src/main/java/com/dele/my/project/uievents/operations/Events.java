package com.dele.my.project.uievents.operations;

import android.content.Context;

import com.dele.my.project.uievents.operations.db.StudentsRecord;
import com.dele.my.project.uievents.operations.pojo.Student;

@SuppressWarnings("unused")
public class Events {

    private final StudentsRecord studentsRecord;

    public Events(Context context) {
        studentsRecord = new StudentsRecord(context);
    }

    public void createStudent(Context context) {
        Student newStudent = new Student("001", "John Winchester", "johndavid@gmail.com", "11199");
        long hasInserted = studentsRecord.createStudent(newStudent);
        if (hasInserted >= 1) {
            System.out.println("The record has been inserted");
        }
        else {
            System.out.println("The record was not inserted");
        }
    }

}
