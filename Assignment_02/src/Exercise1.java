import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Exercise1 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n;

        long startTime, endTime, executionTime;

        String filePath = "Exercise1.out";
        try {
            FileWriter fileWriter = new FileWriter(filePath);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

            while (true) {
                n = input.nextInt();
                if (n == 0) break;

                int longest_number = 1, longest_sequence_length = 1, i;
                int intermediate_length;

                startTime = System.currentTimeMillis();

                for (i = 1; i <= n; i++) {
                    intermediate_length = run_Collatz(i);
                    if (intermediate_length > longest_sequence_length) {
                        longest_sequence_length = intermediate_length;
                        longest_number = i;
                    }
                }
                endTime = System.currentTimeMillis();
                executionTime = endTime - startTime;

                String temp = n + " " + longest_number + " " + longest_sequence_length + " " + executionTime;
                bufferedWriter.write(temp);
                bufferedWriter.newLine();
            }

            bufferedWriter.close();
        }
        catch (IOException e){
            System.out.println(e);
        }
    }

    public static int run_Collatz(int n) {
        int length = 1;
        while(n!=1){
            length++;
            if(n%2==0) n/=2;
            else n=n*3+1;
        }
        return  length;
    }
}
