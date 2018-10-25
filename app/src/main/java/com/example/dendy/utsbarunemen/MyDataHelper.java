package com.example.dendy.utsbarunemen;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class MyDataHelper extends SQLiteOpenHelper {

    //nama database
    private static final String Nama_DB = "novel.db";
    //versi database
    private static  final int VERSI_DB = 1;
    //Nama tabel
    private static final String Nama_TABEL = "buku";

    //Nama Kolom
    private static final String ID = "id";
    private static final String JUDUL = "judul";
    private static final String PENULIS = "penulis";
    private static final String PENERBIT = "penerbit";
    private static final String TAHUNRILIS = "tahunrilis";
    private static final String SINOPSIS = "sinopsis";
    // private static final String HARGA = "harga";
    // private static final String TEMPATRILIS = "temrilis";

    private static final String CREATE_TABLE = "CREATE TABLE "
            + Nama_TABEL +
            "("
            + ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
            + JUDUL + " VARCHAR(255), "
            + PENULIS + " VARCHAR(255), "
            + PENERBIT + " VARCHAR(255), "
            + TAHUNRILIS + " VARCHAR(255), "
            + SINOPSIS + " VARCHAR(255) "
            + ");";

    //sql untuk create table kedua
//    private static final String CREATE_TABLE = "CREATE TABLE1"
//            + Nama_TABEL +
//            "("
//            + ID + "INTEGER PRIMARY KEY AUTOINCREMENT, "
//            + JUDUL + "VARCHAR(255), "
//            + PENULIS + "VARCHAR(255), "
//            + PENERBIT + "VARCHAR(255), "
//            + TAHUNRILIS + "VARCHAR(255), "
//            + SINOPSIS + "VARCHAR(255), "
//            + ");";


    //sql untuk drop table
    private static final String DROP_TABLE = "DROP TABLE IF EXISTS" + Nama_TABEL;

    //konstuktor
    public MyDataHelper(Context context) {
        super(context, Nama_DB, null, VERSI_DB);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVerison) {
        //if(oldVersion < 4){
        //db.execSQL(DROP_TABLE);
        //db.execSQL(Create_Table1);
        //{
    }
}
