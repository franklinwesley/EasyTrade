package com.example.huawei.easytrade.Data;

import android.provider.BaseColumns;

/**
 * Created by huawei on 21/10/15.
 */
public class MySQLiteContract {
    /**
     * Table 'Jogo' structure definition.
     * @author Franklin Welsey
     *
     */
    public static abstract class Jogo implements BaseColumns {
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
            "CREATE TABLE " + Jogo.TABLE_NAME + " (" +
                    Jogo._ID + " INTEGER PRIMARY KEY" + COMMA_SEP +
                    Jogo.COLUMN_NAME + STRING_TYPE + COMMA_SEP +
                    Jogo.COLUMN_DESCRIPTION + STRING_TYPE + COMMA_SEP +
                    Jogo.COLUMN_PLATFORM + STRING_TYPE + COMMA_SEP +
                    Jogo.COLUMN_CATEGORY+ STRING_TYPE + COMMA_SEP +
                    Jogo.COLUMN_PHOTO+ STRING_TYPE + " )";

    /**
     * SQL COUNT
     */
    protected static final String SQL_COUNT_GAME_ENTRIES =
            "SELECT count(*) FROM " + Jogo.TABLE_NAME;

    /**
     * SQL SELECT ENTRY
     */
    protected static final String SQL_SELECT_GAME_ENTRY =
            "SELECT * FROM " + Jogo.TABLE_NAME + " WHERE " +
                    Jogo.COLUMN_NAME + " = ?";

    /**
     * SQL INSERT ENTRY
     */
    protected static final String SQL_INSERT_GAME_ENTRY =
            "INSERT INTO " + Jogo.TABLE_NAME + " (" +
                    Jogo.COLUMN_NAME + COMMA_SEP +
                    Jogo.COLUMN_DESCRIPTION + COMMA_SEP +
                    Jogo.COLUMN_PLATFORM + COMMA_SEP +
                    Jogo.COLUMN_CATEGORY + COMMA_SEP +
                    Jogo.COLUMN_PHOTO + ")" +
                    " VALUES (?,?,?,?,?)";

    /**
     * SQL DELETE ENTRY
     */
    protected static final String SQL_DELETE_GAME_ENTRY =
            "DELETE FROM " + Jogo.TABLE_NAME + " WHERE " +
                    Jogo.COLUMN_NAME + " = ?";

    protected static final String SQL_SELECT_GAME =
            "SELECT * FROM " + Jogo.TABLE_NAME;
}
