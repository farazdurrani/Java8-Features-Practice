import java.util.Arrays;
import java.util.function.IntPredicate;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Predicate1 {
	public static void main(String[] args) {

		Predicate<Integer> greaterThan10 = i -> i > 10;
		Predicate<Integer> lesserThan20 = i -> i < 20;

		Integer values[] = { 1, 2, 3, 15, 16, 17, 23, 24, 25 };
		Arrays.stream(values)
			.filter(greaterThan10.and(lesserThan20))
			.collect(Collectors.toList()) // you can collect Integer to list. But you cannot capture primitive ints to
											// list. see below
			.forEach(System.out::println);

		IntPredicate greaterThan10_2 = i -> i > 10;

		int values2[] = { 1, 2, 3, 15, 16, 17, 23, 24, 25 };
		Arrays.stream(values2)
			.filter(greaterThan10_2) // We have to use different Predicate
//			.collect(Collectors.toList()); // this throws an error.
			.forEach(System.out::println);

	}

}
