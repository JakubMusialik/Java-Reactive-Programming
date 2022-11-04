package FluxPractice;

import MonoPractice.util.Util;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;
import reactor.core.publisher.Flux;

import java.util.concurrent.atomic.AtomicReference;

//FLUX CUSTOM SUBSCRIBER IMPLEMENTATION
public class FluxCustomSubscriberImplementation {
    public static void main(String[] args) {

        AtomicReference<Subscription> atomicReference = new AtomicReference<>();

        Flux.range(1, 20) //publisher
                .log()
                .subscribeWith(new Subscriber<Integer>() { //subscriber
                    @Override
                    public void onSubscribe(Subscription subscription) {
                        System.out.println("Received Sub: " + subscription);
                        atomicReference.set(subscription);
                    }

                    @Override
                    public void onNext(Integer integer) {
                        System.out.println("onNext : " + integer);
                    }

                    @Override
                    public void onError(Throwable throwable) {
                        System.out.println("onError : " + throwable.getMessage());
                    }

                    @Override
                    public void onComplete() {
                        System.out.println("Completed");
                    }
                });

        Util.sleepSeconds(3);
        atomicReference.get().request(3);

        Util.sleepSeconds(3);
        atomicReference.get().request(3);

        Util.sleepSeconds(3);
        System.out.println("Going to cancel subscription");
        atomicReference.get().cancel();

        Util.sleepSeconds(3);
        atomicReference.get().request(4); //subscription got cancelled, same as onComplete or onError
    }
}
