# Demo project for Joker 2018 talk about microframeworks
Micronaut VS Spring Boot

## Authors
[Kirill Tolkachev](https://github.com/lavcraft) [@tolkv](https://twitter.com/tolkv) \
and \
[Maxim Gorelikov](https://github.com/gorelikov) [@gorelikoff](https://twitter.com/gorelikoff)

## Slides
[https://speakerdeck.com/lavcraft/spring-boot-vs-micronaut-smallest-framework-battle-number-jokerconf](https://speakerdeck.com/lavcraft/spring-boot-vs-micronaut-smallest-framework-battle-number-jokerconf)

## Step 1
### Description
Step with simple api endpoints by:
* SpringBoot
* Micronaut(groovy/java)
* Spring fu(java/kotlin)
* Spark
### branch
`try-api`
### build
`./cli.sh build` 
### and run
`MEM=256 ./cli.sh runall`
or you could use any of command that presented in cli.sh, but do not forget about `MEM` variable
### try it
If you are using Intellij Idea you can simply call any of the apps by scripts in `http.requests` folder \
If you want to simply load apps you could use `./cli attack PORT_TO_ATTACK`


## Step 1.1 (GraalVM)
### Description
Step with Spring Fu and Micronaut simple API projects built by GraalVM
### branch 
`try-graal`
### build
`./cli.sh graal_build` \
and make make a cup of coffer cause you need to wait for a while

### and run
`./cli.sh graal_mn` to run micronaut built by GraalVM \
`./cli.sh graal_jafu` to run spring fu (Java version) built by GraalVM


## Step 3
### Description
Step with Mongo connectors for:
* SpringBoot(spring-data)
* Micronaut (GORM - Grails)
* Spark (default mongo client)
### branch 
`try-db`
### build
`./cli.sh build`

### and run
`./cli.sh [boot_db, spark_db, mn_db]`

## Step 4
### Description
Step with Cloud (Eureka) dependencies for:
* SpringBoot
* Micronaut
### branch 
`try-cloud`
### build
`./cli.sh build`
### and run
`./cli.sh [boot,mn,mngroovy,boot_db, mn_db]`

## Step 5
### Description
Step with Kafka and Redis dependencies for:
* SpringBoot
* Micronaut
### branch 
`try-mq` \
Yeah, I know that Kafka is not actually MQ. At first it was Rabbit, but it is not supported at the moment %)
### build
`./cli.sh build` 

### and run
`./cli.sh env` to run environment (mongo, kafka, redis)
`spring cloud eureka` to run Eureka
`./cli.sh demo` to run all apps

Now you can try it by
`curl -XGET http://localhost:8083/iwantbeer/someone/1500` - to send the order
`curl -XGET http://localhost:8083/buster` - to check the buster offers