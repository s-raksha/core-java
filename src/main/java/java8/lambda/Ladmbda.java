package java8.lambda;
/*
A lambda expression is just an anonymous function, i.e.,
 a function with no name and that is not bound to an identifier.
 We can pass it to other methods as parameters, therefore,
 using the power of functional programming in Java.
 */
public class Ladmbda {
    public static void main(String[] args) {
        //using anonymous class
        Greeting greeting = new Greeting() {
            @Override
            public void wish() {
                System.out.println("hello");
            }
        };
        Ladmbda ladmbda = new Ladmbda();
        ladmbda.wish(greeting);

        //Using Lambda
        ladmbda.wish(()-> System.out.printf("hello"));
    }
    private void wish(Greeting greeting){
        greeting.wish();
    }
}
@FunctionalInterface
interface Greeting{
    public void wish();
}
