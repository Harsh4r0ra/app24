public class ex74 {
    public static void main(String[] args) {
        Thread thread = new Thread(() -> {
            for (int i = 5; i > 0; i--) {
                try {
                    Thread.sleep(6000);
                    Thread.currentThread().setName("Thread-" + i);
                    System.out.println("Thread name changed to: " + Thread.currentThread().getName());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        thread.start();
    }
}
