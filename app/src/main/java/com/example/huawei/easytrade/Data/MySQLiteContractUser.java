package com.example.huawei.easytrade.Data;

import android.provider.BaseColumns;

/**
 * Created by huawei on 23/10/15.
 */
public class MySQLiteContractUser {

    public static abstract class User implements BaseColumns {
        public static final String TABLE_NAME = "User";

        public static final String COLUMN_NAME = "name";
        public static final String COLUMN_PHONE = "phone";
        public static final String COLUMN_EMAIL = "email";
        public static final String COLUMN_LOGIN = "login";
        public static final String COLUMN_PASSWORD = "password";
        public static final String COLUMN_PHOTO = "photo";
    }

    private static final String INTEGER_TYPE = " INTEGER";
    private static final String BLOB_TYPE = " BLOB";
    private static final String STRING_TYPE = " TEXT";
    private static final String REAL_TYPE = " REAL";
    private static final String COMMA_SEP = ",";

    /**
     * CREATE TABLE User SQL.
     */
    protected static final String SQL_CREATE_TABLE_USER =
            "CREATE TABLE " + User.TABLE_NAME + " (" +
                    User._ID + " INTEGER PRIMARY KEY" + COMMA_SEP +
                    User.COLUMN_NAME + STRING_TYPE + COMMA_SEP +
                    User.COLUMN_PHONE + STRING_TYPE + COMMA_SEP +
                    User.COLUMN_EMAIL + STRING_TYPE + COMMA_SEP +
                    User.COLUMN_LOGIN + STRING_TYPE + COMMA_SEP +
                    User.COLUMN_PASSWORD + STRING_TYPE + COMMA_SEP +
                    User.COLUMN_PHOTO+ STRING_TYPE + " )";

    /**
     * SQL COUNT
     */
    protected static final String SQL_COUNT_USER_ENTRIES =
            "SELECT count(*) FROM " + User.TABLE_NAME;

    /**
     * SQL SELECT ENTRY
     */
    protected static final String SQL_SELECT_USER_ENTRY =
            "SELECT * FROM " + User.TABLE_NAME + " WHERE " +
                    User.COLUMN_NAME + " = ?";

    /**
     * SQL INSERT ENTRY
     */
    protected static final String SQL_INSERT_USER_ENTRY =
            "INSERT INTO " + User.TABLE_NAME + " (" +
                    User.COLUMN_NAME + COMMA_SEP +
                    User.COLUMN_PHONE + COMMA_SEP +
                    User.COLUMN_EMAIL + COMMA_SEP +
                    User.COLUMN_LOGIN + COMMA_SEP +
                    User.COLUMN_PHOTO + ")" +
                    " VALUES (?,?,?,?,?)";

    /**
     * SQL DELETE ENTRY
     */
    protected static final String SQL_DELETE_USER_ENTRY =
            "DELETE FROM " + User.TABLE_NAME + " WHERE " +
                    User.COLUMN_NAME + " = ?";

    protected static final String SQL_SELECT_USER =
            "SELECT * FROM " + User.TABLE_NAME;

}
