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
MICRONAUT_DB=micronaut-gorm-places-api/build/libs/micronaut-gorm-places-api-*-all.jar
SPRING_DB=spring-places-api/build/libs/spring-places-api-*.jar
SPARK_DB=spark-places-api/build/libs/spark-places-api-*-all.jar

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
  boot_db)
    run_app $SPRING_DB
    ;;
  mn_db)
    run_app $MICRONAUT_DB
    ;;
  spark_db)
    MONGO_URI=mongodb://localhost:27017/places run_app $SPARK_DB
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
  db)
    docker-compose up
    ;;
  db_down)
    docker-compose down
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
  ./vegeta/attack.step0.sh "http://localhost:$2/beer"
  ;;
  attack_db)
  ./vegeta/attack.step1.sh "http://localhost:$2/place"
  ;;
  *)
    echo "use command [mn|mngroovy|boot|spark|kofu|jafu|build|test|killall|runall|attack port|db|db_down]"
  ;;
esac
