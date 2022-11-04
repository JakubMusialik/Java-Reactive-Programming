package MonoPractice;

import MonoPractice.util.Util;
import reactor.core.publisher.Mono;

import java.util.concurrent.Callable;

// MONO FROM CALLABLE
public class MonoFromCallable {
    public static void main(String[] args) {

        Callable<String> stringCallable = () -> getName();

        Mono.fromCallable(stringCallable)
                .subscribe(
                        Util.onNext()
                );

    }

    private static String getName() {
        System.out.println("Generating name...");
        Util.sleepSeconds(10);
        return Util.FAKER.name().fullName();
    }
}
