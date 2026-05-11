import java.util.concurrent.*;

public class FutureExample {

    public static void main(String[] args) throws Exception {

        ExecutorService executor = Executors.newFixedThreadPool(2);

        Future<Integer> future = executor.submit(() -> {

            Thread.sleep(3000);

            return 10 + 20;
        });

        // keep checking task completed or not
        while (!future.isDone()) {
            System.out.println("Task is still running...");       // this will not wait this will execute
            Thread.sleep(500);
        }

        // after completion
        Integer result = future.get();                    // get method will wait until future is completed

        System.out.println("Result : " + result);

        executor.shutdown();
    }
}

// so if we need to check is futire is done or not we can check by abov example
// if we need to execute after we are sure future is done then we need to write after future.get()
