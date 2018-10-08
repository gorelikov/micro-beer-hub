#!/bin/bash

source ./.java.env-current.sh

COMMAND="${1: }"

run_app() {
    java -jar -Dmicro.label $JAVA_OPTS $1
}

MICRONAUT=micronaut-beer-api/build/libs/micronaut-beer-api-*-all.jar
MICRONAUT_GROOVY=micronaut-groovy-beer-api/build/libs/micronaut-groovy-beer-api-*-all.jar
BOOT=spring-beer-api/build/libs/spring-beer-api-*.jar
SPARK=spark-beer-api/build/libs/spark-beer-api-*-all.jar
KOFU=kofu-beer-api/build/libs/kofu-beer-api-*.jar
JAFU=jafu-beer-api/build/libs/jafu-beer-api-*.jar

case "$COMMAND" in
  mn)
    run_app $MICRONAUT
    ;;
  mngroovy)
    run_app $MICRONAUT_GROOVY
    ;;
  boot)
    run_app $BOOT
    ;;
  spark)
    run_app $SPARK
    ;;
  kofu)
    run_app $KOFU
    ;;
  jafu)
    run_app $JAFU
    ;;
  build)
    ./gradlew build -xtest
    ;;
  test)
    ./gradlew clean build
    ;;
  killall)
    kill -9 $(ps aux | grep '[j]ava -jar -Dmicro.label' | awk '{printf $2 " "}')
    ;;
  runall)
    trap "./cli.sh killall" SIGINT
    run_app $MICRONAUT &
    run_app $MICRONAUT_GROOVY &
    run_app $BOOT &
    run_app $SPARK &
    run_app $KOFU &
    run_app $JAFU
    ;;
  attack)
  ./vegeta/attack.step0.sh "http://localhost:$1/beer"
  ;;
  *)
    echo "use command [mn|mngroovy|boot|spark|kofu|jafu|build|test|killall|runall|attack port]"
  ;;
esac
