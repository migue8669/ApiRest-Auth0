package co.com.sofka.administracion.common.ex;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class ApplicationExceptionTest {
    @Test
    public void testApplicationException(){
        ApplicationException exception = new ApplicationException("msj", "code04");
        assertThat(exception).hasMessage("msj");
        assertThat(exception.getCode()).isEqualTo("code04");
    }
}
