package com.paloma.android.schemamigration.sample.dbmigration;

import com.paloma.android.schemamigration.sample.MigratingDBOpenHelper;
import junit.framework.TestCase;

/**
 * Created by kaja on 4/05/15.
 */
public class LatestMigrationTest extends TestCase {

    public void testGetToVersion() throws Exception {
        //will throw MigrationFailedException if the new schema version cannot be handled by the delegate in LatestMigration
        new LatestMigration(MigratingDBOpenHelper.SCHEMA_VERSION);
    }

}
