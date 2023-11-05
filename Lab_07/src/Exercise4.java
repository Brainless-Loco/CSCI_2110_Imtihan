import java.util.Scanner;

public class Exercise4 {
    public static void multiples(int n, int m){
        if(m==0){
            return;
        }
        else{
            System.out.print(n*m);
            if(m>1) System.out.print(", ");
            multiples(n,m-1);
        }
    }
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter a positive integer for n: ");
        int n = input.nextInt();
        System.out.print("Enter another positive integer for m: ");
        int m = input.nextInt();
        System.out.println("multiples("+n+","+m+"): ");
        multiples(n,m);
    }
}
