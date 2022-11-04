package MonoPractice;

import reactor.core.publisher.Mono;

// MONO JUST
public class MonoJust {
    public static void main(String[] args) {

        //publisher
        Mono<Integer> integerMono = Mono.just(1);

        System.out.println(integerMono); //bez subscribe() == bez danych

        integerMono.subscribe(monoValue -> System.out.println("Received value: " + monoValue));

    }
}
