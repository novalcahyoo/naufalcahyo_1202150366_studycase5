package com.naufalcahyo.naufalcahyo_1202150366_studycase5;

import android.provider.BaseColumns;

/**
 * Created by NovalCahyo on 3/24/2018.
 */


    //class yang digunakan untuk mendefinisikan skema database

public class MyDatabaseContract {

    public static final class DatabaseScheme implements BaseColumns {
        public static final String TABLE_NAME = "table_name";
        public static final String DATABASE_ID = "ID";
        public static final String NAMA_TODO ="todoname";
        public static final String DESKRIPSI = "description";
        public static final String PRIORITAS = "priority";
    }


}
