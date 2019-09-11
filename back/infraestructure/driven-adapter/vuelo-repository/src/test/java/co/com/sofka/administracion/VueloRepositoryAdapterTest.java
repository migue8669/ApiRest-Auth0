package co.com.sofka.administracion;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class VueloRepositoryAdapterTest {
    @Autowired
    private VueloRepositoryAdapter vueloRepositoryAdapter;

         private final Vuelo vuelo3= Vuelo.builder().idVuelo("03")
        .pasajero("romulo").desde("cali").destino("cartagena").hora("15:00").fecha("04/10/2019").build();
         private final Vuelo vuelo4= Vuelo.builder().idVuelo("04")
        .pasajero("remo").desde("bogota").destino("cali").hora("15:00").fecha("04/10/2019").build();


@Before
public void saveInitialData(){
    final Flux<Vuelo> result = Flux.just(
            vueloRepositoryAdapter.save((vuelo3)).block(), vueloRepositoryAdapter.save((vuelo4)).block());
    StepVerifier.create(result).expectNext(vuelo3,vuelo4).verifyComplete();
}

@Test
    public void testGetAllVuelo(){
    StepVerifier.create(vueloRepositoryAdapter.findAll().collectList())
            .assertNext(vuelo -> assertThat(vuelo).contains(vuelo3,vuelo4)).verifyComplete();
}

@Test
    public void testGetByIdVuelo(){
    final Mono<Vuelo> vueloMono = vueloRepositoryAdapter.findByIdVuelo(vuelo3.getIdVuelo());
    StepVerifier.create(vueloMono).assertNext(vuelo -> {
        System.out.println( " --------------- " + vuelo + " ------------ ");
        assertThat(vuelo).isEqualTo(vuelo3);
    }).verifyComplete();

}

@Test
    public void testGetPasajero(){
    final Flux<Vuelo> vueloFlux = vueloRepositoryAdapter.findByPasajero(vuelo3.getPasajero());
    StepVerifier.create(vueloFlux.collectList()).assertNext(vuelo -> assertThat(vuelo).contains(vuelo3) );
}

@Test
    public void testDeleteVuelo(){
    final Mono<Void> mono = vueloRepositoryAdapter.delete(vuelo3.getIdVuelo());
    StepVerifier.create(mono).verifyComplete();
}

}
