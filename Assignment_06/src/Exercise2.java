import java.io.File;
import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Exercise2 {

    public static void main(String[] args) {

        int first, second, n;

        try {
            File file = new File("src/input2.txt");
            Scanner input = new Scanner(file);
            n = input.nextInt();
            int[][] mat = new int[n][n];


            while (input.hasNext()) {
                first = input.next().charAt(0) - 'A';
                second = input.next().charAt(0) - 'A';
                mat[first][second] = 1;
            }

            int[] pred = new int[n];
            for(int v=0;v<n;v++) {
                for(int u=0;u<n;u++) {
                    pred[v] += mat[u][v];
                }
            }

            Queue<Integer> queue = new LinkedList<>();
            for (int v=0; v<n; v++) {
                if (pred[v]==0) {
                    queue.add(v);
                }
            }

            int topnum = 1;
            int[] result = new int[n];

            while (!queue.isEmpty()) {
                int w = queue.poll();

                result[w] = topnum++;
                for (int p=0; p<n;p++) {
                    if (mat[w][p]==1) {
                        pred[p]--;

                        if (pred[p] == 0) {
                            queue.add(p);
                        }

                    }
                }
            }

            int temp[] = new int[n];

            System.out.println("topnum:");

            for(int i=0;i<n;i++){
                temp[result[i]-1]=i;
                System.out.print((i+1)+" ");
            }
            System.out.println();

            for (int i = 0; i < n; i++) {
                System.out.print((char) ('A' + temp[i]) + " ");
            }
        }
        catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

}

