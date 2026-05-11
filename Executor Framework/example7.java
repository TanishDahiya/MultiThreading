import java.util.Arrays;
import java.util.List;
import java.util.concurrent.*;

public class InvokeAnyExample {

    public static void main(String[] args) throws Exception {

        ExecutorService executor = Executors.newFixedThreadPool(3);

        List<Callable<String>> tasks = Arrays.asList(

                () -> {
                    Thread.sleep(3000);
                    return "Task 1";
                },

                () -> {
                    Thread.sleep(1000);
                    return "Task 2";
                },

                () -> {
                    Thread.sleep(2000);
                    return "Task 3";
                }
        );

        // returns first completed task result
        String result = executor.invokeAny(tasks);

        System.out.println(result);

        executor.shutdown();
    }
}
