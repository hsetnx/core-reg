#!/bin/sh
nohup java -jar apps/core-reg.jar --spring.profiles.active=$1 > /dev/null 2>&1 &
echo 'pid：  '$!
echo Start Success!!!