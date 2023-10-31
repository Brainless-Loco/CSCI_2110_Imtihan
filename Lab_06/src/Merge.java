import java.io.*;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Merge {
    public static <T extends Comparable<T>> OrderedList<T> merge(OrderedList<T> list1, OrderedList<T> list2) {
        OrderedList<T> mergedList = new OrderedList<>();
        int lst1 = 0, lst2 = 0;
        int size1 = list1.size(), size2 = list2.size();

        while (lst1<size1 && lst2<size2) {
            T item1 = list1.get(lst1);
            T item2 = list2.get(lst2);

            int pos = item1.compareTo(item2);

            if (pos < 0) {
                mergedList.add(item1);
                lst1++;
            }
            else if (pos > 0) {
                mergedList.add(item2);
                lst2++;
            }
            else {
                mergedList.add(item1);
                lst1++;
                lst2++;
            }
        }

        while (lst1<size1) {
            mergedList.add(list1.get(lst1));
            lst1++;
        }

        while (lst2<size2) {
            mergedList.add(list2.get(lst2));
            lst2++;
        }

        return mergedList;
    }
    
    public static <T extends Comparable<T>> OrderedList<T> common(OrderedList<T> list1, OrderedList<T> list2) {
        OrderedList<T> mergedList = new OrderedList<>();
        int lst1 = 0, lst2 = 0;
        int size1 = list1.size(), size2 = list2.size();

        while (lst1<size1 && lst2<size2) {
            T item1 = list1.get(lst1);
            T item2 = list2.get(lst2);

            int pos = item1.compareTo(item2);

            if (pos < 0) {
                lst1++;
            }
            else if (pos > 0) {
                lst2++;
            }
            else {
                mergedList.add(item1);
                lst1++;
                lst2++;
            }
        }

        return mergedList;
    }

    public static <T extends Comparable<T>> OrderedList<T> difference(OrderedList<T> list1, OrderedList<T> list2) {
        OrderedList<T> result = new OrderedList<>();

        int lst1 = 0, lst2 = 0;
        int size1 = list1.size(), size2 = list2.size();

        while (lst1<size1 && lst2<size2) {
            T item1 = list1.get(lst1);
            T item2 = list2.get(lst2);

            int pos = item1.compareTo(item2);

            if (pos < 0) {
                result.add(item1);
                lst1++;
            }
            else if (pos > 0) {
                lst2++;
            }
            else {
                lst1++;
                lst2++;
            }
        }
        while (lst1<size1) {
            result.add(list1.get(lst1));
            lst1++;
        }

        return result;
    }

    /* public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        OrderedList<String> lst1 = new OrderedList<String>();
        OrderedList<String> lst2 = new OrderedList<String>();

        String str;
        int i=0;
        while(i<8){
            str = input.nextLine();
            lst1.insert(str);
            i++;
        }
        i=0;
        while(i<7){
            str = input.nextLine();
            lst2.insert(str);
            i++;
        }

        OrderedList<String> res1 = merge(lst1,lst2);
        OrderedList<String> res2 = common(lst1,lst2);
        OrderedList<String> res3 = difference(lst1,lst2);

        res1.enumerate();
        res2.enumerate();
        res3.enumerate();

    }*/
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        ArrayList<String> allNames = createAllNameList();

        OrderedList<String> lst1 = new OrderedList<String>();
        OrderedList<String> lst2 = new OrderedList<String>();

        System.out.print("Enter the number between 1000 and 1500 for List 1: ");
        int n1 = input.nextInt();
        lst1 = createRandomList(n1,allNames);

        System.out.print("Enter the number between 1000 and 1500 for List 2: ");
        int n2 = input.nextInt();
        lst2 = createRandomList(n2,allNames);

        OrderedList<String> mergedList = merge(lst1,lst2);
        OrderedList<String> commonList = common(lst1,lst2);
        OrderedList<String> differenceList = difference(mergedList,commonList);

        writeIntoFile("merged.txt",mergedList);
        writeIntoFile("common.txt",commonList);
        writeIntoFile("difference.txt",differenceList);


    }

    public static ArrayList<String> createAllNameList(){
        ArrayList<String> allNames = new ArrayList<>();
        try {
            File randomNamesFile = new File("src/RandomNames.txt");
            Scanner fileReader = new Scanner(randomNamesFile);
            while (fileReader.hasNextLine()) {
                String data = fileReader.nextLine();
                allNames.add(data);
            }
            fileReader.close();
        }
        catch (Exception e){
            System.out.println(e);
        }

        return allNames;
    }

    public static OrderedList<String> createRandomList(int size, ArrayList<String> allNames){
        Random rand = new Random();

        int allNamesSize = allNames.size();

        OrderedList<String> temp = new OrderedList<String>();

        int i=0;
        String str;

        while(temp.size()<size){
            i = rand.nextInt(allNamesSize);
            str = allNames.get(i);
            if(temp.binarySearch(str)<0) {
                temp.add(str);
            }
        }
        return temp;
    }

    public static void writeIntoFile(String filePath, OrderedList<String> list){
        try {
            FileWriter fileWriter = new FileWriter(filePath);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

            String str = list.first();
            bufferedWriter.write(str);

            while(true){
                str = list.next();
                if(str==null) break;
                else{
                    bufferedWriter.write(str);
                    bufferedWriter.newLine();
                }
            }

            bufferedWriter.close();
        }
        catch (IOException e) {
            System.out.println("An error occurred.");
        }
    }
}
