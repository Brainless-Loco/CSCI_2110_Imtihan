import java.util.Scanner;

public class Exercise3 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int i,test_cases;
        test_cases = input.nextInt();

        Circle[] circles_t1 = new Circle[test_cases];
        Circle[] circles_t2 = new Circle[test_cases];

        for(i=0;i<test_cases;i++){
            double xpos,ypos,radius;

            xpos = input.nextDouble();
            ypos = input.nextDouble();
            radius = input.nextDouble();
            circles_t1[i] = new Circle(xpos,ypos,radius);


            xpos = input.nextDouble();
            ypos = input.nextDouble();
            radius = input.nextDouble();
            circles_t2[i] = new Circle(xpos,ypos,radius);
        }


        for(i=0;i<test_cases;i++){
            System.out.println("Test case: "+(i+1));
            System.out.println("The first Circle's centre is at: "+circles_t1[i].getXpos()+","+circles_t1[i].getYpos());
            System.out.println("The first Circle's radius is :"+circles_t1[i].getRadius()+" units");
            System.out.println("The second Circle's centre is at: "+circles_t2[i].getXpos()+","+circles_t2[i].getYpos());
            System.out.println("The second Circle's radius is :"+circles_t2[i].getRadius()+" units");
            System.out.println("Second circle contained in first circle?: "+circles_t1[i].contains(circles_t2[i]));
            System.out.println("Second circle touches first circle? : "+circles_t1[i].touches(circles_t2[i])+"\n");
        }
    }
}
