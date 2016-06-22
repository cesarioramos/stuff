package exploreJava8;

import java.util.function.*;

@FunctionalInterface
public interface FuncionArgumentFunction {

	public Integer apply(Function<Integer, Integer> i, Integer j);
	
}
