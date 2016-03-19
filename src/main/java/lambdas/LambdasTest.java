package lambdas;

import java.util.*;

public class LambdasTest {

    public static void main(String[] args) {

        Runnable r = () -> System.out.println("Hi");
        r.run();

        List<Person> p1 = new ArrayList<>();
        p1.add(new Person(1, "Bill"));
        p1.add(new Person(2, "Will"));
        p1.add(new Person(3, "Jill"));

        Collections.sort(p1, (pA, pB) -> pB.getName().compareTo(pA.getName()));

        p1.forEach(System.out::println);



    }

}
