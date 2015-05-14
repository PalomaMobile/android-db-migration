#!/bin/bash
# This script initiates the Gradle publishing task when pushes to master occur.

if [ "$TRAVIS_REPO_SLUG" == "PalomaMobile/android-db-migration" ] && [ "$TRAVIS_PULL_REQUEST" == "false" ] && [ "$TRAVIS_BRANCH" == "master" ]; then
  if [[ $(gradle -q getVersion) != *SNAPSHOT* ]]; then
      echo 'Travis can only publish snapshots.'
      return 0
  fi

  echo -e "Starting publish to Sonatype...\n"

  gradle uploadArchives -PnexusUsername="${SONATYPE_USERNAME}" -PnexusPassword="${SONATYPE_PASSWORD}"
  RETVAL=$?

  if [ $RETVAL -eq 0 ]; then
    echo 'Completed publish!'
  else
    echo 'Publish failed.'
    return 1
  fi

fi