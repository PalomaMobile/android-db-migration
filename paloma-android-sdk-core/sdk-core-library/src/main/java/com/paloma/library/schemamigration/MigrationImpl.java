package com.paloma.library.schemamigration;

import android.database.sqlite.SQLiteDatabase;

/**
 * Created by kaja on 15/04/2014.
 */
public abstract class MigrationImpl implements Migration {

    private void prepareMigration(SQLiteDatabase db, int fromVersion) throws MigrationFailedException {
        if (fromVersion >= getToVersion()) {
            throw new MigrationFailedException("Error migrating DB schema from version " + fromVersion + ": version too high, we can only migrate up to version " + getToVersion());
        }
        if (fromVersion < getFromVersion()) {
            Migration previousMigration = getPreviousMigration();

            if (previousMigration != null) {
                int version = previousMigration.migrate(db, fromVersion);
                if (version != getFromVersion()) {
                    // For all other migrations ensure that after the earlier
                    // migration has been applied the expected version matches
                    throw new MigrationFailedException("Error migrating DB schema version " + version + ", expected migration parent to update DB schema to version " + getFromVersion());
                }
            }
            else {
                throw new MigrationFailedException("Failing to migrate from DB schema version " + fromVersion +": we're only able to migrate DB schemas from version " + getFromVersion());
            }
        }
    }

    @Override
    public int migrate(SQLiteDatabase db, int fromVersion) throws MigrationFailedException {
        prepareMigration(db, fromVersion);
        performMigration(db);
        return getToVersion();
    }

    protected abstract void performMigration(SQLiteDatabase db) throws MigrationFailedException;

}
