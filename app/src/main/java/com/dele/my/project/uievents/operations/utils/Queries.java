package com.dele.my.project.uievents.operations.utils;

public class Queries {

    public static final String CREATE_STUDENT_TABLE = "CREATE TABLE IF NOT EXISTS "
            + AppConstants.STUDENTS_TABLE + " (UUID TEXT, FULL_NAME TEXT, " +
            "EMAIL_ADDRESS TEXT, STUDENT_NO TEXT)";

    public static final String DROP_STUDENTS_TABLE = "DROP TABLE IF EXISTS "
            + AppConstants.STUDENTS_TABLE;

    public static final String GET_STUDENTS = "SELECT * FROM STUDENTS";

}
