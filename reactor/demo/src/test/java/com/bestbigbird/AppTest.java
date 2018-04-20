package com.bestbigbird;

import static org.junit.Assert.assertTrue;

import org.junit.Test;
import reactor.core.publisher.Flux;
import reactor.test.StepVerifier;

/**
 * Unit test for simple App.
 */
public class AppTest {

    @Test
    public void expectNext() {
        Flux.range(1, 10).filter(i -> i % 2 == 0).subscribe(System.out::println);

    }
}
