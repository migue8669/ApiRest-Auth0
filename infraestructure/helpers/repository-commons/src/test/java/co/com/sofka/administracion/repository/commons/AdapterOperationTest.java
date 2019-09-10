package co.com.sofka.administracion.repository.commons;

import co.com.sofka.administracion.repository.commons.testdata.AdapterRepository;
import co.com.sofka.administracion.repository.commons.testdata.VueloDomain;
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
    private AdapterRepository adapterRepository;

    private final VueloDomain vuelo1 = VueloDomain.builder()
            .idVuelo("04")
            .pasajero("mercedes")
            .desde("medellin")
            .destino("cali")
            .fecha("25/10/2019")
            .hora("16:00").build();

    private final VueloDomain vuelo2 = VueloDomain.builder()
            .idVuelo("05")
            .pasajero("marcela")
            .desde("medellin")
            .destino("cali")
            .fecha("25/10/2019")
            .hora("16:00").build();



@Before
public void setUp(){
    adapterRepository.save(vuelo1);

}

    @Test
    public void testGetByIdVuelo(){
        final Mono<VueloDomain> saved = adapterRepository.save(vuelo1);
        StepVerifier.create(saved).expectNext(vuelo1).verifyComplete();
        StepVerifier.create(adapterRepository.findById("04")).expectNext(vuelo1).verifyComplete();
    }

    @Test
    public void testGetById(){
        final Mono<VueloDomain> saved = adapterRepository.save(vuelo1);
        StepVerifier.create(saved).expectNext(vuelo1).verifyComplete();
     //   StepVerifier.create(saved).expectNext(vuelo2).verifyComplete();

      //  StepVerifier.create(adapterRepository.findById(vuelo2.getIdVuelo())).expectNext(vuelo2).verifyComplete();
        StepVerifier.create(adapterRepository.findById(vuelo1.getIdVuelo())).expectNext(vuelo1).verifyComplete();
    }
}