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
        public static final String TABLE_NAME = "Jogo";

        public static final String COLUMN_NOME = "nome";
        public static final String COLUMN_DESCRICAO = "descricao";
        public static final String COLUMN_PLATAFORMA = "plataforma";
        public static final String COLUMN_CATEGORIA = "categoria";
        public static final String COLUMN_FOTO = "foto";
    }

    private static final String INTEGER_TYPE = " INTEGER";
    private static final String BLOB_TYPE = " BLOB";
    private static final String STRING_TYPE = " TEXT";
    private static final String REAL_TYPE = " REAL";
    private static final String COMMA_SEP = ",";

    /**
     * CREATE TABLE Aluno SQL.
     */
    protected static final String SQL_CREATE_TABLE_JOGO =
            "CREATE TABLE " + Jogo.TABLE_NAME + " (" +
                    Jogo._ID + " INTEGER PRIMARY KEY" + COMMA_SEP +
                    Jogo.COLUMN_NOME + STRING_TYPE + COMMA_SEP +
                    Jogo.COLUMN_DESCRICAO + STRING_TYPE + COMMA_SEP +
                    Jogo.COLUMN_PLATAFORMA + STRING_TYPE + COMMA_SEP +
                    Jogo.COLUMN_CATEGORIA+ STRING_TYPE + COMMA_SEP +
                    Jogo.COLUMN_FOTO+ STRING_TYPE + " )";

    /**
     * SQL COUNT
     */
    protected static final String SQL_COUNT_JOGO_ENTRIES =
            "SELECT count(*) FROM " + Jogo.TABLE_NAME;

    /**
     * SQL SELECT ENTRY
     */
    protected static final String SQL_SELECT_JOGO_ENTRY =
            "SELECT * FROM " + Jogo.TABLE_NAME + " WHERE " +
                    Jogo.COLUMN_NOME + " = ?";

    /**
     * SQL INSERT ENTRY
     */
    protected static final String SQL_INSERT_JOGO_ENTRY =
            "INSERT INTO " + Jogo.TABLE_NAME + " (" +
                    Jogo.COLUMN_NOME + COMMA_SEP +
                    Jogo.COLUMN_DESCRICAO + COMMA_SEP +
                    Jogo.COLUMN_PLATAFORMA + COMMA_SEP +
                    Jogo.COLUMN_CATEGORIA + COMMA_SEP +
                    Jogo.COLUMN_FOTO + ")" +
                    " VALUES (?,?,?,?)";

    /**
     * SQL DELETE ENTRY
     */
    protected static final String SQL_DELETE_JOGO_ENTRY =
            "DELETE FROM " + Jogo.TABLE_NAME + " WHERE " +
                    Jogo.COLUMN_NOME + " = ?";

    protected static final String SQL_SELECT_JOGO =
            "SELECT * FROM " + Jogo.TABLE_NAME;
}
