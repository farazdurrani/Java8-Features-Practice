import java.util.stream.IntStream;

public class Lambda1 {
	public static void main(String[] args) {
		int sum = IntStream.rangeClosed(1, 10)
			.filter(x -> x % 2 == 0)
			.map(x -> x * 3)
			.sum();
		System.out.println(sum);

		int sum2 = IntStream.rangeClosed(1, 10)
			.map(x -> {
				if (x % 2 == 0) {
					return x * 3;
				}
				return 0;
			})
			.sum();
		System.out.println(sum2);
	}
}
