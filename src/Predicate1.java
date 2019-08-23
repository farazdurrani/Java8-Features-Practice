import java.util.Arrays;
import java.util.function.Predicate;

public class Predicate1 {
	public static void main(String[] args) {

		Predicate<Integer> greaterThan10 = i -> i > 10;
		Predicate<Integer> lesserThan20 = i -> i < 20;

		Integer values[] = { 1, 2, 3, 15, 16, 17, 23, 24, 25 };
		Arrays.stream(values)
			.filter(greaterThan10.and(lesserThan20))
			.forEach(System.out::println);

	}

}
