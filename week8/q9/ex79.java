class ThreadA extends Thread {
    private String k;
    private int dc; // To store the count of digits

    ThreadA(String k) {
        this.k = k;
    }

    @Override
    public void run() {
        for (char c : k.toCharArray()) {
            if (Character.isDigit(c)) {
                dc++;
            }
        }
        System.out.println("ThreadA: " + dc);
    }
}

class ThreadB extends Thread {
    private String k;
    private int cc; // To store the count of alphabetic characters

    ThreadB(String k) {
        this.k = k;
    }

    @Override
    public void run() {
        for (char c : k.toCharArray()) {
            if (Character.isAlphabetic(c)) {
                cc++;
            }
        }
        System.out.println("ThreadB: " + cc);
    }
}

public class ex79 {
    public static void main(String[] args) {
        String k = "Hello123World456!";

        // Create and start ThreadA and ThreadB
        ThreadA threadA = new ThreadA(k);
        ThreadB threadB = new ThreadB(k);

        threadA.start();
        threadB.start();

        try {
            threadA.join(); // Wait for ThreadA to finish
            threadB.join(); // Wait for ThreadB to finish
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}