package java8.lambda;

import java.util.function.IntSupplier;
import java.util.function.Predicate;
import java.util.function.Supplier;

/*
Supplier is an interface that does not take in any argument but produces a value when the get()
 function is invoked. Suppliers are useful when we don’t need to supply any value and obtain a
 result at the same time.
 */
public class SupplierLambda {
    public static void main(String[] args) {
        Supplier<People> supplier = ()-> new People(12,"Raksha");
        isEligibleForeVote(supplier,(p)-> p.age>18);

        IntSupplier supplier1 = ()-> (int) (Math.random()*10);
        System.out.println(supplier1.getAsInt());
    }

    private static void isEligibleForeVote(Supplier<People> supplier, Predicate<People> predicate){
        System.out.println(predicate.test(supplier.get()));
    }
}
