import java.util.*;
import java.io.*;
public class Exercise3 {
    public static void main(String[] args) throws FileNotFoundException {
        Stack<StudentRecord> stack1 = new Stack<>();
        Stack<String> stack2 = new Stack<>();

        Scanner input = new Scanner(System.in);
        System.out.print("Enter the name of the input file: ");
        String filename = input.next();

        File file = new File(filename);
        Scanner inputFile = new Scanner(file);

        StringTokenizer token;
        while (inputFile.hasNext()){
            String line = inputFile.nextLine();
            token = new StringTokenizer(line, " ");
            String firstName = token.nextToken();
            String lastName = token.nextToken();
            String IDString = token.nextToken();
            Integer IDNum = Integer.valueOf(IDString);

            StudentRecord tempStudentRecord = new StudentRecord(firstName,lastName,IDNum);
            stack1.push(tempStudentRecord);
        }
        inputFile.close();
        while (stack1.isEmpty()==false) {
            StudentRecord tempStudentRecord = stack1.pop();
            stack2.push(tempStudentRecord.getLastName());
        }

        while (stack2.isEmpty()==false) {
            System.out.println(stack2.pop());
        }
    }
}
