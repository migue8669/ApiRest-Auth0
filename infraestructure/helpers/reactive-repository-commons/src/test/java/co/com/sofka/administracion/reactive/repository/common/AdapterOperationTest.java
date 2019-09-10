package co.com.sofka.administracion.reactive.repository.common;

import co.com.sofka.administracion.reactive.repository.common.testdata.*;
import co.com.sofka.administracion.reactive.repository.common.testdata.RepositoryAdapater;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class AdapterOperationTest {
    @Autowired
    private RepositoryAdapater repositoryAdapater;

    private final DomainVuelo vuelo = DomainVuelo.builder().
            idVuelo("1")
            .pasajero("remo")
            .desde("medellin")
            .destino("santa marta")
            .fecha("23/septiembre/2019")
            .hora("16:00").build();

    private final DomainVuelo vuelo2 = DomainVuelo.builder().
            idVuelo("2")
            .pasajero("roberto")
            .desde("medellin")
            .destino("santa marta")
            .fecha("23/septiembre/2019")
            .hora("16:00").build();

@Before
    public void setUp(){
    repositoryAdapater.save(vuelo);

}
@Test
    public void testGetById(){
    final Mono<DomainVuelo> saved= repositoryAdapater.save(vuelo);
    StepVerifier.create(saved).expectNext(vuelo).verifyComplete();
    StepVerifier.create(repositoryAdapater.findById(vuelo.getIdVuelo())).expectNext(vuelo).verifyComplete();
}
}
