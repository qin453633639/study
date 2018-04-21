package com.bestbigbird;

import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

import java.time.Duration;

/**
 * Unit test for simple App.
 */
public class AppTest {

    @Test
    public void flux() {
        Flux.range(1, 10).subscribe(new Subscriber<Integer>() {
            @Override
            public void onSubscribe(Subscription s) {
                s.request(10);
            }

            @Override
            public void onNext(Integer integer) {
                System.out.println(integer);
            }

            @Override
            public void onError(Throwable t) {

            }

            @Override
            public void onComplete() {

            }
        });
        //Flux.range(1, 10).filter(i -> i % 2 == 0).subscribe(System.out::println);
        //Flux.just("Hello", "World", "H23", "sb", "H").filter(item -> item.startsWith("H")).take(1).subscribe(System.out::println);
    }

    @Test
    public void mono(){

    }
}
