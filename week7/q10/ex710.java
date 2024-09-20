class PriorityThread extends Thread {
    PriorityThread(String name, int priority) {
        setName(name);
        setPriority(priority);
    }

    public void run() {
        System.out.println(getName() + " with priority " + getPriority() + " is running.");
    }
}

public class ex710 {
    public static void main(String[] args) {
        PriorityThread t1 = new PriorityThread("Process1", Thread.MIN_PRIORITY);
        PriorityThread t2 = new PriorityThread("Process2", Thread.NORM_PRIORITY);
        PriorityThread t3 = new PriorityThread("Process3", Thread.NORM_PRIORITY + 1);
        PriorityThread t4 = new PriorityThread("Process4", Thread.MAX_PRIORITY);
        PriorityThread t5 = new PriorityThread("Process5", Thread.NORM_PRIORITY - 1);

        t1.start();
        t2.start();
        t3.start();
        t4.start();
        t5.start();
    }
}
