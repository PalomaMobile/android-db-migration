package com.paloma.android.schemamigration;

/**
 * Created by kaja on 15/04/2014.
 */
public class MigrationFailedException extends Exception {
    public MigrationFailedException() {
    }

    public MigrationFailedException(String s) {
        super(s);
    }

    public MigrationFailedException(String s, Throwable throwable) {
        super(s, throwable);
    }

    public MigrationFailedException(Throwable throwable) {
        super(throwable);
    }
}
