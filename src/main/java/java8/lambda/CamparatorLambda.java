package java8.lambda;

import java.io.PrintStream;
import java.sql.SQLOutput;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/*
If your collection contains a wrapper class object then the sorting is very easy.
Since all the wrapper classes implement the Comparable interface,
 you can directly use Collections.sort() to sort your collection.

However, if your collection contains a custom class object then you need to provide the
logic to sort your object. In this lesson, we will look at an example in which we will sort
a list of Person class objects using a comparator. Then, we will write a program to do the
same task using lambdas.
 */
public class CamparatorLambda {
    public static void main(String[] args) {
        //anonymous class
        List<People> peopleList = Arrays.asList(new People(10, "Raksha"),
                new People(14, "Rahu"), new People(20, "Akash"));
        Collections.sort(peopleList, new Comparator<People>() {
            @Override
            public int compare(People o1, People o2) {
                return o1.name.compareTo(o2.name);
            }
        });
//        peopleList.stream().forEach(System.out::println);
        System.out.println(peopleList);

        //using lambda
        peopleList = Arrays.asList(new People(10, "Raksha"),
                new People(14, "Rahu"), new People(20, "Akash"));
        Collections.sort(peopleList,(o1,o2) -> o1.name.compareTo(o2.name));
        System.out.println(peopleList);
    }
}

class People {
    int age;
    String name;

    public People(int age, String name) {
        this.age = age;
        this.name = name;
    }

    @Override
    public String toString() {
        return "People{" +
                "age=" + age +
                ", name='" + name + '\'' +
                '}';
    }
}
