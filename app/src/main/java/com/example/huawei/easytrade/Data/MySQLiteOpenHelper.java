package com.example.huawei.easytrade.Data;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.huawei.easytrade.Model.User;

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
        sqLiteDatabase.execSQL(MySQLiteContract.SQL_CREATE_TABLE_GAME);
        sqLiteDatabase.execSQL(MySQLiteContractUser.SQL_CREATE_TABLE_USER);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int oldVersion, int newVersion) {

    }


    // PUBLIC API PARA MANIPULAR O BANCO DE DADOS

    public boolean inserirJogo(String nome, String curso) {
        this.getWritableDatabase().execSQL(
                MySQLiteContract.SQL_INSERT_GAME_ENTRY,
                new Object[] {nome, curso});
        return true;
    }

    public List<com.example.huawei.easytrade.Model.Game> recuperarJogos() {
        Cursor cursor = this.mSQLiteDB.rawQuery(MySQLiteContract.SQL_SELECT_GAME, null);
        if(cursor.moveToFirst()) {
            List<com.example.huawei.easytrade.Model.Game> games = new ArrayList<com.example.huawei.easytrade.Model.Game>();
            do {
                int nomeColumnIndex = cursor.getColumnIndex(MySQLiteContract.Game.COLUMN_NAME);
                int descricaoColumnIndex = cursor.getColumnIndex(MySQLiteContract.Game.COLUMN_DESCRIPTION);
                int plataformaColumnIndex = cursor.getColumnIndex(MySQLiteContract.Game.COLUMN_PLATFORM);
                int categoriaColumnIndex = cursor.getColumnIndex(MySQLiteContract.Game.COLUMN_CATEGORY);
                int fotoColumnIndex = cursor.getColumnIndex(MySQLiteContract.Game.COLUMN_PHOTO);

                String nome = cursor.getString(nomeColumnIndex);
                String descricao = cursor.getString(descricaoColumnIndex);
                String plataforma = cursor.getString(plataformaColumnIndex);
                String categoria = cursor.getString(categoriaColumnIndex);
                String foto = cursor.getString(fotoColumnIndex);


                games.add(new com.example.huawei.easytrade.Model.Game(nome,descricao,plataforma,categoria,foto));

            } while (cursor.moveToNext());

            return games;
        } else {
            return null;
        }
    }

    public boolean recuperarJogo (String nome) {
        this.getWritableDatabase().execSQL(
                MySQLiteContract.SQL_SELECT_GAME_ENTRY,
                new Object[] {nome});
        return true;
    }

    public boolean removerJogo (String nome) {
        this.getWritableDatabase().execSQL(
                MySQLiteContract.SQL_DELETE_GAME_ENTRY,
                new Object[] {nome});
        return true;
    }

    //// TODO: 23/10/15 Parte do banco de dados do User

    public boolean insertUser(String name, String phone, String email, String login, String password, String photo) {
        this.getWritableDatabase().execSQL(
                MySQLiteContractUser.SQL_INSERT_USER_ENTRY,
                new Object[] {name, phone, email, login, password, photo});
        return true;
    }

    public List<com.example.huawei.easytrade.Model.User> retrievesUsers() {
        Cursor cursor = this.mSQLiteDB.rawQuery(MySQLiteContractUser.SQL_SELECT_USER, null);
        if(cursor.moveToFirst()) {
            List<User> users = new ArrayList<User>();
            do {
                int nameColumnIndex = cursor.getColumnIndex(MySQLiteContract.Game.COLUMN_NAME);
                int phoneColumnIndex = cursor.getColumnIndex(MySQLiteContractUser.User.COLUMN_PHONE);
                int emailColumnIndex = cursor.getColumnIndex(MySQLiteContractUser.User.COLUMN_EMAIL);
                int loginColumnIndex = cursor.getColumnIndex(MySQLiteContractUser.User.COLUMN_LOGIN);
                int passwordColumnIndex = cursor.getColumnIndex(MySQLiteContractUser.User.COLUMN_PASSWORD);
                int photoColumnIndex = cursor.getColumnIndex(MySQLiteContractUser.User.COLUMN_PHOTO);

                String name = cursor.getString(nameColumnIndex);
                String phone = cursor.getString(phoneColumnIndex);
                String email = cursor.getString(emailColumnIndex);
                String login = cursor.getString(loginColumnIndex);
                String password = cursor.getString(passwordColumnIndex);
                String photo = cursor.getString(photoColumnIndex);


                users.add(new User(name,email,phone,login,password,photo));

            } while (cursor.moveToNext());

            return users;
        } else {
            return null;
        }
    }

    public User retrievesUser (String email,String login) {

        List<User> users = retrievesUsers();

        for (User user: users) {
            if (user.getEmail() == email || user.getLogin() == login){
                return user;
            }
        }


        return null;
    }


}