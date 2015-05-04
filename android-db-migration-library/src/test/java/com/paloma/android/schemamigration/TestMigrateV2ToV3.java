package com.paloma.android.schemamigration;

/**
 * Created by kaja on 16/04/2014.
 */
public class TestMigrateV2ToV3 extends TestMigrationBase {

    @Override
    public Migration getPreviousMigration() {
        return null;
    }

    @Override
    public int getToVersion() {
        return 3;
    }

    @Override
    public int getFromVersion() {
        return 2;
    }

}
