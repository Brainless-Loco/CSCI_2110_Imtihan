import java.util.Scanner;

public class Exercise3 {
    public static void countDown(int n){
        if(n<=0){
            System.out.print("BlastOff!\n");
            return;
        }
        else{
            System.out.print(n+" ");
            countDown(n-2);
        }
    }
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter a positive integer for countDown: ");
        int n = input.nextInt();
        System.out.println("CountDown("+n+"): ");
        countDown(n);
    }
}
