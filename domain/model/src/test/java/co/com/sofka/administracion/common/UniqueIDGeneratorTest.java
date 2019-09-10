package co.com.sofka.administracion.common;

import org.assertj.core.api.Assertions;
import org.junit.Test;
import reactor.test.StepVerifier;

import static org.assertj.core.api.Assertions.assertThat;

public class UniqueIDGeneratorTest {
    @Test
    public void uuid() {
        StepVerifier.create(UniqueIDGenerator.uuid())
                .assertNext(uuid -> assertThat(uuid).isNotEmpty())
                .verifyComplete();
    }
}
