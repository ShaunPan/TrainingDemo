package com.pan.tranningdemo.database;

import android.provider.BaseColumns;

/*
 * File Name:FeedReaderContract
 * Author:Pan
 * Date:2016/3/3 22:03
 * Description:
 */
public class FeedReaderContract {

    public FeedReaderContract() {
    }

    /**
     * 内部类定义表内容
     */
    public static abstract class FeedEntry implements BaseColumns {
        public static final String TABLE_NAME = "entry";
        public static final String COLUMN_NAME_ENTRY_ID = "entryid";
        public static final String COLUMN_NAME_TITLE = "title";
        public static final String COLUMN_NAME_SUBTITLE = "subtitle";

    }
}
