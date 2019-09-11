package co.com.sofka.administracion.reactive.repository.common.testdata;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.annotation.Id;


@Document
@Data
public class DataVuelo {
    @Id
    private String idVuelo;
    private String pasajero;
    private String hora;
    private String fecha;
    private String desde;
    private String destino;
}
