package myGit;

import java.util.Optional;
import java.util.function.BinaryOperator;
import java.util.function.Predicate;

public class HelloLambdas {
	public static void main(String a[]) {
		Runnable noArguments = () -> System.out.println("Hello World");
		noArguments.run();
		
		BinaryOperator<String> plus = (x, y) -> x + y;
		System.out.println(plus.apply("Tia", "go"));
		
		Optional<Integer> boe = Optional.of(10);
		boe.ifPresent(System.out::println);	
		boe.orElse(4);
		
		Predicate<Integer> atLeast5 = x -> x > 5;
		System.out.println(atLeast5.test(6) + "banana");
		
	}
}
