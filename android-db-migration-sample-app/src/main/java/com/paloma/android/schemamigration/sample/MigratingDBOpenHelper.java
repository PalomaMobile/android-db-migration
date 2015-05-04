package com.paloma.android.schemamigration.sample;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import com.paloma.android.schemamigration.Migration;
import com.paloma.android.schemamigration.MigrationFailedException;
import com.paloma.android.schemamigration.sample.dbmigration.LatestMigration;

/**
 * Created by kaja on 4/05/15.
 */
public class MigratingDBOpenHelper extends SQLiteOpenHelper {
    private static final String TAG = MigratingDBOpenHelper.class.getSimpleName();

    public static final int SCHEMA_VERSION = 3;

    public MigratingDBOpenHelper(Context context, String name, SQLiteDatabase.CursorFactory factory) {
        super(context, name, factory, SCHEMA_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        Log.i(TAG, "Creating tables for schema version " + SCHEMA_VERSION);
        createAllTables(db, false);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        Log.i(TAG, "Upgrading from " + oldVersion + " to " + newVersion);
        try {
            Migration latestMigration = new LatestMigration(SCHEMA_VERSION);
            latestMigration.migrate(db, oldVersion);
        } catch (MigrationFailedException e) {
            Log.e(TAG, "DB schema migration failed, dumping and recreating the DB", e);
            dropAllTables(db, true);
            onCreate(db);
        }
    }


    private static void createAllTables(SQLiteDatabase db, boolean ifNotExists) {
        //TODO ...
    }

    public static void dropAllTables(SQLiteDatabase db, boolean ifExists) {
        //TODO ...
    }
}
