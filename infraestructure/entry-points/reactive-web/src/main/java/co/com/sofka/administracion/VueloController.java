package co.com.sofka.administracion;

import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@CrossOrigin(value = "*")
@RestController
@RequestMapping(value="/vuelo")
public class VueloController {
    private final VueloUseCase vueloUseCase;

    public VueloController(VueloUseCase vueloUseCase) {
        this.vueloUseCase=vueloUseCase;
    }
    @PostMapping(value = "/saveNewVuelo")
    public Mono<Vuelo> createNew(@RequestBody NewVueloData data) {

        return vueloUseCase.save(
                //data.getIdBillClient(),
                data.getPasajero(),
                data.getDesde(),
                data.getDestino(),
                data.getFecha(),
                data.getHora()

        );
    }

    @GetMapping(value = "/getByIdVuelo/{id}")
    public Mono<Vuelo> getByIdBill(@PathVariable("id") String id) {
        return vueloUseCase.findByIdVuelo(id);
    }

    @GetMapping(value = "/allVuelo")
    public Flux<Vuelo> getAll() {
        return vueloUseCase.findAll();
    }

    @GetMapping(value = "/getByNameClient/{nameClient}")
    public Flux<Vuelo> getByName(@PathVariable("nameClient") String nameClient) {
        return vueloUseCase.findByName(nameClient);
    }

    @PutMapping(value = "/updateByIdVuelo/{id}")
    public Mono<Vuelo> updateVuelo(
            @PathVariable("id") String id,
            @RequestBody NewVueloData data) {

        return vueloUseCase.update(
                data.getIdVuelo(),
                data.getPasajero(),
                data.getDesde(),
                data.getDestino(),
                data.getFecha(),
                data.getHora());
    }

    @DeleteMapping(value = "/deleteVueloById/{id}")
    public Mono<Void> delete(@PathVariable("id") String id) {
        return vueloUseCase.deleteById(id);
    }
}
