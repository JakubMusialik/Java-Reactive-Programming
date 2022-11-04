package FluxPractice;

import MonoPractice.util.Util;
import reactor.core.publisher.Flux;

//FLUX LOG
public class FluxLog {
    public static void main(String[] args) {

        Flux.range(5, 10)  //publisher
                .log()
//                [INFO] (main) | onSubscribe([Synchronous Fuseable]FluxRange.RangeSubscription)
//                [INFO](main) | request(unbounded) --> all data to be handled
//                [INFO] (main) | onNext(5) --> starting position
                .map(value -> Util.faker().ancient().god()) //subscriber
                .log() //invokes Util.onNext() [ INFO] (main) | onNext(Apollo)
                .subscribe(
                        Util.onNext()
                );
    }
}
