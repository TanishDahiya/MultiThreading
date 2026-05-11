import java.util.concurrent.*;

public class FutureExample {

    public static void main(String[] args) throws Exception {

        ExecutorService executor = Executors.newFixedThreadPool(2);

        Future<Integer> future = executor.submit(() -> {
            return 10 + 20;
        });

        Integer result = future.get();   // get returned value

        System.out.println(result);

        executor.shutdown();
    }
}
