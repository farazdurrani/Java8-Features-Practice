import java.util.stream.IntStream;

public class Reduce1 {

	public static void main(String[] args) {
		int a[] = { 1, 2, 3, 4 };
		System.out.println(IntStream.of(a)
			.reduce(0, (x, y) -> x + y));
//		0+1=1
//		1+2=3
//		3+3=6
		System.out.println("without 0 -> " +IntStream.of(a)
			.reduce((x, y) -> x + y).getAsInt());
		
		
		System.out.println(IntStream.of(a)
			.reduce(2, (x, y) -> x + y));
//		2+1=3
//		3+2=5
//		5+3=8
		int b [] = {3,10,6,1,4,8,2,5,9,7};
		System.out.println(IntStream.of(b)
			.reduce((x, y) -> x * y)
			.getAsInt());
		
		System.out.println(IntStream.of(a)
			.reduce((x, y) -> x * y)
			.getAsInt());
//		1*2=2
//		2*3=6

	}
}
