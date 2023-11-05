import java.util.Scanner;

public class Exercise7 {
    public static long solve(int n) {
        return solve(n, 1, 3, 2);
    }

    public static long solve(int n, int start, int end, int tmp) {
        if (n == 1) {
            return 1;
        }
        else {
            long moves1 = solve(n - 1, start, tmp, end);
            long moveDisk = 1;
            long moves2 = solve(n - 1, tmp, end, start);
            return moves1 + moveDisk + moves2;
        }
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        while(true){
            System.out.print("Enter the number of discs (n): ");
            int n = input.nextInt();
            if(n==0) break;

            long startTime, endTime, executionTime;
            startTime = System.currentTimeMillis();

            long moves = solve(n);

            endTime = System.currentTimeMillis();
            executionTime = endTime - startTime;

            System.out.println("Number of moves for " + n + " discs: " + moves);
            System.out.println("Execution time: " + executionTime + " milliseconds");
        }

    }
}
