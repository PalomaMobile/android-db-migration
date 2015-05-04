package com.paloma.android.schemamigration;

import android.database.sqlite.SQLiteDatabase;

/**
 * Created by kaja on 16/04/2014.
 */
public abstract class TestMigrationBase extends MigrationImpl {

    @Override
    protected void performMigration(SQLiteDatabase db) throws MigrationFailedException {
        System.out.println("Migrating from " + getFromVersion() + " to " + getToVersion());
    }

}
