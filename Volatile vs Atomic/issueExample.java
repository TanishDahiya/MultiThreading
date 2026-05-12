class SharedObj {

    boolean flag = false;

    // Writer Thread
    public void setFlagTrue() {
        System.out.println("Writer thread changing flag to true");
        flag = true;
    }

    // Reader Thread
    public void printIfTrue() {

        while (!flag) {
            // stuck here until flag becomes true
        }

        System.out.println("Reader thread detected true value");
    }
}

public class Main {

    public static void main(String[] args) {

        SharedObj obj = new SharedObj();

        Thread reader = new Thread(() -> {
            obj.printIfTrue();
        });

        Thread writer = new Thread(() -> {

            try {
                Thread.sleep(3000);
            } catch (Exception e) {
            }

            obj.setFlagTrue();
        });

        reader.start();
        writer.start();
    }
}
