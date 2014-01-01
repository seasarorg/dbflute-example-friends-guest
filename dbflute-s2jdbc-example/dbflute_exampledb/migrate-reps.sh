#!/bin/bash

cd `dirname $0`
. _project.sh

echo "/nnnnnnnnnnnnnnnnnnnnnnnnnnnnnn"
echo "Execute the MigrateReps task."
echo "nnnnnnnnnn/"
sh $DBFLUTE_HOME/etc/cmd/_df-migrate-reps.sh $MY_PROPERTIES_PATH
taskReturnCode=$?

if [ $taskReturnCode -ne 0 ];then
  exit $taskReturnCode;
fi
