package com.dele.my.project.uievents.operations.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;

import androidx.annotation.Nullable;

import com.dele.my.project.uievents.operations.pojo.Student;
import com.dele.my.project.uievents.operations.utils.AppConstants;
import com.dele.my.project.uievents.operations.utils.Queries;

import java.util.ArrayList;

@SuppressWarnings("unused")
public class StudentsRecord extends DatabaseHelper {

    public StudentsRecord(@Nullable Context context) {
        super(context);
    }

    public long createStudent(Student students) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("UUID", students.getUuid());
        contentValues.put("FULL_NAME", students.getFullName());
        contentValues.put("EMAIL_ADDRESS", students.getEmailAddress());
        contentValues.put("STUDENT_NO", students.getStudentNo());
        return this.writer().insert(AppConstants.STUDENTS_TABLE, null, contentValues);
    }

    public Student getStudents(String uuid) {
        Cursor response = this.reader().rawQuery(Queries.GET_STUDENTS + " WHERE uuid = ?", new String[]{
                uuid
        });
        response.moveToFirst();
        Student student = null;
        while (!response.isAfterLast()) {
            student = new Student(response.getString(0), response.getString(1), response.getString(2), response.getString(3));
            response.moveToNext();
        }
        response.close();
        return student;
    }

    public int updateStudent(String uuid, Student students) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("FULL_NAME", students.getFullName());
        contentValues.put("EMAIL_ADDRESS", students.getEmailAddress());
        contentValues.put("STUDENT_NO", students.getStudentNo());
        return this.writer().update(AppConstants.STUDENTS_TABLE, contentValues, "uuid = ?", new String[]{
                uuid
        });
    }

    public ArrayList<Student> getAllStudents() {
        ArrayList<Student> studentList = new ArrayList<>();
        Cursor response = this.reader().rawQuery(Queries.GET_STUDENTS, null);
        response.moveToFirst();
        while (!response.isAfterLast()) {
            Student student = new Student();
            student.setUuid(response.getString(0));
            student.setFullName(response.getString(1));
            student.setEmailAddress(response.getString(2));
            student.setStudentNo(response.getString(3));
            studentList.add(student);
            response.moveToNext();
        }
        response.close();
        return studentList;
    }

}
