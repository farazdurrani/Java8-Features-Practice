import java.security.SecureRandom;

public class Random1 {
	public static void main(String[] args) {
		SecureRandom random = new SecureRandom();
		random.ints(10, 1, 7).distinct().forEach(System.out::println);
	}
}
