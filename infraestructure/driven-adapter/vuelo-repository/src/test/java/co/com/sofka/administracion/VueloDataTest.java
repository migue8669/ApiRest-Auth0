package co.com.sofka.administracion;

import org.assertj.core.api.Assertions;
import org.junit.Before;
import org.junit.Test;

public class VueloDataTest {
    VueloData vueloData;

    @Before
    public void inicializador() {
        this.vueloData = new VueloData();

    }

    @Test
    public void setterAndGetterTest() {
        this.vueloData.setIdVuelo("01");
        this.vueloData.setPasajero("Jose");
        this.vueloData.setHora("7:00");
        this.vueloData.setFecha("fecha");
        this.vueloData.setDesde("Cartagena");
        this.vueloData.setDestino("Medellin");

        Assertions.assertThat(this.vueloData.getIdVuelo()).isEqualTo("01");
        Assertions.assertThat(this.vueloData.getPasajero()).isEqualTo("Jose");
        Assertions.assertThat(this.vueloData.getHora()).isEqualTo("7:00");
        Assertions.assertThat(this.vueloData.getFecha()).isEqualTo("fecha");
        Assertions.assertThat(this.vueloData.getDesde()).isEqualTo("Cartagena");
        Assertions.assertThat(this.vueloData.getDestino()).isEqualTo("Medellin");





    }
}
