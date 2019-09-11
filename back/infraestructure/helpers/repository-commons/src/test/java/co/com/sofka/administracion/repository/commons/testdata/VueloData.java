package co.com.sofka.administracion.repository.commons.testdata;

import lombok.Data;
//import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.Entity;
import javax.persistence.Id;



@Data
@Entity
public class VueloData {
    @Id
    private  String idVuelo;
    private  String pasajero;
    private  String hora;
    private  String fecha;
    private  String desde;
    private  String destino;
}
