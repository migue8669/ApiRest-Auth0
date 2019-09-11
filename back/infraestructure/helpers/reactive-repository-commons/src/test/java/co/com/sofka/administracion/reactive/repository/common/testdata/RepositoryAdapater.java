package co.com.sofka.administracion.reactive.repository.common.testdata;
import co.com.sofka.administracion.reactive.repository.common.AdapterOperations;
import org.reactivecommons.utils.ObjectMapper;
import org.springframework.stereotype.Repository;

@Repository
public class RepositoryAdapater extends AdapterOperations<DomainVuelo,DataVuelo,String,DataRepository> {
public RepositoryAdapater(DataRepository repo, ObjectMapper mappers){
    super(repo,mappers,d-> {
        return mappers.mapBuilder(d,DomainVuelo.DomainVueloBuilder.class).build();
    });
}
}
