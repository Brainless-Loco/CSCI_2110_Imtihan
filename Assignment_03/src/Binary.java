import java.util.Scanner;

public class Binary {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter a positive integer: ");
        int n = input.nextInt();

        generateBinary(n);

    }
    public static void generateBinary(int n){
        long startTime, endTime, executionTime;
        startTime = System.currentTimeMillis();

        int toPowerN =  (int)(Math.pow(2,n));

        toPowerN--;

        int i=0;

        String temp;

        while(i<=toPowerN){
            temp = Integer.toBinaryString(i);
            i++;
        }

        endTime = System.currentTimeMillis();
        executionTime = endTime - startTime;

        System.out.println("The execution time to generate binary numbers from 0 to "+toPowerN+" is "+executionTime+" ms");
    }
}
