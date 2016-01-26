package com.insplore.jun.capturelog.db;

import android.provider.BaseColumns;

import java.sql.Timestamp;

public class EventContract {
    public static final String DB_NAME = "com.insplore.jun.capturelog.db";
    public static final int DB_VERSION = 1;
    public static final String TABLE_NAME = "events";

    public EventContract() {}

    public static class EventEntry implements BaseColumns {
        public static final String _ID = BaseColumns._ID;
        public static final String SESSION = "session";
        public static final String CATEGORY = "category";
        public static final String EVENT_TIME = "event_time";
        public static final String EVENT_TEXT = "event_text";

    }
}
