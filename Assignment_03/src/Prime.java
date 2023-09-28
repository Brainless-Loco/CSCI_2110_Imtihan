import java.util.Scanner;

public class Prime {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);


        while(true){
            long n = input.nextLong();
            if(n==0) break;
            else nthPrime(n);
        }

    }
    public static void nthPrime(long n){
        long startTime, endTime, executionTime;
        long totalTillNow=0,current=1,j,sqrt;
        startTime = System.currentTimeMillis();

        while(totalTillNow<n){

            current++;

            sqrt = (long) Math.sqrt(current);

            boolean isPrime = true;

            for(j=2;j<=sqrt;j++){
                if(current%j==0){
                    isPrime = false;
                    break;
                }
            }

            if(isPrime==true){
                totalTillNow++;
            }
        }

        endTime = System.currentTimeMillis();
        executionTime = endTime - startTime;

        System.out.println(n + " " + current + " " + executionTime);

    }
}

//Input

//11
//101
//1001
//10001
//100001
//1000001
//0


//Output

//11 31 0
//101 547 0
//1001 7927 15
//10001 104743 31
//100001 1299721 834
//1000001 15485867 30550
