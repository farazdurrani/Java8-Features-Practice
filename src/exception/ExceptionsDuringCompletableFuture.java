package exception;

import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class ExceptionsDuringCompletableFuture {

	public static void main(String[] args)
		throws InterruptedException, ExecutionException {

		ExceptionsDuringCompletableFuture e = new ExceptionsDuringCompletableFuture();
		List<CompletableFuture<String>> l = new ArrayList<>();

		l.add(CompletableFuture.supplyAsync(() -> e.name()));
		l.add(CompletableFuture.supplyAsync(() -> e.name()));

		// if an exception is thrown in any of the for loops, "Completed" is never printed. But, first for loop looks
		// more readable.
		for (CompletableFuture<String> completableFuture : l) {
			System.out.println(completableFuture.get());
		}

		l.forEach(x -> {
			try {
				System.out.println(x.get());
			}
			catch (InterruptedException | ExecutionException e1) {
				throw new RuntimeException();
			}
		});

		System.out.println("Completed");

	}

	private String name() {
		Random rand = new SecureRandom();
		int sleep = rand.nextInt(10000);
		try {

			System.out.println("Sleeping for: " + sleep);
			Thread.sleep(sleep);
		}
		catch (InterruptedException e) {
			e.printStackTrace();
		}
		if (sleep % 2 == 0)
			throw new RuntimeException();
		return "faraz";
	}
}
