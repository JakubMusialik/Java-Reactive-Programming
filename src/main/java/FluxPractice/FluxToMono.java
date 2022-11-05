package FluxPractice;

import MonoPractice.util.Util;
import reactor.core.publisher.Flux;

//CONVERTING FLUX TO MONO
public class FluxToMono {
    public static void main(String[] args) {

        Flux.range(1,10)
                .filter(value -> value > 3) //filtering to get certain value
                .next() // first item goes through and closes the operation -> converts flux to mono
                .subscribe(
                        Util.onNext(),
                        Util.onError(),
                        Util.onComplete()
                );

        Flux.range(1,10)
                .next() // first item goes through and closes the operation
                .filter(value -> value > 3) // we get empty mono as the filtering is not succeeded
                .subscribe(
                        Util.onNext(),
                        Util.onError(),
                        Util.onComplete()
                );
    }
}
