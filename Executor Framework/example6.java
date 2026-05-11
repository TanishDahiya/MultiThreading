import java.util.Arrays;
import java.util.List;
import java.util.concurrent.*;

public class InvokeAllExample {

    public static void main(String[] args) throws Exception {

        ExecutorService executor = Executors.newFixedThreadPool(3);

        List<Callable<Integer>> tasks = Arrays.asList( () -> 10, () -> 20, () -> 30);   // Callable Integer Object in the list

        // runs all tasks
        List<Future<Integer>> futures = executor.invokeAll(tasks);   // invokeAll() - main thread wait until all tasks comepleted

        // get results
        for (Future<Integer> future : futures) {        // Future<Integer> future :  because future is object of integer that's why we have written
            System.out.println(future.get());           // print all values 10,20,30 
        }

        executor.shutdown();
    }
}
