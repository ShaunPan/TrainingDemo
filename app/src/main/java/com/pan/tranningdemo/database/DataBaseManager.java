package com.pan.tranningdemo.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

/*
 * File Name:DataBaseManager
 * Author:Pan
 * Date:2016/3/3 22:42
 * Description:
 */
public class DataBaseManager {

    private Context mContext;
    private FeedReaderDbHelper mDbHelper;

    public DataBaseManager(Context context) {
        this.mContext = context;
        mDbHelper = new FeedReaderDbHelper(mContext);

        // Gets the data repository in write mode
        SQLiteDatabase db = mDbHelper.getWritableDatabase();
    }

/**
 * 增
 * <p/>
 * 删
 * <p/>
 * 改
 * <p/>
 * 查
 */
    /*public void add() {

        // Create a new map of values, where column names are the keys
        ContentValues values = new ContentValues();
        values.put(FeedReaderContract.FeedEntry.COLUMN_NAME_ENTRY_ID, id);
        values.put(FeedReaderContract.FeedEntry.COLUMN_NAME_TITLE, title);
        values.put(FeedReaderContract.FeedEntry.COLUMN_NAME_CONTENT, content);

        // Insert the new row, returning the primary key value of the new row
//    long newRowId;
        long newRowId = db.insert(
                FeedReaderContract.FeedEntry.TABLE_NAME,
                FeedReaderContract.FeedEntry.COLUMN_NAME_NULLABLE,
                values);
    }*/

/**
 * 删
 */
// Define 'where' part of query.
    /*String selection = FeedReaderContract.FeedEntry.COLUMN_NAME_ENTRY_ID + " LIKE ?";
    // Specify arguments in placeholder order.
    String[] selelectionArgs = { String.valueOf(rowId) };
// Issue SQL statement.
    db.delete(table_name, mySelection, selectionArgs);*/

/**
 * 改
 */
    /*SQLiteDatabase db = mDbHelper.getReadableDatabase();

    // New value for one column
    ContentValues values = new ContentValues();
    values.put(FeedReaderContract.FeedEntry.COLUMN_NAME_TITLE, title);

    // Which row to update, based on the ID
    String selection = FeedReaderContract.FeedEntry.COLUMN_NAME_ENTRY_ID + " LIKE ?";
    String[] selectionArgs = { String.valueOf(rowId) };

    int count = db.update(
            FeedReaderDbHelper.FeedEntry.TABLE_NAME,
            values,
            selection,
            selectionArgs);*/

/**
 * 查
 */
    /*SQLiteDatabase db = mDbHelper.getReadableDatabase();

    // Define a projection that specifies which columns from the database
// you will actually use after this query.
    String[] projection = {
            FeedReaderContract.FeedEntry._ID,
            FeedReaderContract.FeedEntry.COLUMN_NAME_TITLE,
            FeedReaderContract.FeedEntry.COLUMN_NAME_UPDATED,
};

// How you want the results sorted in the resulting Cursor
String sortOrder=
        FeedReaderContract.FeedEntry.COLUMN_NAME_UPDATED+" DESC";
        Cursor c=db.query(
        FeedReaderContract.FeedEntry.TABLE_NAME,  // The table to query
        projection,                               // The columns to return
        selection,                                // The columns for the WHERE clause
        selectionArgs,                            // The values for the WHERE clause
        null,                                     // don't group the rows
        null,                                     // don't filter by row groups
        sortOrder                                 // The sort order
        );
        }

    cursor.moveToFirst();
    long itemId = cursor.getLong(
    cursor.getColumnIndexOrThrow(FeedReaderContract.FeedEntry._ID)
);
        */

}
