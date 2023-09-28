import java.util.Arrays;
import java.util.Scanner;

public class MatrixMult {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        while(true){
            double size,element;
            size = input.nextDouble();
            element = input.nextDouble();
            multiplyMatrix(size,element);
        }

    }

    public static void multiplyMatrix(double size, double element){
        long startTime, endTime, executionTime;
        startTime = System.currentTimeMillis();

        double[][] m1 = new double[(int)size][(int)size];
        double[][] m2 = new double[(int)size][(int)size];
        double[][] c = new double[(int)size][(int)size];

        int i,j,k;

        for(i=0;i<size;i++){
            Arrays.fill(m1[0], element);
            Arrays.fill(m2[0], element);
            Arrays.fill(c[0],0);
        }

        for(i=0;i<size;i++){
            for(j=0;j<size;j++){
                for ( k = 0; k < size; k++) {
                    c[i][j] += m1[i][k] * m2[k][j];
                }
            }
        }

        endTime = System.currentTimeMillis();
        executionTime = endTime - startTime;

        System.out.println("Size:"+ (int)size+" Time: "+executionTime+" ms");
    }
}
