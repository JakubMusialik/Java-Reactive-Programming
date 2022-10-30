package MonoPractice;

import MonoPractice.util.Util;
import reactor.core.publisher.Mono;

import java.util.concurrent.CompletableFuture;

// MONO FROM FUTURE
public class Eight {
    public static void main(String[] args) {
        Mono.fromFuture(Eight::getName)
                .subscribe(
                        Util.onNext()
                );

        Util.sleepSeconds(1);

    }

    private static CompletableFuture<String> getName() {
        return CompletableFuture.supplyAsync(() -> Util.FAKER.name().fullName());
    }
}
