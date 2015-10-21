package com.example.huawei.easytrade.Data;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.huawei.easytrade.Model.Jogo;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by huawei on 21/10/15.
 */
public class MySQLiteOpenHelper extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION = 1;

    private static final String DATABASE_NAME = "MY_SAMPLE_SQLITE.dbz";

    private SQLiteDatabase mSQLiteDB;

    public MySQLiteOpenHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        mSQLiteDB = this.getWritableDatabase();
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(MySQLiteContract.SQL_CREATE_TABLE_JOGO);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int oldVersion, int newVersion) {

    }


    // PUBLIC API PARA MANIPULAR O BANCO DE DADOS

    public boolean inserirJogo(String nome, String curso) {
        this.getWritableDatabase().execSQL(
                MySQLiteContract.SQL_INSERT_JOGO_ENTRY,
                new Object[] {nome, curso});
        return true;
    }

    public List<Jogo> recuperarJogos() {
        Cursor cursor = this.mSQLiteDB.rawQuery(MySQLiteContract.SQL_SELECT_JOGO, null);
        if(cursor.moveToFirst()) {
            List<Jogo> jogos = new ArrayList<Jogo>();
            do {
                int nomeColumnIndex = cursor.getColumnIndex(MySQLiteContract.Jogo.COLUMN_NOME);
                int descricaoColumnIndex = cursor.getColumnIndex(MySQLiteContract.Jogo.COLUMN_DESCRICAO);
                int plataformaColumnIndex = cursor.getColumnIndex(MySQLiteContract.Jogo.COLUMN_PLATAFORMA);
                int categoriaColumnIndex = cursor.getColumnIndex(MySQLiteContract.Jogo.COLUMN_CATEGORIA);
                int fotoColumnIndex = cursor.getColumnIndex(MySQLiteContract.Jogo.COLUMN_FOTO);

                String nome = cursor.getString(nomeColumnIndex);
                String descricao = cursor.getString(descricaoColumnIndex);
                String plataforma = cursor.getString(plataformaColumnIndex);
                String categoria = cursor.getString(categoriaColumnIndex);
                String foto = cursor.getString(fotoColumnIndex);


                jogos.add(new Jogo(nome,descricao,plataforma,categoria,foto));

            } while (cursor.moveToNext());

            return jogos;
        } else {
            return null;
        }
    }

    public boolean recuperarJogo (String nome) {
        this.getWritableDatabase().execSQL(
                MySQLiteContract.SQL_SELECT_JOGO_ENTRY,
                new Object[] {nome});
        return true;
    }

    public boolean removerJogo (String nome) {
        this.getWritableDatabase().execSQL(
                MySQLiteContract.SQL_DELETE_JOGO_ENTRY,
                new Object[] {nome});
        return true;
    }
}