import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class ExecutorFrameWork {

    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();
        ExecutorService executor = Executors.newFixedThreadPool(3);    // Executors is a UTILITY CLASS
        for (int i = 1; i < 10; i++) {
            int finalI = i;  
            executor.submit(() -> {
                long result = factorial(finalI);   // final because lambda does not accepts direct variables from loop because they are changing
                System.out.println(result);
            });

        }
        executor.shutdown();
        // executor.shutdown();
        try {
            executor.awaitTermination(1, TimeUnit.SECONDS);    // wait till 1 sec, doesn't matter tasks cmpltd or not execution movies to next line
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        System.out.println("Total time " + (System.currentTimeMillis() - startTime));
    }

    private static long factorial(int n) {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        long result = 1;
        for (int i = 1; i <= n; i++) {
            result *= i;
        }
        return result;
    }
}
