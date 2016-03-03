package com.pan.tranningdemo.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/*
 * File Name:FeedReaderDbHelper
 * Author:Pan
 * Date:2016/3/3 22:15
 * Description:
 */
public class FeedReaderDbHelper extends SQLiteOpenHelper {

    private static final String TEXT_TYPE = " TEXT";
    private static final String COMMA_SEP = ",";
    private static final String SQL_CREATE_ENTRIES = "CREATE TABLE " + FeedReaderContract.FeedEntry.TABLE_NAME +
            "(" + FeedReaderContract.FeedEntry._ID + "INTEGER PRIMARY KEY," +
            FeedReaderContract.FeedEntry.COLUMN_NAME_ENTRY_ID + TEXT_TYPE + COMMA_SEP +
            FeedReaderContract.FeedEntry.COLUMN_NAME_TITLE + TEXT_TYPE + COMMA_SEP + ")";

    private static final String SQL_DELETE_ENTRIES="DROP TABLE IF EXISTS"+ FeedReaderContract.FeedEntry.TABLE_NAME;

    //如果修改了schema，则自增数据库的版本号
    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "FeedReader.db";

    public FeedReaderDbHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(SQL_CREATE_ENTRIES);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        //更新前，先删掉以前的数据库
        db.execSQL(SQL_DELETE_ENTRIES);
        //重新创建数据库
        onCreate(db);
    }

    @Override
    public void onDowngrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        onUpgrade(db,oldVersion,newVersion);
    }


}
