#!/bin/bash
for i in {1..500}
do
    YEAR=$(( $RANDOM % 10 + 1998 ))
    URL=http://localhost:9090/topgrossing/${YEAR}
    echo ${URL}
	curl ${URL} ; echo
	SLEEP_INTERVAL=$(( $RANDOM % 10 % 5 ))
	sleep ${SLEEP_INTERVAL}
done