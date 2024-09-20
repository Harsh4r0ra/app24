class MyThread extends Thread {
    @Override
    public void run() {
        System.out.println("Current Thread Name: " + Thread.currentThread().getName());
        
        try {
            Thread.sleep(5000); 
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        
      
        Thread.currentThread().setName("APP week 8");
        System.out.println("New Thread Name: " + Thread.currentThread().getName());
    }
}

public class ex73 {
    public static void main(String[] args) {
        MyThread thread = new MyThread();
        thread.start(); //
    }
}