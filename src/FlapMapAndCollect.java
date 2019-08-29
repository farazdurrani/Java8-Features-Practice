import java.util.List;
import java.util.TreeMap;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FlapMapAndCollect {
	public static void main(String[] args) {
		// Collectors.groupingBy(Function interface used as a classifier) produces a Map with value being a list
		List<String> list = List.of("faraz", "saad", "sarwar", "faraz");
		list.stream()
			.collect(Collectors.groupingBy(String::toUpperCase))
			.forEach((x, y) -> {
				System.out.println(x + " " + (y instanceof List));
			});

		// Collectors.groupingBy(Function interface used as a classifier, downstream collector) produces a Map with
		// value being a list
		list.stream()
			.collect(Collectors.groupingBy(String::toUpperCase,
				Collectors.counting()))
			.forEach((x, y) -> {
				System.out.println(x + " " + y);
			});

		String fullName = "Faraz Sarwar Durrani";

		// flatMap recieves a Function
		// Collectors.groupingBy with 3 parameters uses a classifier, Map factory, and a downstream collector
		Stream.of(fullName)
			.flatMap(word -> Pattern.compile("\\s+")
				.splitAsStream(word))
			.collect(Collectors.groupingBy(String::toUpperCase, TreeMap::new,
				Collectors.counting()))
			.forEach((x, y) -> {
				System.out.println(x + " " + y);
			});

	}
}
