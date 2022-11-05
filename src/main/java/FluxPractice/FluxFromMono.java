package FluxPractice;

import MonoPractice.util.Util;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

//FLUX FROM OTHER PUBLISHERS
public class FluxFromMono {
    public static void main(String[] args) {
        Mono<String> mono = Mono.just("Mono just");

        Flux<String> fluxFromMono = Flux.from(mono);

        fluxFromMono.subscribe(
                Util.onNext()
        );
    }
}
