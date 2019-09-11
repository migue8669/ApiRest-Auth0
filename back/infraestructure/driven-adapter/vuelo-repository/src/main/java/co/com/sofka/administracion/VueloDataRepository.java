package co.com.sofka.administracion;


import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Repository
public interface VueloDataRepository extends ReactiveCrudRepository<VueloData, String> {
    Flux<VueloData> findByPasajero(String nameClient);
    Mono<VueloData> findByIdVuelo (String id);
}
