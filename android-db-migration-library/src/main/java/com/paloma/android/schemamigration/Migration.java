package com.paloma.android.schemamigration;

import android.database.sqlite.SQLiteDatabase;

public interface Migration {

    int migrate(SQLiteDatabase db, int fromVersion) throws MigrationFailedException;

    Migration getPreviousMigration();

    int getFromVersion();

    int getToVersion();

}
