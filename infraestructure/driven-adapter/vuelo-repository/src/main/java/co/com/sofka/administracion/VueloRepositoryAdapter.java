package co.com.sofka.administracion;

//import co.com.sofka.administracion.reactive.repository.common.;
//import co.com.sofka.administracion.reactive.repository.common.Vuelo;

import co.com.sofka.administracion.gateway.VueloRepository;
import co.com.sofka.administracion.reactive.repository.common.AdapterOperations;
import org.reactivecommons.utils.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Repository
public class VueloRepositoryAdapter extends AdapterOperations<Vuelo, VueloData,String, VueloDataRepository>
        implements VueloRepository {

    @Autowired
    public VueloRepositoryAdapter(VueloDataRepository repo, ObjectMapper mapper){
        super(repo,mapper,d->mapper.mapBuilder(d,Vuelo.VueloBuilder.class).build());
    }


    @Override
    public Flux<Vuelo> findAll() {
        return doQueryMany(repo.findAll());
    }

    @Override
    public Mono<Vuelo> findByIdVuelo(String idVuelo) {
        return doQuery(repo.findById(idVuelo));
    }

    @Override
    public Mono<Void> delete(String idVuelo) {
        return repo.deleteById(idVuelo);
    }

    @Override
    public Flux<Vuelo> findByPasajero(String pasajero) {
        return doQueryMany(repo.findByPasajero(pasajero));
    }
}
