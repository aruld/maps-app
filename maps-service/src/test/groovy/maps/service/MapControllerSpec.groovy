package maps.service

import io.micronaut.http.HttpRequest
import io.micronaut.http.HttpResponse
import io.micronaut.http.client.RxHttpClient
import io.micronaut.runtime.server.EmbeddedServer
import io.micronaut.test.annotation.MicronautTest
import io.reactivex.Flowable
import maps.common.Compares
import maps.common.DirectionDTO
import maps.common.Directions
import spock.lang.AutoCleanup
import spock.lang.Shared
import spock.lang.Specification

import javax.inject.Inject

@MicronautTest
class MapControllerSpec extends Specification {

    @Inject
    EmbeddedServer embeddedServer

    @Shared
    @AutoCleanup
    RxHttpClient client

    void setup() {
        client = embeddedServer.applicationContext.createBean(RxHttpClient, embeddedServer.getURL())
    }

    void map() {
        given:
        HttpResponse<List<DirectionDTO>> response = client.toBlocking().exchange("/google?src=apple&dest=google", List.class)

        expect:
        !response.body().empty
    }

    void compare() {
        given:
        HttpResponse<Compares> response = client.toBlocking().exchange("/compare?src=apple&dest=google", Compares.class)

        expect:
        !response.body().apple.empty
        !response.body().google.empty
    }

    void shortest() {
        given:
        HttpResponse<Directions> response = client.toBlocking().exchange("/shortest?src=apple&dest=google", Directions.class)

        expect:
        !response.body().directions.empty
        response.body().timeInMinutes == null
        response.body().distanceInMiles.get() == 8.5
    }

    void fastest() {
        given:
        HttpResponse<Directions> response = client.toBlocking().exchange("/fastest?src=apple&dest=google", Directions.class)

        expect:
        !response.body().directions.empty
        response.body().distanceInMiles == null
        response.body().timeInMinutes.get() == 12
    }

    void "test reactive get shortest route"() {
        when:
        Flowable<HttpResponse<Directions>> call = client.exchange(HttpRequest.GET("/shortest?src=google&dest=apple"), Directions.class)

        then:
        HttpResponse<Directions> response = call.blockingFirst()
        Optional<Directions> directions = response.getBody(Directions.class)
        directions.isPresent()
        !directions.get().directions.empty
        directions.get().timeInMinutes == null
        directions.get().distanceInMiles.get() == 9.0
    }

    void "test reactive get fastest route"() {
        when:
        Flowable<HttpResponse<Directions>> call = client.exchange(HttpRequest.GET("/fastest?src=google&dest=apple"), Directions.class)

        then:
        HttpResponse<Directions> response = call.blockingFirst()
        Optional<Directions> directions = response.getBody(Directions.class)
        directions.isPresent()
        !directions.get().directions.empty
        directions.get().distanceInMiles == null
        directions.get().timeInMinutes.get() == 11
    }
}
