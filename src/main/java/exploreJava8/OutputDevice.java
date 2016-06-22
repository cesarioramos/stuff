package exploreJava8;

import java.util.Optional;
import java.util.function.Function;

@FunctionalInterface
public interface OutputDevice {

	public int func(String p);

	default public void print(String p) {
		System.out.println(p);
	}
	
	default public Optional<String> doStuff(String p) {
		return Optional.ofNullable(null);
	}

	
	static public int printFunc(Function<Integer, Integer> f, Integer i) {
		return f.apply(i);
	}

}
