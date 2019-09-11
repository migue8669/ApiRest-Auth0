package co.com.sofka.administracion.reactive.repository.common;

import org.reactivecommons.utils.ObjectMapper;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.lang.reflect.ParameterizedType;
import java.util.function.Function;

public abstract class AdapterOperations <E, D, I, R extends ReactiveCrudRepository<D, I>> {

    protected R repo;
    protected ObjectMapper mappers;
    private Class<D> datasClass;
    private Function<D, E> toEntityF;

    @SuppressWarnings("unchecked")
    public AdapterOperations(R repo, ObjectMapper mappers, Function<D, E> toEntityF) {
        this.repo = repo;
        this.mappers = mappers;
        ParameterizedType genericSuperclass = (ParameterizedType) this.getClass().getGenericSuperclass();
        this.datasClass = (Class<D>) genericSuperclass.getActualTypeArguments()[1];
        this.toEntityF = toEntityF;
    }

    public Mono<E> save(E entity) {
        return Mono.just(entity).map(this::toData).flatMap(this::saveData).thenReturn(entity);
    }

    protected Mono<E> doQuery(Mono<D> query) {
        return query.map(this::toEntity);
    }

    public Mono<E> findById(I id) {
        return doQuery(repo.findById(id));
    }

    protected Flux<E> doQueryMany(Flux<D> query) {
        return query.map(this::toEntity);
    }

    protected D toData(E entity) {
        return mappers.map(entity, datasClass);
    }

    protected E toEntity(D data) {
        return toEntityF.apply(data);
    }

    protected Mono<D> saveData(D data) {
        return repo.save(data);
    }
}