#!/bin/bash
# This script initiates the Gradle publishing task when pushes to master occur.

if [ "$TRAVIS_REPO_SLUG" == "PalomaMobile/android-db-migration" ] && [ "$TRAVIS_PULL_REQUEST" == "false" ] && [ "$TRAVIS_BRANCH" == "master" ]; then

  if [[ $(gradle -q getVersion) != *SNAPSHOT* ]]; then

    echo -e "Starting to publish release to Sonatype...\n"

      gradle uploadArchives -PnexusUsername="${SONATYPE_USERNAME}" -PnexusPassword="${SONATYPE_PASSWORD}" -Psigning.keyId="${SIGN_KEYID}" -Psigning.password="${SIGN_PASSWORD}" -Psigning.secretKeyRingFile="/home/travis/build/PalomaMobile/android-db-migration/.utility/generated.secring.gpg"
      RETVAL=$?

      if [ $RETVAL -eq 0 ]; then
        echo 'Completed publish!'
      else
        echo 'Publish failed.'
          return 1
      fi

  else

    echo -e "Starting to publish snapshot to Sonatype...\n"

    gradle uploadArchives -PnexusUsername="${SONATYPE_USERNAME}" -PnexusPassword="${SONATYPE_PASSWORD}"
    RETVAL=$?

    if [ $RETVAL -eq 0 ]; then
      echo 'Completed snapshot publish!'
    else
      echo 'Snapshot Publish failed.'
      return 1
    fi

  fi

fi