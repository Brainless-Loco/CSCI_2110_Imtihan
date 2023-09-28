import java.util.Scanner;

public class Exercise1 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int i,test_cases;
        test_cases = input.nextInt();

        Rectangle1[] rectangles_t1 = new Rectangle1[test_cases];
        Rectangle1[] rectangles_t2 = new Rectangle1[test_cases];

        for(i=0;i<test_cases;i++){
            int xpos,ypos,width,height;

            xpos = input.nextInt();
            ypos = input.nextInt();
            width = input.nextInt();
            height = input.nextInt();

            Rectangle1 rectangle = new Rectangle1(xpos,ypos,width,height);
            rectangles_t1[i] = rectangle;


            xpos = input.nextInt();
            ypos = input.nextInt();
            width = input.nextInt();
            height = input.nextInt();

            rectangle = new Rectangle1(xpos,ypos,width,height);
            rectangles_t2[i] = rectangle;
        }

        for(i=0;i<test_cases;i++){
            System.out.println("Test case: "+(i+1));
            System.out.println("Rectangle 1: "+rectangles_t1[i].toString());
            System.out.println("Rectangle 2: "+rectangles_t2[i].toString());
            System.out.println("Is Rectangle 2 contained in Rectangle 1? "+rectangles_t1[i].contains(rectangles_t2[i])+"\n");

        }

    }

}
