package com.dele.my.project.uievents.operations.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import androidx.annotation.Nullable;
import com.dele.my.project.uievents.operations.utils.Queries;

public class DatabaseHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "AndroidLearnDb";

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

    protected SQLiteDatabase writer() {
        return this.getWritableDatabase();
    }

    protected SQLiteDatabase reader() {
        return this.getReadableDatabase();
    }

}
