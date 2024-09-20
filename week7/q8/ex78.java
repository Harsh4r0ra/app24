import java.util.Scanner;

class UserThreadPriority extends Thread {
    static String k;
    static char c;

    public void run() {
        System.out.println(Thread.currentThread().getName() + ": Started with priority " + Thread.currentThread().getPriority());
    }
}

public class ex78 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a string: ");
        UserThreadPriority.k = scanner.nextLine();
        System.out.print("Enter a character: ");
        UserThreadPriority.c = scanner.next().charAt(0);

        Thread threadObj1 = new UserThreadPriority();
        Thread threadObj2 = new UserThreadPriority();

        threadObj1.setName("ThreadA");
        threadObj2.setName("ThreadB");

        threadObj1.start();
        threadObj2.start();
    }
}
