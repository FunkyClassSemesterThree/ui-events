package com.dele.my.project.uievents.operations;

import android.content.Context;

import com.dele.my.project.uievents.operations.db.DatabaseHelper;
import com.dele.my.project.uievents.operations.pojo.Students;

public class Events {

    private final DatabaseHelper dbHelper;

    public Events(Context context) {
        dbHelper = new DatabaseHelper(context);
    }

    public void createStudent(Context context) {
        Students newStudent = new Students("001", "John Winchester", "johndavid@gmail.com", "11199");
//        long hasInserted = dbHelper.createStudent(newStudent);
//        if (hasInserted >= 1) {
//            System.out.println("The record has been inserted");
//        }
//        else {
//            System.out.println("The record was not inserted");
//        }
    }

}
