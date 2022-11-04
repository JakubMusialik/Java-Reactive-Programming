package FluxPractice;

import MonoPractice.util.Util;
import reactor.core.publisher.Flux;

import java.util.Arrays;
import java.util.List;

//FLUX ARRAY/LIST
public class FluxFromArrayOrList {
    public static void main(String[] args) {

        List<String> strings = Arrays.asList("a", "b", "c");

        Flux.fromIterable(strings).subscribe(
                Util.onNext(),
                Util.onError(),
                Util.onComplete()
        );

        Integer[] integerArray = {1,2,3,4,5};

        Flux.fromArray(integerArray).subscribe(System.out::println);
    }
}
