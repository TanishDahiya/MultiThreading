public class ManualThreadExample {
    public static void main(String[] args) throws InterruptedException {

        long startTime = System.currentTimeMillis();
        Thread[] threads = new Thread[5];     // Thread Array, we are stroing references
        for (int i = 1; i <= 5; i++) {
            int num = i;
            threads[i - 1] = new Thread(() -> {
                System.out.println("Factorial of " + num + " = " + factorial(num));
            });
            threads[i - 1].start();
        }
        // Main thread waits for all child threads
        for (Thread thread : threads) {
            thread.join();                  // can not use directly join this will not wait because we have to wait for all threads
        } 
        System.out.println("Total Time: "
                + (System.currentTimeMillis() - startTime));
    }

    private static long factorial(int n) {
        long result = 1;
        for (int i = 1; i <= n; i++) {
            result *= i;
        }

        return result;
    }
}


// Thread array is used because we have to store the references
// if we directly use join() after for loop, because join does not know the references, threads works like sequentially
