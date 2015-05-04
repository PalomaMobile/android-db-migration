package com.paloma.android.schemamigration.sample.dbmigration;

import android.database.sqlite.SQLiteDatabase;
import com.paloma.android.schemamigration.Migration;
import com.paloma.android.schemamigration.MigrationFailedException;

/**
 * Created by kaja on 4/05/15.
 */
public class LatestMigration implements Migration {

    public LatestMigration(int newSchemaVersion) throws MigrationFailedException {
        if (getToVersion() != newSchemaVersion) {
            throw new MigrationFailedException("Need to update the delegate in " + getClass().getName() + " to an implementation that can update DB schema to version " + newSchemaVersion);
        }
    }

    //TODO: remember to update this field to the latest Migration instance
    private Migration delegate = new MigrateV2ToV3();

    @Override
    public int migrate(SQLiteDatabase db, int fromVersion) throws MigrationFailedException {
        return delegate.migrate(db, fromVersion);
    }

    @Override
    public Migration getPreviousMigration() {
        return delegate.getPreviousMigration();
    }

    @Override
    public int getToVersion() {
        return delegate.getToVersion();
    }

    @Override
    public int getFromVersion() {
        return delegate.getFromVersion();
    }
}
