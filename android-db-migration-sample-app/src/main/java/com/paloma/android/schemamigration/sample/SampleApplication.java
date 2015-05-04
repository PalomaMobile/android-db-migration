package com.paloma.android.schemamigration.sample;

import android.app.Application;
import android.database.sqlite.SQLiteDatabase;

/**
 * Created by kaja on 4/05/15.
 */
public class SampleApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();

        MigratingDBOpenHelper migratingDBOpenHelper = new MigratingDBOpenHelper(this, "sample-db", null);
        SQLiteDatabase database = migratingDBOpenHelper.getWritableDatabase();

        //database....
    }

}
