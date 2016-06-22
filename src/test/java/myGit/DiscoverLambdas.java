package myGit;

import static org.assertj.core.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.lang.Runnable;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.Callable;
import java.util.function.BiFunction;
import java.util.function.BinaryOperator;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.security.*;

import org.junit.Test;
import org.mockito.Mockito;

public class DiscoverLambdas {
	
	@Test
	public void typeOfLambdaExpressionsDependsOnTheContext() {
		NoArgumentFunction<String> f1 = () -> "none";

		PrivilegedAction<String> f2 = () -> "none";

		assertThat(f1.doIt()).isEqualTo("none");
		assertThat(f2.run()).isEqualTo("none");
	}
		
	@Test
	public void andThenIsAppliedAfterFirstFunction() {
		Function<String, String> f1 = (String x) -> x + "a";
		Function<String, String> f2 = f1.andThen(x -> x + "b");
		
		String result = f2.apply("-");
		
		assertThat(result).contains("-ab");
	}
	@Test
	public void composeIsLastFunctionFirst() {
		Function<String, String> f1 =  x -> x + "a";
		Function<String, String> f2 = x -> x + "b";
		
		String result = f1.compose(f2).apply("-");
		
		assertThat(result).contains("-ba");
	}

	
	@Test
	public void forEachAppliesLambaToEachItemInList() {
		OutputDevice mockedOutputDevice = mock(OutputDevice.class);
		List<String> aList = Arrays.asList("Apple", "Organge", "Banana");
				
		aList.forEach( e -> mockedOutputDevice.print(e) );

		Mockito.verify(mockedOutputDevice, times(3)).print(any());
		Mockito.verify(mockedOutputDevice).print("Apple");
		Mockito.verify(mockedOutputDevice).print("Banana");
		Mockito.verify(mockedOutputDevice).print("Organge");
	}
	
	@Test
	public void functionalCompositionMaually() {
		Function<Function<Integer,Integer>, Integer> addOneThenTimesTwo = i -> i.apply(1) * 2;
		
		Integer result = addOneThenTimesTwo.apply( i -> i + 3 );
		
		assertThat(result).isEqualTo(8);

	}
	
	Integer a = 0;
	static public int someFunc(Function<Integer, Integer> f, Integer i) {
		return f.apply(i);
	}

	
	@Test
	public void huh() {
		
		assertThat(someFunc( i -> i + a++, a )).isEqualTo(0);
		assertThat(someFunc( i -> i + a++, a )).isEqualTo(2);
		assertThat(++a).isEqualTo(3);
	}
	
	@Test
	public void lengthAtLeast6() {
		Predicate<Integer> atLeast6 = x -> x > 5;
		
		assertThat(atLeast6.test(6)).isTrue();
	}
	
	@Test
	public void binaryOperatorWithSupport() {
		BinaryOperator<String> plus = (x, y) -> x + y;
		
		assertThat(plus.apply("Tia", "go")).isEqualTo("Tiago");
	}
	
	@Test
	public void binaryFunction() {
		BiFunction<String, String, String> plus = (x, y) -> x + y;
		
		assertThat(plus.apply("Tia", "go")).isEqualTo("Tiago");
	}
	
	@Test
	public void NulableOptionalWithLambdas() {
		Optional<String> o = Optional.ofNullable("");
		Consumer mock = mock(Consumer.class);
		
		o.ifPresent( mock );
		
		Mockito.verify(mock, times(1)).accept(any());		
		assertThat(o.isPresent()).isTrue();
		assertThat(o.orElseGet(() -> { /*some factory*/ return "Default";})).isEqualTo("");
		assertThat(o.orElse("Default")).isEqualTo("");
		
	}
	
	@Test
	public void EmptyOptionalWithLambdas() {
		Optional<String> o = Optional.empty();
		Consumer mock = mock(Consumer.class);
		
		o.ifPresent( mock );
		
		Mockito.verify(mock, times(0)).accept(any());
		assertThat(o.isPresent()).isFalse();
		assertThat(o.orElseGet(() -> { /*some factory*/ return "Default";})).isEqualTo("Default");
		assertThat(o.orElse("Default")).isEqualTo("Default");
	}

	
}