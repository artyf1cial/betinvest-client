#!/bin/bash
USERNAME=favbet
PASS=favbet228
FILE=schema.sql
DB=client

if [ -z $1 ]; then
	echo "Pass arguments to script:"
	echo "-r   - restore schema from ${FILE}"
	echo "-b   - backup schema with data to ${FILE}"
	echo "-bs  - backup schema only to ${FILE}"
	exit
fi

if [ $1 = '-r' ]; 
	then
	echo "Dropdb ${DB}..."
	PGPASSWORD=$PASS dropdb -U $USERNAME $DB
	echo "Createdb ${DB}..."
	PGPASSWORD=$PASS createdb -U $USERNAME $DB
	echo "Run sql script..."
	PGPASSWORD=$PASS psql -U $USERNAME $DB < $FILE
	echo "Schema was succesfully restored."
fi;

if [ $1 = '-b' ]; 
	then
	echo "Backup db schema of '${DB}' to '${FILE}'"
	PGPASSWORD=$PASS pg_dump -U $USERNAME $DB -f $FILE
	echo "SQL script was succesfully created."
fi;

if [ $1 = '-bs' ]; 
	then
	echo "Backup db schema with data of '${DB}' to '${FILE}'"
	PGPASSWORD=$PASS pg_dump -s -U $USERNAME $DB -f $FILE
	echo "SQL script was succesfully created."
fi;

#if [ $1 = '-e' ];
#	then
#	PGPASSWORD=$PASS psql -U $USERNAME $DB < events.sql
#fi;
#if [ $1 = '-e' ];
#	then
#	PGPASSWORD=$PASS pg_dump -a -t event -U $USERNAME $DB -f events.sql
#fi;