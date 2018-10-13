#!/bin/bash
cd `dirname $0`

source ${HOME}/.sdkman/bin/sdkman-init.sh

mvn install:install-file -Dfile=/graalvm/jre/lib/svm/builder/svm.jar \
                           -DgroupId=com.oracle.substratevm \
                           -DartifactId=svm \
                           -Dversion=GraalVM-1.0.0-rc7 \
                           -Dpackaging=jar

gradle assemble

java -cp build/libs/*-all.jar io.micronaut.graal.reflect.GraalClassLoadingAnalyzer

native-image --class-path build/libs/*-all.jar \
			 -H:ReflectionConfigurationFiles=build/reflect.json \
			 -H:EnableURLProtocols=http \
			 -H:IncludeResources="logback.xml|application.yml|META-INF/services/*.*" \
			 -H:Name=build/micronaut-beer-api \
			 -H:Class=micronaut.beer.api.Application \
			 -H:+ReportUnsupportedElementsAtRuntime \
			 -H:+AllowVMInspection \
			 --rerun-class-initialization-at-runtime='sun.security.jca.JCAUtil$CachedSecureRandomHolder,javax.net.ssl.SSLContext' \
			 --delay-class-initialization-to-runtime=io.netty.handler.codec.http.HttpObjectEncoder,io.netty.handler.codec.http.websocketx.WebSocket00FrameEncoder,io.netty.handler.ssl.util.ThreadLocalInsecureRandom