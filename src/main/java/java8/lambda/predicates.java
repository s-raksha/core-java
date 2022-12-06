package java8.lambda;

import java.time.Period;
import java.util.function.BiPredicate;
import java.util.function.Predicate;

/*
Java 8 provides some in-built functional interfaces in the java.util.function package.
These interfaces are required so that, while writing lambda expressions,
 we don’t need to worry about creating a functional interface.

There are 43 predefined interfaces in Java 8.
1 -> abstract method test
3 -> default and static methods used for chaining And.or,negate
isEqualTo
 */
public class predicates {
    public static void main(String[] args) {
        People people = new People(30,"Raksha");
        Predicate<People> predicate = (p)-> p.age>18;
        //test method
        isPersonEligibleForVoting(people,predicate);

        //usage of and
        Predicate<People> predicateLessThan60 = (p)->p.age<60;
        Predicate<People> predicateMorethan30 = (p)->p.age>30;
        isPersonEligibeToWork(people,predicateMorethan30.and(predicateLessThan60));

        Predicate<People> predicateGraterThan60 = (p)->p.age>60;
        isPersonFitForPlay(people, predicate.or(predicateGraterThan60));

        negatePredicate(people,predicate);

        Predicate<String> peoplePredicate = Predicate.isEqual("Raksha");
        System.out.println(peoplePredicate.test("Raksha"));

        /*
        we are hard coding the voting age in our lambda, e.g., p -> p.getAge() > 18 .
         The voting age, i.e., 18, is hardcoded here. If we want to take this age as input,
         we can use a BiPredicate instead of Predicate.

        In the example shown below, isPersonEligibleForVoting() takes in three parameters.
        Person object, age, and BiPredicate.
         */
        isPersonEligibleForVoting(people, 18,(p,minage)->p.age>minage);
    }

    private static void isPersonEligibleForVoting(People person,Predicate<People> predicate){
        System.out.println(predicate.test(person));
    }

    private static void isPersonEligibeToWork(People people,Predicate<People> predicate){
        System.out.println(predicate.test(people));
    }

    private static void isPersonFitForPlay(People people, Predicate<People> predicate){
        System.out.println(predicate.test(people));
    }

    public static void negatePredicate(People people, Predicate<People> predicate){
        System.out.println(predicate.negate().test(people));
    }
    public static void isPersonEligibleForVoting(People people, int minage, BiPredicate<People,Integer> predicate){
        System.out.println(predicate.test(people,minage));
    }
}
