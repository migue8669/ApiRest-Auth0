package co.com.sofka.administracion;

import org.assertj.core.api.Assertions;

import org.junit.Before;
import org.junit.Test;

public class VueloTest {

    Vuelo vuelo;

    @Before
    public void inicializador() {
        this.vuelo = new Vuelo("01", "Jose", "7:00", "fecha", "Cartagena", "Medellin");
    }

    @Test
    public void setterAndGetterTest() {
        Assertions.assertThat(this.vuelo.getIdVuelo()).isEqualTo("01");
        Assertions.assertThat(this.vuelo.getPasajero()).isEqualTo("Jose");
        Assertions.assertThat(this.vuelo.getHora()).isEqualTo("7:00");
        Assertions.assertThat(this.vuelo.getFecha()).isEqualTo("fecha");
        Assertions.assertThat(this.vuelo.getDesde()).isEqualTo("Cartagena");
        Assertions.assertThat(this.vuelo.getDestino()).isEqualTo("Medellin");





    }
}
