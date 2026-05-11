import java.util.concurrent.*;

public class CountDownLatchWithExecutor {

    public static void main(String[] args) throws Exception {

        ExecutorService executor = Executors.newFixedThreadPool(3);

        CountDownLatch latch = new CountDownLatch(3);

        executor.submit(() -> {
            System.out.println("DB Service Ready");
            latch.countDown();
        });

        executor.submit(() -> {
            System.out.println("Email Service Ready");
            latch.countDown();
        });

        executor.submit(() -> {
            System.out.println("Cache Service Ready");
            latch.countDown();
        });

        // main thread waits
        latch.await();

        System.out.println("Application Started");

        executor.shutdown();
    }
}
