package co.com.sofka.administracion;

import co.com.sofka.administracion.common.ex.BusinessException;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;
import reactor.core.publisher.Mono;

import static reactor.test.StepVerifier.*;


@RunWith(MockitoJUnitRunner.class)
public class VueloFactoryTest {
    private Vuelo vuelo;

    @Before
    public void setVuelo(){
        vuelo = new Vuelo("3","miguel",
                "2:00","12/septiembre/2019",
                "medellin","bogota");
    }

    @Test
    public void VueloTest(){
        Vuelo currentVuelo = vuelo.builder().idVuelo(vuelo.getIdVuelo())
                .pasajero(vuelo.getPasajero())
                .desde(vuelo.getDesde())
                .destino(vuelo.getDestino())
                .fecha(vuelo.getFecha())
                .hora(vuelo.getHora()).build();

        Mono<Vuelo> vueloMono= VueloFactory.create(vuelo.getIdVuelo(),
                vuelo.getPasajero(),
                vuelo.getDesde(),
                vuelo.getDestino(),
                vuelo.getFecha(),
                vuelo.getHora());
        create(vueloMono).expectNext(currentVuelo).verifyComplete();
    }
   // @Test
//    public void shouldFailForEmptyVueloList(){
 //       Vuelo vueloData = vuelo.builder().idVuelo(vuelo.getIdVuelo()).pasajero(vuelo.getPasajero()).desde(vuelo.getDesde()).destino(vuelo.getDestino()).fecha(vuelo.getFecha()).hora(vuelo.getHora()).build();
  //      Mono<Vuelo> vueloMono= VueloFactory.create(vueloData.getIdVuelo(),vueloData.getPasajero(),vueloData.getDesde(),vueloData.getDestino(),vueloData.getHora(),vueloData.getFecha());
   //     create(vueloMono).expectErrorMessage(BusinessException.Type.INVALID_DT_INITIAL_DATA.getMessage()).verify();
   // }
}
