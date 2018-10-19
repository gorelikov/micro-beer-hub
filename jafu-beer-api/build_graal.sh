#!/bin/bash
cd `dirname $0`

rm -rf target/

./../gradlew build

unzip build/libs/*.jar -d target/

docker run -it -v `pwd`:/app findepi/graalvm:1.0.0-rc5-all ./app/build_native.sh