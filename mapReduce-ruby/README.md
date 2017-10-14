# How to run

Emulate in a non-hadoop system 

`cat NCDC-data/input.txt | ./mapReduce-ruby/mapMaxTemp.rb | sort | ./mapReduce-ruby/reduceMaxTemp.rb`