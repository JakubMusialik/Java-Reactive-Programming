package FluxPractice;

import MonoPractice.util.Util;
import reactor.core.publisher.Flux;

//FLUX RANGE
public class FluxRange {
    public static void main(String[] args) {

        Flux.range(5,10) //as for loop, start = start, count = invocation times
                .subscribe(
                        Util.onNext()
                );

        Util.sleepSeconds(2);

        System.out.println("========================");

        Util.sleepSeconds(2);

        Flux.range(0,7)
                .map(value -> Util.faker().name().fullName())
                .subscribe(
                        Util.onNext(),
                        Util.onError(),
                        Util.onComplete()
                );

    }
}
