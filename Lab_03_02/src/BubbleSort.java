import java.util.Random;
import java.util.Scanner;

public class BubbleSort {
    public static void main(String[] args) {
        long startTime, endTime, executionTime;
        Scanner input = new Scanner(System.in);


        while(true){
            int n = input.nextInt(),i;
            if(n==0) break;

            int[] arr = new int[n];
            Random rand = new Random();
            for(i = 0; i < n; i++) {
                int randomNumber = rand.nextInt(n) + 1;
                arr[i] = randomNumber;
            }

            startTime = System.currentTimeMillis();

            bubbleSort(arr);

            endTime = System.currentTimeMillis();
            executionTime = endTime - startTime;

            System.out.println("Array Size: "+n+"   Execution Time: "+ executionTime);
        }
    }

    public static void bubbleSort(int[] arr) {
        int n = arr.length;
        int i,j;

        for (i=0; i<n-1; i++) {
            for (j=0; j<n-i-1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }
}
