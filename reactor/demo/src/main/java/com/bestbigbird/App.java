package com.bestbigbird;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ){

        List<Integer> list=new ArrayList<Integer>();
        for(int i=0;i<10;i++){
            list.add(i );
        }
        MyPredicate myPredicate = new MyPredicate();
        MyFunction myFunction = new MyFunction();
        MyConsumer myConsumer  = new MyConsumer();

        Stream<Integer> stream=  list.stream();
        Stream<Integer> streamFilter;
        Stream<Integer> streamMap;


        streamFilter = stream.filter(
               /* (s) -> {
                    System.out.println("i am filter");
                    return s < 5;
                }*/
                myPredicate );


        streamMap = streamFilter.map(
                       /* (a) -> {
                            System.out.println("i am map");
                            return   a+1;
                        }*/ myFunction);
        streamMap.forEach(
               /* (a) -> {
                    System.out.println("i am forEach");
                    System.out.println( a);
                }*/ myConsumer);


    }
}

class MyPredicate implements Predicate<Integer> {
    @Override
    public boolean test(Integer o) {
        System.out.println("i am filter");
        return o.intValue() < 5;
    }
}

class MyFunction implements  Function<Integer,Integer>{
    @Override
    public Integer apply(Integer o) {
        System.out.println("i am map");
        return o.intValue()+1;
    }
}

class MyConsumer implements Consumer<Integer> {
    @Override
    public void accept(Integer o) {
        System.out.println("i am forEach");
        System.out.println(o.intValue());
    }
}
