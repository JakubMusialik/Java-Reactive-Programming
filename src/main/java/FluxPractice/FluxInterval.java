package FluxPractice;

import MonoPractice.util.Util;
import reactor.core.publisher.Flux;

import java.time.Duration;

//FLUX INTERVAL
public class FluxInterval {
    public static void main(String[] args) {

        Flux.interval(Duration.ofSeconds(1)) //nonblocking async way
                .subscribe(
                        Util.onNext()
                );

        Util.sleepSeconds(5); //blocking main thread to see result
    }
}
