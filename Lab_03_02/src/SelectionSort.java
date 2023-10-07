import java.util.Random;
import java.util.Scanner;

public class SelectionSort {
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

            selectionSort(arr);

            endTime = System.currentTimeMillis();
            executionTime = endTime - startTime;

            System.out.println("Array Size: "+n+"   Execution Time: "+ executionTime);
        }

    }
    public static void selectionSort(int[] arr) {
        int n = arr.length;
        int i,j;

        for (i=0; i<n-1; i++) {
            int minIndex = i;

            for (j=i+1;j<n;j++) {
                if (arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
            }
            int temp = arr[i];
            arr[i] = arr[minIndex];
            arr[minIndex] = temp;
        }
    }
}
