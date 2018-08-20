package com.bestbigbird;

import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Hooks;
import reactor.core.publisher.Mono;
import reactor.core.scheduler.Scheduler;
import reactor.core.scheduler.Schedulers;
import reactor.test.StepVerifier;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Random;
import java.util.concurrent.TimeUnit;

/**
 * Unit test for simple App.
 */
public class AppTest {

    @Test
    public void flux() {
        //Flux.range(1, 10).filter(i -> i % 2 == 0).subscribe(System.out::println);


      /*  Flux.just("Hello", "World", "H23", "sb", "H")

                .filter(item -> {
                    System.out.println(Thread.currentThread().getName() + "== "+item);
                    return item.startsWith("H");})
                .publishOn(Schedulers. elastic())
                .subscribe( s ->  System.out.println(Thread.currentThread().getName() + " "+s));*/

        Flux.just("a", "b", "c", "d", "e", "f", "g", "h", "i", "j")
                .parallel(2)
                .runOn(Schedulers.elastic())
                .subscribe(s ->  System.out.println(Thread.currentThread().getName() + " "+s));

    }

    @Test
    public void testGenerate(){
        final Random random = new Random();
        Flux.generate(ArrayList::new, (list, sink) -> {
            int value = random.nextInt(100);
            list.add(value);
            sink.next(value);
            if (list.size() == 10) {
                sink.complete();
            }
            return list;
        }).subscribe(System.out::println);
    }

    @Test
    public void testCreate() throws InterruptedException {
        Flux yt=Flux.create(sink -> {
            for (int i = 0; i < 10; i++) {
                sink.next(i);
            }
            sink.complete();
        }).publishOn(Schedulers.elastic());
        yt.subscribe((i)->{
            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + " "+i);
        } );
        yt.subscribe((i)->{
            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + " "+i);
        } );

       TimeUnit.SECONDS.sleep(1000000);
    }

    @Test
    public void testMono(){
        Mono.create(sink -> sink.success("Hello")).subscribe(System.out::println);

    }
}
