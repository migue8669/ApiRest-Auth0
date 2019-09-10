package co.com.sofka.administracion;

import co.com.sofka.administracion.gateway.VueloRepository;
import lombok.Data;
import org.reactivecommons.utils.ObjectMapper;
import org.reactivecommons.utils.ObjectMapperImp;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
//@Data
@Configuration
public class UseCaseConfig {
    @Bean
    public ObjectMapper objectMapper(){return new ObjectMapperImp();
    }

    @Bean
    public VueloUseCase vueloUseCase (VueloRepository vueloRepository){
        return new VueloUseCase(vueloRepository);
    }
}
