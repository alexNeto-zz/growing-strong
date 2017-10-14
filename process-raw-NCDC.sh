#!/usr/bin/env bash

read offset s3file

echo "reporter:status:Retrieving $s3file" >&2
$HADOOP_HOME/bin/hadoop fs -get $s3file .

target=`basename $s3file .tar.bz2`
mkdir -p $target
echo "report:status:Un-tarring $s3file to $target" >&2
tar jxf `basename $s3file` -C $target

echo "reporter:status:Un-gzipping $target" >&2
for file in $target/*/*
do
	gunzip -c $file >> $target.all
	echo "reporter:status:Processed $file" >&2
done

echo "reporter:status:Gzipping $target and putting in HDFS" >&2
gzip -c $target.all | $HADOOP_HOME/bin/hadoop fs -put - gz/$target.gz
