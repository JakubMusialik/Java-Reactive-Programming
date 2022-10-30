package MonoPractice;

import java.util.stream.Stream;

// STREAM
public class One {
    public static void main(String[] args) {

        Stream<Integer> stream = Stream.of(1, 2, 3)
                .map(integer -> {
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    return integer * 2;
                });
//        System.out.println(stream); //java.util.stream.ReferencePipeline$3@568db2f2

        stream.forEach(System.out::println);
    }
}
