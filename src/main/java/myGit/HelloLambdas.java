package myGit;

import java.util.Optional;
import java.util.function.BinaryOperator;

public class HelloLambdas {
	public static void main(String a[]) {
		Runnable noArguments = () -> System.out.println("Hello World");
		noArguments.run();
		
		BinaryOperator<String> plus = (x, y) -> x + y;
		System.out.println(plus.apply("Tia", "go"));
		
		Optional<Integer> boe = Optional.of(10);
		boe.ifPresent(System.out::println);	
		boe.orElse(4);
		
	}
}
