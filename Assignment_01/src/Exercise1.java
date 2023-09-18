import java.util.Scanner;

public class Exercise1 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int i,test_cases;
        test_cases = input.nextInt();

        Rectangle[] rectangles = new Rectangle[test_cases];
        Rectangle1[] rectangle1s = new Rectangle1[test_cases];

        for(i=0;i<test_cases;i++){
            int xpos,ypos,width,height;

            xpos = input.nextInt();
            ypos = input.nextInt();
            width = input.nextInt();
            height = input.nextInt();

            Rectangle1 rectangle1 = new Rectangle1(xpos,ypos,width,height);
            rectangle1s[i] = rectangle1;


            xpos = input.nextInt();
            ypos = input.nextInt();
            width = input.nextInt();
            height = input.nextInt();

            Rectangle rectangle = new Rectangle(xpos,ypos,width,height);
            rectangles[i] = rectangle;
        }

        for(i=0;i<test_cases;i++){
            System.out.println("Test case: "+i+1);
            System.out.println("Rectangle 1: "+rectangle1s[i].toString());
            System.out.println("Rectangle 2: "+rectangles[i].toString());
            System.out.println("Iss Rectangle 2 contained in Rectangle 1? "+rectangle1s[i].contains(rectangles[i])+"\n");

        }

    }

}
