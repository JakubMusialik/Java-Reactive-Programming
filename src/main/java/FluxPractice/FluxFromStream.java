package FluxPractice;

import MonoPractice.util.Util;
import reactor.core.publisher.Flux;

import java.util.List;
import java.util.stream.Stream;

//FLUX FROM STREAM
public class FluxFromStream {
    public static void main(String[] args) {

        List<Integer> integers = List.of(1, 2, 3, 4, 5);

        Stream<Integer> integerStream = integers.stream();

        Flux<Integer> integerFluxWithReference = Flux.fromStream(() -> integerStream); //reference to the same stream
        Flux<Integer> integerFlux = Flux.fromStream(() -> integers.stream()); //supplier of stream

        integerFluxWithReference.subscribe(
                Util.onNext(),
                Util.onError(),
                Util.onComplete()
        );

        integerFluxWithReference.subscribe(
                Util.onNext(),
                Util.onError(),
                Util.onComplete()
        ); //returns error due to reference passed to supplier and consumed by first subscriber


        integerFlux.subscribe(
                Util.onNext(),
                Util.onError(),
                Util.onComplete()
        );

        integerFlux.subscribe(
                Util.onNext(),
                Util.onError(),
                Util.onComplete()
        ); //returns error
    }
}
