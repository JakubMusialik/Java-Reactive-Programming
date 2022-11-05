package FluxPractice.Helper;

import MonoPractice.util.Util;
import reactor.core.publisher.Flux;

import java.util.ArrayList;
import java.util.List;

public class NameGenerator {

    public static List<String> getNamesList(int requestedSize) {
        List<String> list = new ArrayList<>(requestedSize);
        for (int i = 0; i < requestedSize; i++) {
            list.add(getName());
        }
        return list;
    }

    private static String getName() {
        System.out.println("Generating random name...");
        Util.sleepSeconds(2);
        return Util.FAKER.name().fullName();
    }

    public static Flux<String> getNamesFlux(int requestedSize) {
        return Flux.range(0,requestedSize)
                .map(index -> getName());
    }
}
