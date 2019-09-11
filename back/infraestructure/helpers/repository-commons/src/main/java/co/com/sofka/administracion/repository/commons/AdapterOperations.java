package co.com.sofka.administracion.repository.commons;


import org.reactivecommons.utils.ObjectMapper;
import org.springframework.boot.autoconfigure.thymeleaf.ThymeleafProperties;
import org.springframework.data.repository.CrudRepository;

import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.core.scheduler.Schedulers;

import java.lang.reflect.ParameterizedType;
import java.util.function.Function;

import static reactor.core.publisher.Mono.fromSupplier;

public abstract class AdapterOperations <E, D, I, R extends CrudRepository<D, I>>{

    protected R repository;
    protected ObjectMapper mapper;
    private Class<D> dataClass;
    private Function<D, E> toEntityFn;

    @SuppressWarnings("unchecked")
    public AdapterOperations(R repository, ObjectMapper mapper, Function<D, E> toEntityFn) {
        this.repository = repository;
        this.mapper = mapper;
        ParameterizedType genericSuperclass = (ParameterizedType) this.getClass().getGenericSuperclass();
        this.dataClass = (Class<D>) genericSuperclass.getActualTypeArguments()[1];
        this.toEntityFn = toEntityFn;
    }

    public Mono<E> save(E entity) {
        return Mono.just(entity)
                .map(this::toData)
                .flatMap(this::saveData)
                .thenReturn(entity);
    }

    protected Mono<E> doQuery(Mono<D> query) {
        return query.map(this::toEntity);
    }

    public Mono<E> findById(I id) {
        return doQuery(fromSupplier(() -> repository.findById(id)).subscribeOn(Schedulers.elastic()).flatMap(Mono::justOrEmpty));
    }


    protected D toData(E entity) {
        return mapper.map(entity, dataClass);
    }

    protected E toEntity(D data) {
        return toEntityFn.apply(data);
    }

    protected Mono<D> saveData(D data) {
        return fromSupplier(() -> repository.save(data))
                .subscribeOn(Schedulers.elastic());
    }
}
