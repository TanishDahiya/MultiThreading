import java.util.concurrent.atomic.AtomicInteger;

class AtomicCounter {

    AtomicInteger count = new AtomicInteger(0);    // that is how we can create value with initial value is 0

    public void increment() {
        count.incrementAndGet();           // we do not do count ++, we have to use here incrementAndGet function
    }
}

public class Main {

    public static void main(String[] args) throws Exception {

        AtomicCounter ac = new AtomicCounter();   

        Thread t1 = new Thread(() -> {

            for(int i = 0; i < 1000; i++) {
                ac.increment();         
            }
        });

        Thread t2 = new Thread(() -> {

            for(int i = 0; i < 1000; i++) {
                ac.increment();
            }
        });

        t1.start();
        t2.start();

        t1.join();
        t2.join();

        System.out.println(ac.count);
    }
}
