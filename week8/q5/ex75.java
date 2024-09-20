class UserThread extends Thread {
    @Override
    public void run() {
        System.out.println("User Thread: " + Thread.currentThread().getName() + " is running.");
        try {
            Thread.sleep(1000); 
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("User Thread: " + Thread.currentThread().getName() + " has finished.");
    }
}

public class ex75 {
    public static void main(String[] args) {
        
        UserThread userThread = new UserThread();
        userThread.start();

        
        System.out.println("Main Thread: " + Thread.currentThread().getName() + " is running.");
        try {
            Thread.sleep(1000); 
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Main Thread: " + Thread.currentThread().getName() + " has finished.");
    }
}