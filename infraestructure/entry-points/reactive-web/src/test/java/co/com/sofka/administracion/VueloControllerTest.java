package co.com.sofka.administracion;


import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.WebFluxTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.reactive.server.WebTestClient;
import reactor.core.publisher.Mono;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringJUnit4ClassRunner.class)
@WebFluxTest(VueloController.class)
public class VueloControllerTest {
    @Autowired
     private WebTestClient webTestClient;

    @MockBean
    private VueloUseCase vueloUseCase;

    private Vuelo vuelo0= Vuelo.builder()
            .idVuelo("03")
            .pasajero("carmen")
            .desde("medellin")
            .destino("bucaramanga")
            .fecha("22/septiembre/2019")
            .hora("13:00").build();

    private Vuelo vuelo2= Vuelo.builder()
            .idVuelo("04")
            .pasajero("carmenza")
            .desde("medellin")
            .destino("bucaramanga")
            .fecha("22/septiembre/2019")
            .hora("13:00").build();

    @Before
    public void setUp(){
        webTestClient=WebTestClient
                .bindToController(new VueloController(vueloUseCase)).build();
    }

    @Test
    public void testSaveNewVuelo(){
        Mono<Vuelo> vueloMono = Mono.just(vuelo0);
        webTestClient.post().uri("/vuelo/saveNewVuelo")
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON)
                .body(vueloMono,Vuelo.class)
                .exchange()
                .expectStatus().isOk();
    }
    @Test
    public void testUpdateBillById() {

        webTestClient.put()
                .uri("/vuelo/updateByIdVuelo/{id}",vuelo2.getIdVuelo())
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON)
                .body(Mono.just(vuelo2),Vuelo.class)
                .exchange()
                .expectStatus().isOk();
    }

    @Test
    public void testGetAllBills(){

        final WebTestClient.ResponseSpec spec = webTestClient.get().uri("/vuelo/allVuelo").exchange();
        spec.expectBodyList(Vuelo.class).consumeWith(res -> {
            final HttpStatus status = res.getStatus();
            assertThat(status.is2xxSuccessful()).isTrue();
        });
    }

    @Test
    public void testGetIdBill(){
        final WebTestClient.ResponseSpec spec = webTestClient.get().uri("/vuelo/getByIdVuelo/{idVueloClient}",vuelo0.getIdVuelo()).exchange();
        spec.expectBodyList(Vuelo.class).consumeWith(res -> {
            final HttpStatus status = res.getStatus();
            assertThat(status.is2xxSuccessful()).isTrue();
        });

    }
    @Test
    public void testGetNameClient(){
        final WebTestClient.ResponseSpec spec = webTestClient.get().uri("/vuelo/getByNameClient/{nameClient}",vuelo0.getPasajero()).exchange();
        spec.expectBodyList(Vuelo.class).consumeWith(res -> {
            final HttpStatus status = res.getStatus();
            assertThat(status.is2xxSuccessful()).isTrue();
        });
    }

    @Test
    public void testDeleteBill() {
        webTestClient.delete()
                .uri("/vuelo/deleteVueloById/{id}", vuelo0.getIdVuelo())
                .exchange()
                .expectStatus().isOk();
    }
}
