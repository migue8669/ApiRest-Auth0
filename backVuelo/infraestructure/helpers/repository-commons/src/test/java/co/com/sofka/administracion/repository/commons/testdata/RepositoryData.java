package co.com.sofka.administracion.repository.commons.testdata;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
//import org.springframework.data.repository.reactive.ReactiveCrudRepository;

public interface RepositoryData extends CrudRepository<VueloData, String> {
}
