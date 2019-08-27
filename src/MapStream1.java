import java.util.Map;
import java.util.TreeMap;
import java.util.function.BiConsumer;
import java.util.stream.Collectors;

public class MapStream1 {
	public static void main(String[] args) {
		Map<String, Long> map = Map.of("faraz", 1L, "saad", 2L, "Hassan", 3L);
		map.entrySet()
			.forEach((entry) -> {
				System.out.println(entry.getKey() + " " + entry.getValue());
			});

		map.entrySet()
			.stream()
			.forEach((entry) -> {
				System.out.println(entry.getKey() + " " + entry.getValue());
			});
		BiConsumer<String, Long> bic = (x, y) -> {
			System.out.println(x + " " + y);
		};
		map.forEach(bic);

		map.entrySet()
			.stream()
			.collect(Collectors.groupingBy(entry -> entry.getKey()
				.charAt(0), TreeMap::new, Collectors.toList()))
			.forEach((letter, wordList) -> {
				System.out.printf("%n%C%n", letter);
				wordList.stream()
					.forEach(word -> {
						System.out.printf("%13s: %d%n", word.getKey(),
							word.getValue());
					});

			});

	}
}
