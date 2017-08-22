#!/bin/bash
for i in {1..100}
do
    YEAR=$(( $RANDOM % 10 % 6 + 2009 ))
    URL=https://discovery-app-rjl.cfapps.io/topgrossing/${YEAR}
    echo ${URL}
	curl ${URL} ; echo
	SLEEP_INTERVAL=$(( $RANDOM % 10 % 5 ))
	sleep .${SLEEP_INTERVAL}
done