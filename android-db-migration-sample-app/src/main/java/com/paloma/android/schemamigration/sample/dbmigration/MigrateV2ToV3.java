package com.paloma.android.schemamigration.sample.dbmigration;

import android.database.sqlite.SQLiteDatabase;
import android.util.Log;
import com.paloma.android.schemamigration.Migration;
import com.paloma.android.schemamigration.MigrationFailedException;
import com.paloma.android.schemamigration.MigrationImpl;

/**
 * Created by kaja on 4/05/15.
 */
public class MigrateV2ToV3 extends MigrationImpl {

    private static final String TAG = MigrateV2ToV3.class.getSimpleName();

    @Override
    protected void performMigration(SQLiteDatabase db) throws MigrationFailedException {
        //TODO: implement your Migration SQL update statement here
        String sql = null;
        Log.d(TAG, "Migrating from " + getFromVersion() + " to " + getToVersion() + " SQL: " + sql);
        if (sql != null) {
            db.execSQL(sql);
        }
        else {
            Log.w(TAG, "Migration SQL update statement missing.");
        }
    }

    @Override
    public Migration getPreviousMigration() {
        return new MigrateV1ToV2();
    }

    @Override
    public int getFromVersion() {
        return 2;
    }

    @Override
    public int getToVersion() {
        return 3;
    }
}
