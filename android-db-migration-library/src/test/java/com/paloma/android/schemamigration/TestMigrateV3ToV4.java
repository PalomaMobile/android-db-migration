package com.paloma.android.schemamigration;

public class TestMigrateV3ToV4 extends TestMigrationBase {

    public Migration getPreviousMigration() {
        return new TestMigrateV2ToV3();
    }

    @Override
    public int getToVersion() {
        return 4;
    }

    @Override
    public int getFromVersion() {
        return 3;
    }

}
