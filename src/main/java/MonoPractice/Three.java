package MonoPractice;

import MonoPractice.util.Util;
import reactor.core.publisher.Mono;

// MONO SUBSCRIBE
public class Three {
    public static void main(String[] args) {

        //publisher
        Mono<Integer> stringMono = Mono.just("fancy ball")
                .map(String::length)
                .map(length -> length / 3);

        // 1 bez Consumera
//        stringMono.subscribe();

        // 2
        stringMono.subscribe(
                Util.onNext(),
                Util.onError(),
                Util.onComplete()
        );

        Mono<String> just = Mono.just(Util.faker().app().name())
                .map(String::toUpperCase);

        just.subscribe(
                Util.onNext(),
                Util.onError(),
                Util.onComplete()
        );
    }
}
