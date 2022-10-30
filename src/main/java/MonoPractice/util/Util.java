package MonoPractice.util;

import com.github.javafaker.Faker;
import lombok.SneakyThrows;

import java.util.function.Consumer;

public class Util {

    public static final Faker FAKER = Faker.instance();

    public static Consumer<Object> onNext() {
        return object -> System.out.println("Received : " + object);
    }

    public static Consumer<Throwable> onError() {
        return error -> System.out.println("ERROR : " + error.getMessage());
    }

    public static Runnable onComplete() {
        return () -> System.out.println("Completed");
    }

    public static Faker faker() {
        return FAKER;
    }

    @SneakyThrows
    public static void sleepSeconds(int seconds) {
        Thread.sleep(seconds * 1000);
    }
}
