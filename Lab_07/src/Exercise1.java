import java.util.Scanner;

public class Exercise1 {
    public static int factorial(int n){
        if(n==0) return 1;
        else return n*factorial(n-1);
    }
    public static int fib(int n){
        if(n==0) return 0;
        if(n==1) return 1;
        return fib(n-1) + fib(n-2);
    }
    public static int power(int x, int n){
        if(n == 0) return 1;
        else return power(x,n-1)*x;
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n,i,x;

        System.out.println("Factorial of a number");
        System.out.print("Enter a positive integer: ");

        n = input.nextInt();
        System.out.println("The factorial of "+n+" is "+factorial(n)+"\n");

        System.out.println("Fibonacci numbers");
        System.out.print("Enter a positive integer: ");
        n = input.nextInt();
        System.out.println("The first "+n+" numbers in the Fibonacci series are:");

        for(i=0;i<n;i++){
            System.out.print(fib(i));
            if(i<n-1) System.out.print(", ");
        }

        System.out.println("\n");
        System.out.println("Power of a number");
        System.out.print("Enter a positive integer x: ");
        x = input.nextInt();
        System.out.print("Enter another positive integer: ");
        n = input.nextInt();
        System.out.println(x+" to the power of "+n+" is "+power(x,n)+"\n");

    }
}
