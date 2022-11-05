package FluxPractice.Assignment;

import MonoPractice.util.Util;
import reactor.core.publisher.Flux;

import java.time.Duration;
import java.util.concurrent.atomic.AtomicInteger;

public class StockFilePublisher {

    public static Flux<Integer> getStockValue() {
        AtomicInteger atomicInteger = new AtomicInteger(100);
        return Flux.interval(Duration.ofSeconds(1))
                .map(value -> atomicInteger.getAndAccumulate(
                        Util.FAKER.random().nextInt(-5, 5),
//                        (baseValue, stockChange) -> baseValue + stockChange
                        Integer::sum
                ));
    }
}
