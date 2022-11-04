package FluxPractice;

import MonoPractice.util.Util;
import reactor.core.publisher.Flux;

//FLUX BASIC
public class FluxBasic {
    public static void main(String[] args) {

        Flux<Object> integerFlux = Flux.just(1, 2, true, "flux", 12.1);

        integerFlux.subscribe(
                Util.onNext(),
                Util.onError(),
                Util.onComplete()
        );
    }
}
