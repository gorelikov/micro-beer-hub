#!/bin/bash
cd `dirname $0`

rm -rf build/

docker run -it -m4g -v `pwd`:/app gorelikov/graalvm-gradle-maven:1.0.0-rc7 ./app/build_native.sh