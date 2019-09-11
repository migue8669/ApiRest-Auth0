package co.com.sofka.administracion;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document
public class VueloData {
    @Id
    private  String idVuelo;
    private  String pasajero;
    private  String hora;
    private  String fecha;
    private  String desde;
    private  String destino;
}

