class Counter {

    int count = 0;                     // if we can only use volatile keyword so that not help, because it only ensures visibility not atomicity

    public void increment() {          // if we can use synchronized, so that means one thread enters at a time so this will work output will be 2000
        count++;
    }
}

public class Main {

    public static void main(String[] args) throws Exception {

        Counter counter = new Counter();

        Thread t1 = new Thread(() -> {

            for(int i = 0; i < 1000; i++) {
                counter.increment();
            }
        });

        Thread t2 = new Thread(() -> {

            for(int i = 0; i < 1000; i++) {
                counter.increment();
            }
        });

        t1.start();
        t2.start();

        t1.join();
        t2.join();

        System.out.println(counter.count);
    }
}
