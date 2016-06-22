package exploreJava8;

import static org.assertj.core.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.util.Arrays;
import java.util.List;
import java.util.OptionalDouble;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.security.*;

import org.junit.Test;
import org.mockito.Mockito;


public class DiscoverStreams {

	@Test
	public void calculatesTheAverage() {
		List<Integer> numbers = Arrays.asList(1,2,3,4,5,6,7,8,9);
		
		OptionalDouble result = numbers.stream().mapToDouble(i -> i).average();
		
		assertThat(result.orElse(0.0)).isEqualTo(5.0);
	}
	
	@Test
	public void sumAllNumbers() {
		List<Integer> numbers = Arrays.asList(1,2,3,4,5,6,7,8,9);
		
		assertThat(numbers.stream().mapToInt(i->i).sum()).isEqualTo(45);
	}
	
	@Test
	public void filterForItemsSmallerThen4() {
		List<Integer> numbers = Arrays.asList(1,2,3,4,5,6,7,8,9);
		
		assertThat(numbers.stream().filter(x -> x < 4)).containsOnly(1,2,3);
	}
	
	@Test
	public void collectIntoAList() {
		List<String> names = Arrays.asList("Cesario", "Tiago", "Elisa" , "Jacqueline", "Baboon", "Banana");
		
		List<String> shortNames = names
			    .stream()
			    .filter(p -> p.length() <= 6)
			    .map(p -> p)
			    .collect(Collectors.toList());
		
		assertThat(shortNames).contains("Tiago", "Elisa", "Banana", "Baboon");
	}


	@Test
	public void mapAppliesToAllItems() {
		List<Integer> numbers = Arrays.asList(1,2,3,4,5,6,7,8,9);
		
		int result = numbers.stream()
				.filter(x -> x > 0)
				.parallel()
				.mapToInt( i -> i + 1 )
				.reduce(0, (x,y) -> x+y);
		
		assertThat(result).isEqualTo(54);
	}

}
