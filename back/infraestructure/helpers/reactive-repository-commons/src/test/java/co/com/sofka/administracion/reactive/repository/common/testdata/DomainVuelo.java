package co.com.sofka.administracion.reactive.repository.common.testdata;

import lombok.Builder;
import lombok.Data;

@Data
@Builder(toBuilder = true)
public class DomainVuelo {
    private final String idVuelo;
    private final String pasajero;
    private final String hora;
    private final String fecha;
    private final String desde;
    private final String destino;
}
