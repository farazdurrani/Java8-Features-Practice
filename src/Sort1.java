import java.util.Arrays;

public class Sort1 {
	public static void main(String[] args) {
		String[] alphabets = { "a", "c", "d", "b" };
		Arrays.stream(alphabets)
			.sorted()
			.forEach(System.out::println);

		Arrays.stream(alphabets)
			.sorted(String.CASE_INSENSITIVE_ORDER.reversed())
			.forEach(System.out::println);
	}
}
