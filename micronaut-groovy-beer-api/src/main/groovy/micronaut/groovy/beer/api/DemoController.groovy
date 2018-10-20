package micronaut.groovy.beer.api

import io.micronaut.http.HttpResponse
import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Get

@Controller("/")
class DemoController {
    private final BusterService busterService
    private final BarService barService

    DemoController(BusterService busterService, BarService barService) {
        this.busterService = busterService
        this.barService = barService
    }

    //TODO Sorry for that but it is only for demo purpose,
    // you should not use GET method for data modification requests for sure
    @Get("/iwantbeer/{name}/{money}")
    HttpResponse getCompany(String name,
                            String money) {
        try {
            int moneyValue = Integer.parseInt(money)
            if(moneyValue < 1 || moneyValue > 5000) {

            }
            barService.makeOrder(new Order(
                    name: name,
                    money: moneyValue
            ))
            return HttpResponse.ok('Wait for it buddy. :)' +
                    '\n We will find a company and a place for saturday\' s evening.' +
                    '\n Look on the big screen')
        } catch (Exception e) {
            return HttpResponse.ok('Hey! Do you wanna drink or not?\n' +
                    ' Do not use strings, negative numbers or numbers bigger than 5000, please')
        }

    }

    @Get("/buster")
    Buster chooseBuster() {
        return busterService.create()
    }

}
