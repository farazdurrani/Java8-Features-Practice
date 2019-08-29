import java.util.stream.IntStream;

public class Infinite1 {
	public static void main(String[] args) {
		IntStream.iterate(1, x -> x + 1)
			.parallel()
			.map(x -> {
				int y = x * 100_000_000_0;
				System.out.println(y);
				return y;
			})
			.count();
	}
}
