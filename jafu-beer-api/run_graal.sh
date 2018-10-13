#!/bin/bash
cd `dirname $0`

CONTAINER_NAME=jafu_graal

trap "docker rm -f $CONTAINER_NAME" SIGINT

docker run -it --name $CONTAINER_NAME -v `pwd`:/app findepi/graalvm:1.0.0-rc5 ./app/target/app

