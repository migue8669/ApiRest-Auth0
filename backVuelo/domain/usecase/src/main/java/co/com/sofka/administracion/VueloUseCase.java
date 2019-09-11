package co.com.sofka.administracion;

import co.com.sofka.administracion.gateway.VueloRepository;
import lombok.AllArgsConstructor;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import static co.com.sofka.administracion.common.UniqueIDGenerator.uuid;

@AllArgsConstructor
public class VueloUseCase {

    private final VueloRepository vueloRepository;

    public Mono<Vuelo> save(
            String pasajero,
            String desde,
            String destino,
            String fecha,
            String hora  )
    {
     return uuid().flatMap(idvuelo->
             VueloFactory.create(idvuelo,
                     pasajero,
                     desde,
                     destino,
                     fecha,
                     hora)).flatMap(vueloRepository::save);

    }

    public Mono<Vuelo> update(String idVuelo, String pasajero, String desde, String destino, String hora, String fecha) {
        return vueloRepository.findByIdVuelo(idVuelo).flatMap(vuelo ->
        VueloFactory.create(idVuelo, pasajero, desde, destino, fecha,hora)).flatMap(vueloRepository::save);
    }

    public Flux<Vuelo> findByName(String pasajero) {
        return vueloRepository.findByPasajero(pasajero);
    }

    public Mono<Vuelo> findByIdVuelo(String idVuelo) {
        return vueloRepository.findByIdVuelo(idVuelo);
    }

    public Mono<Void> deleteById(String idVuelo) {
        return vueloRepository.delete(idVuelo);
    }

    public Flux<Vuelo> findAll() {
        return vueloRepository.findAll();
    }
}
