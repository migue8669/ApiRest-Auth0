package co.com.sofka.administracion.repository.commons.testdata;


import co.com.sofka.administracion.repository.commons.AdapterOperations;
import org.reactivecommons.utils.ObjectMapper;
import org.springframework.stereotype.Repository;


@Repository
public class AdapterRepository extends AdapterOperations<VueloDomain,VueloData,String,RepositoryData> {
    public AdapterRepository(RepositoryData repositoryData, ObjectMapper objectMapper){
        super(repositoryData,objectMapper,d ->objectMapper.mapBuilder(d, VueloDomain.VueloDomainBuilder.class).build());
    }
}
