package com.paloma.library.schemamigration;

/**
 * Created by kaja on 16/04/2014.
 */
public class FakeMigrateV2ToV3 extends FakeMigrationBase {

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
