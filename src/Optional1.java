import java.util.stream.IntStream;
public class Optional1 {
	public static void main(String[] args) {
		int [] a1 = {1,2,3};
		System.out.println(IntStream.of(a1).min().getAsInt());
		
		int [] a2 = {2,2,2};
		System.out.println(IntStream.of(a2).min().getAsInt());
		
		int [] a3 = {};
		System.out.println(IntStream.of(a3).min().orElse(0));
		
		System.out.println(IntStream.of(a1).summaryStatistics());
		
		System.out.println(IntStream.of(a1).summaryStatistics().getCount());
		
		IntStream is = IntStream.of(a1);
		
		System.out.println(is.count());
		
		//System.out.println(is.sum()); //throws an exception since stream has already been operated upon or closed
		
	}
}
