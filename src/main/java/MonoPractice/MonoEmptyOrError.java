package MonoPractice;

import MonoPractice.util.Util;
import reactor.core.publisher.Mono;

// EMPTY OR ERROR
public class MonoEmptyOrError {
    public static void main(String[] args) {

        userRepositoryFake(15L)
                .subscribe(
                        Util.onNext(),
                        Util.onError(),
                        Util.onComplete());

    }

    private static Mono<String> userRepositoryFake(long userId) {

        if (userId == 1) {
            return Mono.just(Util.FAKER.name().firstName());
        } else if (userId == 2) {
            return Mono.empty(); // null
        } else {
            return Mono.error(new RuntimeException("Range is not allowed!"));
        }
    }
}
