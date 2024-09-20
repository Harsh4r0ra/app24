class SleepThread extends Thread {
    private int sleepTime;

    SleepThread(int sleepTime) {
        this.sleepTime = sleepTime;
    }

    @Override
    public void run() {
        System.out.println("Thread " + Thread.currentThread().getName() + " sleeping for " + sleepTime + " milliseconds.");
        try {
            Thread.sleep(sleepTime); 
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Thread " + Thread.currentThread().getName() + " woke up after " + sleepTime + " milliseconds.");
    }
}

public class ex77 {
    public static void main(String[] args) {
        
        int[] sleepTimes = {10, 20, 50, 70, 100};

        for (int sleepTime : sleepTimes) {
            SleepThread thread = new SleepThread(sleepTime);
            thread.start();
        }

       
      
    }
}