import java.util.Scanner;

public class Exercise5 {
    public static void writeVertical(int n) {
        if(n<10){
            System.out.println(n);
            return ;
        }
        else {
            writeVertical(n/10);
            System.out.println(n%10);
        }
    }
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter a positive integer for writeVertical: ");
        int n = input.nextInt();
        System.out.println("writeVertical("+n+"): ");
        writeVertical(n);
    }
}
