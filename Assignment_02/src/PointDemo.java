import java.util.Scanner;

public class PointDemo {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter integer coordinates x and y: ");
        Integer intX,intY;
        intX = input.nextInt();
        intY = input.nextInt();
        Point<Integer> point1 = new Point<Integer>(intX,intY);

        System.out.print("Enter double coordinates x and y: ");
        Double doubleX, doubleY;
        doubleX = input.nextDouble();
        doubleY = input.nextDouble();
        Point<Double> point2 = new Point<Double>(doubleX,doubleY);

        System.out.print("Enter String coordinates x and y: ");
        String stringX, stringY;
        stringX = input.next();
        stringY = input.next();
        Point<String> point3 = new Point<String>(stringX,stringY);


        System.out.println(point1.toString());
        System.out.println(point2.toString());
        System.out.println(point3.toString());
    }
}
