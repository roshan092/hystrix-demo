#!/bin/bash
for i in {1..500}
do
    YEAR=$(( $RANDOM % 10 % 6 + 2009 ))
    URL=http://localhost:8080/topgrossing/${YEAR}
    echo ${URL}
	curl ${URL} ; echo
	SLEEP_INTERVAL=$(( $RANDOM % 10 % 5 ))
	sleep .${SLEEP_INTERVAL}
done