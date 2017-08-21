#!/bin/bash
for i in {1..500}
do
    YEAR=`jot -r 1  2009 2017`
    URL=http://localhost:8080/movies/$YEAR
    echo $URL
	curl $URL ; echo
done