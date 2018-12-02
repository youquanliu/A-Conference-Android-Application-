package com.example.a101078710.assignment_1_youquanliu_101078710;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.Cursor;

public class DatabaseHelper extends SQLiteOpenHelper {

    private static final String DB_NAME = "Users.db";
    private static final String DB_TABLE = "Contacts";

    //columns
    private static final String ID ="ID";
    private static final String NAME ="NAME";
    private static final String AFIL = "AFIL";
    private static final String EMAIL = "EMAIL";
    private static final String BIO = "BIO";

//    private static final String CREATE_TABLE = "CREATE TABLE "+ DB_TABLE+" ("+
//            ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
//            NAME+ " TEXT "+ ")";

    public DatabaseHelper(Context context){
        super(context, DB_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
    sqLiteDatabase.execSQL("Create Table Contacts "+ "(ID INTEGER PRIMARY KEY AUTOINCREMENT, NAME TEXT, AFIL TEXT, EMAIL TEXT,BIO TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + DB_TABLE);

        onCreate(sqLiteDatabase);
    }

    public boolean insertDB(String Name, String Afil, String Email, String Bio){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put("NAME",Name);
        cv.put("AFIL",Afil);
        cv.put("EMAIL",Email);
        cv.put("BIO",Bio);

        long result = db.insert(DB_TABLE,null,cv);

        return result != -1;

    }

    public Cursor viewData(){
        SQLiteDatabase db = this.getReadableDatabase();
        String query = "Select * from  " + DB_TABLE;
        Cursor cursor = db.rawQuery(query,null);

        return cursor;

    }
    public Cursor viewOneData(String i){
        SQLiteDatabase db = this.getReadableDatabase();
        String query = "Select * from  " + DB_TABLE + " WHERE " + NAME +" = " + "'" + i +"'" ;

        Cursor cursor = db.rawQuery(query,null);

        return cursor;

    }


}
