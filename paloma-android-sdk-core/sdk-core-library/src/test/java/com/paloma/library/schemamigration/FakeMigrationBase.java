package com.paloma.library.schemamigration;

import android.database.sqlite.SQLiteDatabase;
import com.paloma.library.schemamigration.MigrationFailedException;
import com.paloma.library.schemamigration.MigrationImpl;

/**
 * Created by kaja on 16/04/2014.
 */
public abstract class FakeMigrationBase extends MigrationImpl {

    @Override
    protected void performMigration(SQLiteDatabase db) throws MigrationFailedException {
        System.out.println("Migrating from " + getFromVersion() + " to " + getToVersion());
    }

}
