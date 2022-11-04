package MonoPractice;

import MonoPractice.util.Util;
import reactor.core.publisher.Mono;
import reactor.core.scheduler.Schedulers;

// MONO FROM SUPPLIER
public class MonoFromSupplier {
    public static void main(String[] args) {

        //use when we have data
//        Mono<String> mono = Mono.just(getName());

        getName().subscribe(
                Util.onNext()
        );
        getName().subscribeOn(Schedulers.boundedElastic()) //async
                .subscribe(
                        Util.onNext()
                );
        String block = getName()
                .subscribeOn(Schedulers
                        .boundedElastic())
                .block(); //blocking subscriber

        System.out.println(block);
        Util.sleepSeconds(3);
    }

    private static Mono<String> getName() {
        System.out.println("Entered getName() method..");
        return Mono.fromSupplier(() -> {
            System.out.println("Generating name...");
            Util.sleepSeconds(5);
            return Util.FAKER.name().fullName();
        }).map(String::toUpperCase);
    }
}
