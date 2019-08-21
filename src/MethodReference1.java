import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class MethodReference1 {
	public static void main(String[] args) {
		long count = IntStream.rangeClosed(1, 5)
			.count();
		System.out.println(count);
		String joined = IntStream.rangeClosed(1, 5)
			.mapToObj(String::valueOf)
			.collect(Collectors.joining(" "));
		System.out.println(joined);
		
		MethodReference1 mr = new MethodReference1();
		joined = IntStream.rangeClosed(1, 5)
			.mapToObj(mr::convertToStringNonStatic)
			.collect(Collectors.joining(" "));
		System.out.println(joined);
		joined = IntStream.rangeClosed(1, 5)
			.mapToObj(MethodReference1::convertToString)
			.collect(Collectors.joining(" "));
		System.out.println(joined);

	}

	public static String convertToString(int i) {
		return String.valueOf(i);
	}

	public String convertToStringNonStatic(int i) {
		return String.valueOf(i);
	}
}
