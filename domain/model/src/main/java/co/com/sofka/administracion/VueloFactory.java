package co.com.sofka.administracion;


import co.com.sofka.administracion.common.StringUtils;
import co.com.sofka.administracion.common.ex.BusinessException;
import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;
import reactor.core.publisher.Mono;




@Data
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class VueloFactory {
    public static Mono<Vuelo> create (
            String idVuelo,
            String pasajero,
            String desde,
            String destino,
            String fecha,
            String hora) {
        return StringUtils.isEmpty(idVuelo,
                pasajero,
                desde,
                destino,
                fecha,
                hora)
                ? Mono.error(BusinessException.Type.INVALID_DT_INITIAL_DATA.build())
                :Mono.just(Vuelo.builder().idVuelo(idVuelo)
                .pasajero(pasajero)
                .desde(desde)
                .destino(destino)
                .fecha(fecha)
                .hora(hora).build());
    }
}
