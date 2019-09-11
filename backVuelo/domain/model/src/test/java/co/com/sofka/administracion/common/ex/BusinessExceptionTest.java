package co.com.sofka.administracion.common.ex;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class BusinessExceptionTest {
    @Test
    public void testBusinessException(){

        final BusinessException ex = BusinessException.Type.INVALID_DT_INITIAL_DATA.build();
        assertThat(ex).hasMessage("blank or null fields are not allowed");
        assertThat(ex.getCode()).isEqualTo("INVALID_DT_INITIAL_DATA");
    }
}
