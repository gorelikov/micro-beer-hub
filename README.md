# Demo project for Joker 2018 talk about microframeworks
Micronaut VS Spring Boot

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
`./cli.sh build` \
### and run
`MEM=256 ./cli.sh runall`
or you could use any of command that presented in cli.sh, but do not forget about `MEM` variable
### try it
If you are using Intellij Idea you can simple call any of the apps by scripts in `http.requests` folder \
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