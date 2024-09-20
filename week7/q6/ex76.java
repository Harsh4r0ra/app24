class Printer {
    synchronized void printJob(int job) {
        System.out.println("Printing job: " + job);
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

class PrintJobThread extends Thread {
    Printer printer;
    int job;

    PrintJobThread(Printer printer, int job) {
        this.printer = printer;
        this.job = job;
    }

    public void run() {
        printer.printJob(job);
    }
}

public class ex76 {
    public static void main(String[] args) {
        Printer printer = new Printer();
        for (int i = 1; i <= 5; i++) {
            new PrintJobThread(printer, i).start();
        }
    }
}
