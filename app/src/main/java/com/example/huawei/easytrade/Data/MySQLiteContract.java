package com.example.huawei.easytrade.Data;

import android.provider.BaseColumns;

/**
 * Created by huawei on 21/10/15.
 */
public class MySQLiteContract {
    /**
     * Table 'Game' structure definition.
     * @author Franklin Welsey
     *
     */
    public static abstract class Game implements BaseColumns {
        public static final String TABLE_NAME = "Game";

        public static final String COLUMN_NAME = "name";
        public static final String COLUMN_DESCRIPTION = "description";
        public static final String COLUMN_PLATFORM = "platform";
        public static final String COLUMN_CATEGORY = "category";
        public static final String COLUMN_PHOTO = "photo";
    }

    private static final String INTEGER_TYPE = " INTEGER";
    private static final String BLOB_TYPE = " BLOB";
    private static final String STRING_TYPE = " TEXT";
    private static final String REAL_TYPE = " REAL";
    private static final String COMMA_SEP = ",";

    /**
     * CREATE TABLE Aluno SQL.
     */
    protected static final String SQL_CREATE_TABLE_GAME =
            "CREATE TABLE " + Game.TABLE_NAME + " (" +
                    Game._ID + " INTEGER PRIMARY KEY" + COMMA_SEP +
                    Game.COLUMN_NAME + STRING_TYPE + COMMA_SEP +
                    Game.COLUMN_DESCRIPTION + STRING_TYPE + COMMA_SEP +
                    Game.COLUMN_PLATFORM + STRING_TYPE + COMMA_SEP +
                    Game.COLUMN_CATEGORY+ STRING_TYPE + COMMA_SEP +
                    Game.COLUMN_PHOTO+ STRING_TYPE + " )";

    /**
     * SQL COUNT
     */
    protected static final String SQL_COUNT_GAME_ENTRIES =
            "SELECT count(*) FROM " + Game.TABLE_NAME;

    /**
     * SQL SELECT ENTRY
     */
    protected static final String SQL_SELECT_GAME_ENTRY =
            "SELECT * FROM " + Game.TABLE_NAME + " WHERE " +
                    Game.COLUMN_NAME + " = ?";

    /**
     * SQL INSERT ENTRY
     */
    protected static final String SQL_INSERT_GAME_ENTRY =
            "INSERT INTO " + Game.TABLE_NAME + " (" +
                    Game.COLUMN_NAME + COMMA_SEP +
                    Game.COLUMN_DESCRIPTION + COMMA_SEP +
                    Game.COLUMN_PLATFORM + COMMA_SEP +
                    Game.COLUMN_CATEGORY + COMMA_SEP +
                    Game.COLUMN_PHOTO + ")" +
                    " VALUES (?,?,?,?,?)";

    /**
     * SQL DELETE ENTRY
     */
    protected static final String SQL_DELETE_GAME_ENTRY =
            "DELETE FROM " + Game.TABLE_NAME + " WHERE " +
                    Game.COLUMN_NAME + " = ?";

    protected static final String SQL_SELECT_GAME =
            "SELECT * FROM " + Game.TABLE_NAME;
}