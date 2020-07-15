#!/bin/bash

trap 'kill -TERM $child' TERM
nohup java -jar hello-world.jar &

child=$!
echo $$
echo $child
wait $child
