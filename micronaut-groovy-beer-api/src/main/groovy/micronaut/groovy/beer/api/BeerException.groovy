package micronaut.groovy.beer.api

class BeerException extends RuntimeException {
    BeerException() {
    }

    BeerException(String var1) {
        super(var1)
    }

    BeerException(String var1, Throwable var2) {
        super(var1, var2)
    }

    BeerException(Throwable var1) {
        super(var1)
    }

    BeerException(String var1, Throwable var2, boolean var3, boolean var4) {
        super(var1, var2, var3, var4)
    }
}
