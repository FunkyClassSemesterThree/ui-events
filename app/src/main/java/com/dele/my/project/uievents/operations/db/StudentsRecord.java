package com.dele.my.project.uievents.operations.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import androidx.annotation.Nullable;

import com.dele.my.project.uievents.operations.pojo.Students;
import com.dele.my.project.uievents.operations.utils.AppConstants;
import com.dele.my.project.uievents.operations.utils.Queries;

import java.util.ArrayList;

public class StudentsRecord extends DatabaseHelper {

    public StudentsRecord(@Nullable Context context) {
        super(context);
    }

    public long createStudent(Students students) {
        SQLiteDatabase sqLiteDatabase =  this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("UUID", students.getUuid());
        contentValues.put("FULL_NAME", students.getFullName());
        contentValues.put("EMAIL_ADDRESS", students.getEmailAddress());
        contentValues.put("STUDENT_NO", students.getStudentNo());
        return sqLiteDatabase.insert(AppConstants.STUDENTS_TABLE, null, contentValues);
    }

    public Cursor getStudents(String uuid) {
        SQLiteDatabase sqLiteDatabase = this.getReadableDatabase();
        return sqLiteDatabase.rawQuery(Queries.GET_STUDENTS + " WHERE uuid = ?", new String[]{
                uuid
        });
    }

    public int updateStudent(String uuid, Students students) {
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("FULL_NAME", students.getFullName());
        contentValues.put("EMAIL_ADDRESS", students.getEmailAddress());
        contentValues.put("STUDENT_NO", students.getStudentNo());
        return sqLiteDatabase.update(AppConstants.STUDENTS_TABLE, contentValues, "uuid = ?", new String[]{
                uuid
        });
    }

    public ArrayList<Students> getAllStudents() {
        ArrayList<Students> studentList = new ArrayList<>();
        SQLiteDatabase sqLiteDatabase = this.getReadableDatabase();
        Cursor response = sqLiteDatabase.rawQuery(Queries.GET_STUDENTS, null);
        response.moveToFirst();
        while (!response.isAfterLast()) {
            Students student = new Students();
            student.setUuid(response.getString(0));
            student.setFullName(response.getString(1));
            student.setEmailAddress(response.getString(2));
            student.setStudentNo(response.getString(3));
            studentList.add(student);
            response.moveToNext();
        }
        return studentList;
    }

}
