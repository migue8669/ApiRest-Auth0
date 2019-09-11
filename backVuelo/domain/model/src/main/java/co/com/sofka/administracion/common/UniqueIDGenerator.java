package co.com.sofka.administracion.common;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import reactor.core.publisher.Mono;

import java.util.UUID;

import static reactor.core.publisher.Mono.fromSupplier;



    @NoArgsConstructor(access = AccessLevel.PRIVATE)
    public class UniqueIDGenerator {

        public static Mono<String> uuid(){
            return fromSupplier(() -> UUID.randomUUID().toString().replaceAll("-","").replaceAll("[a-z A-Z]","").substring(0,10));
        }
    }

