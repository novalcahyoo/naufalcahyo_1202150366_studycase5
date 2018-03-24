package com.naufalcahyo.naufalcahyo_1202150366_studycase5;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by NovalCahyo on 3/24/2018.
 */

public class DatabaseHelper extends SQLiteOpenHelper {

    //inisialisasi nama database dan versinyaa
    private static final String DATABASE_NAME = "noval.db";
    private static final int DATABASE_VERSION = 2;
    SQLiteDatabase db;

    public DatabaseHelper(Context context) {
        super(context,DATABASE_NAME,null,DATABASE_VERSION);
        //deklarasi databse yang dapat ditulis/writeable
        db =  getWritableDatabase();

    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        //pembuatan tabel-tabel dalam database berdasarkan skema yang ditentukan
        //di kelas MyDatabaseContract
        db.execSQL("create table "+ MyDatabaseContract.DatabaseScheme.TABLE_NAME + " ( " +
                MyDatabaseContract.DatabaseScheme.DATABASE_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                MyDatabaseContract.DatabaseScheme.NAMA_TODO + " TEXT, " +
                MyDatabaseContract.DatabaseScheme.DESKRIPSI + " TEXT, "+
                MyDatabaseContract.DatabaseScheme.PRIORITAS + " TEXT);"
        );


    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        //meng-drop tabel dengan nama sama jika sudah ada dan memulai membuat baru
        db.execSQL("DROP TABLE IF EXISTS " + MyDatabaseContract.DatabaseScheme.TABLE_NAME);

        onCreate(db);

    }



    public boolean insertData(String todo, String desc, String prio){

        //memasukkan data kedalam tabel yang ada berdasarkan inputan
        ContentValues contentValues = new ContentValues();
        contentValues.put(MyDatabaseContract.DatabaseScheme.NAMA_TODO,todo);
        contentValues.put(MyDatabaseContract.DatabaseScheme.DESKRIPSI,desc);
        contentValues.put(MyDatabaseContract.DatabaseScheme.PRIORITAS,prio);
        //if data is not inserted results will be -1
        long result = db.insert(MyDatabaseContract.DatabaseScheme.TABLE_NAME,null,contentValues);

        return result != -1;
    }




    public Cursor getAllData(){
        db = getWritableDatabase();
        return db.rawQuery("select * from "+MyDatabaseContract.DatabaseScheme.TABLE_NAME,null);

    }



    public boolean deleteDataSwipping(String id){
        return db.delete(MyDatabaseContract.DatabaseScheme.TABLE_NAME, MyDatabaseContract.DatabaseScheme.DATABASE_ID + "=" + id, null) > 0;
    }


}
