import java.util.Scanner;

public class LinkedListDemo {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter Pokemon names, one on each line\n" +"Enter quit to end");

        String str;
        LinkedList<String> list = new LinkedList<String>();

        while (true){
            str = input.nextLine();
            if(str.equals("quit")) break;
            list.add(str);
        }
//        displayEven(list);
//        list.enumerate();
//        displayOdd(list);
//        list.enumerate();
//        removeMiddle(list);
//        list.enumerate();
//        LinkedList<String> list1 = reverse(list);
//        list1.enumerate();
    }
    public static void displayEven(LinkedList<String> list){
        int size = list.size(),i;
        for(i=0;i<size;i+=2){
            System.out.print(list.getAt(i)+" ");
        }
        if(size>0) System.out.println();
    }
    //method to display odd-numbered nodes
    public static void displayOdd(LinkedList<String> list){
        int size = list.size(),i;
        for(i=1;i<size;i+=2){
            System.out.print(list.getAt(i)+" ");
        }
        if(size>0) System.out.println();
    }
    //method to create a reversed linked list
    public static LinkedList<String> reverse(LinkedList<String> list){
        LinkedList<String> ret = new LinkedList<String>();
        int i,size=list.size();
        for(i=0;i<size;i++){
            ret.add(list.getAt(i));
        }
        return ret;
    }
    //method to remove the middle node in the linked list
    public static void removeMiddle(LinkedList<String> list){
        int size = list.size(),i;
        if(size%2==1) list.removeAt(size/2);
        else list.removeAt((size-1)/2);
        list.enumerate();
    }
}
