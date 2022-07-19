package com.dele.my.project.uievents.operations.db;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import com.dele.my.project.uievents.operations.pojo.Students;
import com.dele.my.project.uievents.operations.utils.AppConstants;
import com.dele.my.project.uievents.operations.utils.Queries;

import java.util.ArrayList;

@SuppressLint("Recycle")
public class DatabaseHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "";

    public DatabaseHelper(@Nullable Context context) {
        super(context, DATABASE_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(Queries.CREATE_STUDENT_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL(Queries.DROP_STUDENTS_TABLE);
    }

}
