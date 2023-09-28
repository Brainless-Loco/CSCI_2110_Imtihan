import java.util.Scanner;

public class GenericStackDemo {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        GenericStack<String> stringStack = new GenericStack<String>();
        GenericStack<Integer> integerStack = new GenericStack<Integer>();

        String inputLine = input.nextLine();
        String[] stringValues = inputLine.split("\\s+");
        int i,size = stringValues.length;

        for (i=0;i<size;i++) {
            if (stringValues[i].equals("quit")) {
                break;
            }
            stringStack.push(stringValues[i]);
        }

        inputLine = input.nextLine();
        String[] integerValues = inputLine.split("\\s+");
        size = integerValues.length;

        for (i=0;i<size;i++) {
            int intValue = Integer.parseInt(integerValues[i]);
            if (intValue == -1) {
                break;
            }
            integerStack.push(intValue);
        }

        System.out.println("String Stack Contents:");
        while (!stringStack.isEmpty()) {
            System.out.println(stringStack.pop());
        }

        System.out.println("\nInteger Stack Contents:");
        while (!integerStack.isEmpty()) {
            System.out.println(integerStack.pop());
        }
    }
}
