// continuously prompt the user to enter a positive number untill they provide a valid inout

import java.util.Scanner;
public class positivenumber {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n;
        do {
            System.out.println("Enter a positive number: ");
            n = sc.nextInt();
        } while (n <= 0);
        System.out.println("You entered: " + n);
    }
}