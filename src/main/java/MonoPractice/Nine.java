package MonoPractice;

import MonoPractice.util.Util;
import reactor.core.publisher.Mono;

//MONO FROM RUNNABLE
public class Nine {
    public static void main(String[] args) {


        Mono.fromRunnable(timeConsumingProcess()) //Runnable zwraca informacje gdy sie wykona
                .subscribe(
                        Util.onNext(),
                        Util.onError(),
                        () -> {
                            System.out.println("Process is done. Doing smth..."); //zalezny od metody timeConsumingProcess
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
