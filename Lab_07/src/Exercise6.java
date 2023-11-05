import java.util.Scanner;

public class Exercise6 {
    public static int squares(int n) {
        if(n<=1) {
            return n;
        }
        else {
            return n*n + squares(n - 1);
        }
    }
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter a positive integer for sum of square: ");
        int n = input.nextInt();
        System.out.println("squares("+n+"): "+squares(n));
    }
}
