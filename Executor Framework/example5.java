import java.util.concurrent.*;

public class SubmitExample {

    public static void main(String[] args) throws Exception {

        ExecutorService executor = Executors.newFixedThreadPool(2);

        // Runnable task + custom return result
        Future<String> future = executor.submit(() -> {
            System.out.println("Task is running");
        }, "Task Completed");

        String result = future.get();

        System.out.println(result);

        executor.shutdown();
    }
}
