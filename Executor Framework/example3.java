import java.util.concurrent.*;

public class FutureExample {

    public static void main(String[] args) throws Exception {

        ExecutorService executor = Executors.newFixedThreadPool(2);

        Future<Integer> future = executor.submit(() -> {              // we can also use Future<?> -> like this 
            return 10 + 20;
        });

        Integer result = future.get();   // get returned value        // but if we use ? at this line Object is returned Object result = future.get()

        System.out.println(result);

        executor.shutdown();
    }
}

// We can use Future<?> when we do not care about the return type.
// if we know exact type (Future<Integer>) then we can use with data type,  because it gives type safety and avoids casting.
