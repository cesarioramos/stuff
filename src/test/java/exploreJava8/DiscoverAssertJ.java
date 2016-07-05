package exploreJava8;

import static org.assertj.core.api.Assertions.*;

import java.util.function.BinaryOperator;

import org.junit.Test;

public class DiscoverAssertJ {
	@Test
	public void firstSpecification() {
		assertThat("Tiago").contains("Tia");
	}
	
	@Test
	public void BINinOperatorSpecification() {
		BinaryOperator<String> plus = (x, y) -> x + y;

		assertThat(plus.apply("Ces", "ario")).contains("C");
	}
	
	@Test
	public void arraySpecification() {
		String nomes[] = { "Cesario", "Tiago", "Elisa" };
		
		assertThat(nomes).doesNotContain("Jacqueline");
		assertThat(nomes).contains("Tago");
	}
	

}
