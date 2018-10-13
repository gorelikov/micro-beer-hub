#!/bin/bash
cd `dirname $0`

CONTAINER_NAME=mn_graal

trap "docker rm -f $CONTAINER_NAME" SIGINT

docker run -it --name $CONTAINER_NAME -v `pwd`:/app findepi/graalvm:1.0.0-rc7 ./app/build/micronaut-beer-api

