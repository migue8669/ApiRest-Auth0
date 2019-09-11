package co.com.sofka.administracion;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder(toBuilder = true)
@AllArgsConstructor
public class Vuelo {
    private final String idVuelo;
    private final String pasajero;
    private final String hora;
    private final String fecha;
    private final String desde;
    private final String destino;
}
