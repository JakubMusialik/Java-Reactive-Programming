package FluxPractice;

import MonoPractice.util.Util;
import reactor.core.publisher.Flux;

//DIFFERENT SUBSCRIBERS FOR SAME FLUX
public class FluxMultipleSubscribers {
    public static void main(String[] args) {

        Flux<Integer> integerFlux = Flux.just(1, 2, 3, 4, 5);

        integerFlux.filter(number -> number % 2 == 0).subscribe(Util.onNext());

        integerFlux.map(integer -> integer * integer).subscribe(Util.onNext());
    }
}
