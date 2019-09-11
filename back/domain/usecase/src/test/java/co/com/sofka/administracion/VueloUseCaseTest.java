package co.com.sofka.administracion;

import co.com.sofka.administracion.gateway.VueloRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;


@RunWith(SpringJUnit4ClassRunner.class)

public class VueloUseCaseTest {

    @Mock
    private VueloRepository vueloRepository;

    @InjectMocks
    private VueloUseCase vueloUseCase;

    private Vuelo vuelo = Vuelo.builder()
            .idVuelo("01")
            .pasajero("roman")
            .desde("medellin")
            .destino("bogota")
            .fecha("12/09/2019")
            .hora("14:00")
            .build();

    private Vuelo vuelo1 = Vuelo.builder()
            .idVuelo("02")
            .pasajero("ramon")
            .desde("bogota")
            .destino("medllin")
            .fecha("11/09/2019")
            .hora("11:00")
            .build();
private Flux<Vuelo> fluxVuelo = Flux.just(vuelo,vuelo1);

@Before
    public void setup(){
    when(vueloRepository.save(ArgumentMatchers.any())).thenReturn(Mono.just(vuelo));
    when(vueloRepository.findByIdVuelo(ArgumentMatchers.any())).thenReturn(Mono.just(vuelo));
    when(vueloRepository.findByPasajero(ArgumentMatchers.any())).thenReturn(fluxVuelo);
    when(vueloRepository.findAll()).thenReturn(fluxVuelo);
    when(vueloRepository.delete(ArgumentMatchers.any())).thenReturn(Mono.empty());

}

@Test
    public void testSaveNewVuelo(){

    final Mono<Vuelo> vueloMono=vueloUseCase.save(
            vuelo.getPasajero(),
            vuelo.getDesde(),
            vuelo.getDestino(),
            vuelo.getHora(),
            vuelo.getFecha()

    );
assertEquals(vueloMono.block(),vuelo);
    StepVerifier.create(vueloMono).expectNext(vuelo).verifyComplete();
}

@Test
    public void testUpdate(){
    final Mono<Vuelo> vueloMono = vueloUseCase.update(
            vuelo.getIdVuelo(),
            vuelo.getPasajero(),
            vuelo.getDesde(),
            vuelo.getDestino(),
            vuelo.getHora(),
            vuelo.getFecha()
    );
    assertEquals(vueloMono.block(),vuelo);
    StepVerifier.create(vueloMono).expectNext(vuelo).verifyComplete();
}

@Test
    public void testGetByIdVueloTest(){
    when(vueloRepository.findByIdVuelo(vuelo.getIdVuelo())).thenReturn(Mono.just(vuelo));
    Mono<Vuelo> idvuelo= vueloUseCase.findByIdVuelo(vuelo.getIdVuelo());
    assertEquals(idvuelo.block(),vuelo);
}

@Test
    public void testGetByNameClientTest(){
    when (vueloRepository.findByPasajero(vuelo.getPasajero())).thenReturn(fluxVuelo);
    Flux<Vuelo> pasajero = vueloUseCase.findByName(vuelo.getPasajero());
    assertEquals(pasajero,fluxVuelo);
}

@Test
    public void testDeleteVuelo(){

    vueloUseCase.deleteById(vuelo.getIdVuelo());
    verify(vueloRepository,times(1)).delete(vuelo.getIdVuelo());
}

@Test
    public void testGetAllVuelos(){
    when(vueloUseCase.findAll()).thenReturn(fluxVuelo);
    Flux<Vuelo> allVuelos=vueloUseCase.findAll();
    verify(vueloRepository,times(1)).findAll();
    assertEquals(allVuelos,fluxVuelo);
}


}