package several.completable.futures;

import java.security.SecureRandom;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Collectors;

public class CompletableFuturePractice {
	public static void main(String[] args) {

		CompletableFuture<Integer> cf1 = CompletableFuture
			.supplyAsync(() -> method());
		CompletableFuture<Integer> cf2 = CompletableFuture
			.supplyAsync(() -> method());
		CompletableFuture<Integer> cf3 = CompletableFuture
			.supplyAsync(() -> method());
		CompletableFuture<Integer> cf4 = CompletableFuture
			.supplyAsync(() -> method());

		List<CompletableFuture<Integer>> completableFutures = List.of(cf1, cf2,
			cf3, cf4);

//		Below approach can possibly be used when adding more completeableFutures. Possibly...
//		CompletableFuture<Void> allFutures = CompletableFuture
//			.allOf(completableFutures
//				.toArray(new CompletableFuture[completableFutures.size()]));
//		CompletableFuture<List<Integer>> allCompletableFuture = allFutures
//			.thenApply(future -> {
//				return completableFutures.stream()
//					.map(completableFuture -> completableFuture.join())
//					.collect(Collectors.toList());
//			});
//		Above approach can possibly be used when adding more completeableFutures. Possibly...
		
		List<Integer> list = completableFutures.stream()
			.map(cf -> cf.join())
			.collect(Collectors.toList());
		list.forEach(System.err::println);

		System.err.println("Caling method2()");

		List<CompletableFuture<List<Integer>>> listOfCfs = List.of(
			CompletableFuture.supplyAsync(() -> method2()),
			CompletableFuture.supplyAsync(() -> method2()),
			CompletableFuture.supplyAsync(() -> method2()),
			CompletableFuture.supplyAsync(() -> method2()));
		
		listOfCfs.stream().map(cf -> cf.join()).flatMap(x -> x.stream()).collect(Collectors.toList()).forEach(System.err::println);

	}

	private static Integer method() {
		return new SecureRandom().ints()
			.findFirst()
			.getAsInt();
	}

	private static List<Integer> method2() {
		return new SecureRandom().ints()
			.limit(5)
			.boxed()
			.collect(Collectors.toList());
	}
}
