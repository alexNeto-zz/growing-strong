# How to run
 in a non-hadoop system
 
`cat NCDC-data/input.txt | ./mapReduce-python/mapMaxTemp.py | sort | ./mapReduce-python/reduceMaxTemp.py`