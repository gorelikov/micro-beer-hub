#!/bin/bash


./cli.sh mn &
sleep 5
echo '==================mn===================' > load.txt
./cli.sh attack 8082 >> load.txt
./cli.sh killall

./cli.sh mngroovy &
sleep 5
echo '==================mngroovy===================' >> load.txt
./cli.sh attack 8083 >> load.txt
./cli.sh killall

./cli.sh boot &
sleep 5
echo '==================boot===================' >> load.txt
./cli.sh attack 8081 >> load.txt
./cli.sh killall

./cli.sh spark &
sleep 5
echo '==================spark===================' >> load.txt
./cli.sh attack 4567 >> load.txt
./cli.sh killall

./cli.sh kofu &
sleep 5
echo '==================kofu===================' >> load.txt
./cli.sh attack 8084 >> load.txt
./cli.sh killall

./cli.sh jafu &
sleep 5
echo '==================jafu===================' >> load.txt
./cli.sh attack 8080 >> load.txt
./cli.sh killall\