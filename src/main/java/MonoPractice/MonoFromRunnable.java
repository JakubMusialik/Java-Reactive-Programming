package MonoPractice;

import MonoPractice.util.Util;
import reactor.core.publisher.Mono;

//MONO FROM RUNNABLE
public class MonoFromRunnable {
    public static void main(String[] args) {


        Mono.fromRunnable(timeConsumingProcess()) //Runnable returns information when consumed
                .subscribe(
                        Util.onNext(),
                        Util.onError(),
                        () -> {
                            System.out.println("Process is done. Doing smth..."); //depends on  timeConsumingProcess method
                        }
                );
    }

    private static Runnable timeConsumingProcess() {
        return () -> {
            Util.sleepSeconds(10);
            System.out.println("Operation completed!");
        };
    }
}
