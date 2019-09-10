package co.com.sofka.administracion.gateway;

import co.com.sofka.administracion.Vuelo;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface VueloRepository {
    Flux<Vuelo> findAll();

    Mono<Vuelo> findByIdVuelo (String id);

    Mono<Vuelo> save (Vuelo vuelo);

    Mono<Void> delete (String id);

    Flux<Vuelo> findByPasajero (String nameClient);
}
