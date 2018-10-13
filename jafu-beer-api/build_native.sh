#!/bin/bash
cd `dirname $0`

echo `pwd`

native-image --no-server -H:Name=target/app -H:ReflectionConfigurationFiles=graal-netty.json,graal-boot.json,graal-sample.json -Dio.netty.noUnsafe=true -H:+ReportUnsupportedElementsAtRuntime -Dfile.encoding=UTF-8 -cp ".:$(echo target/BOOT-INF/lib/*.jar | tr ' ' ':')":target/BOOT-INF/classes:target  com.example.jafu.beer.api.Application