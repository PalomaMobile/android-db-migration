package com.paloma.library.schemamigration;

public class FakeMigrateV3ToV4 extends FakeMigrationBase {

    public Migration getPreviousMigration() {
        return new FakeMigrateV2ToV3();
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
