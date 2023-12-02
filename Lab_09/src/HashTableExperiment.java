//Hash Table Experiment
//This is a simple demo program that
//creates an ArrayList of LinkedList of Integer objects
//It first displays the empty linked lists
//It then hashes some keys and displays the linked lists again
//It uses the generic LinkedList class and the generic Node class

//MODIFY THIS PROGRAM TO DO THE LAB EXERCISE 
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;
public class HashTableExperiment
{
	public static void main(String[] args)
	{
		//prompt the user to enter the table size
		Scanner keyboard = new Scanner(System.in);
		System.out.print("Enter the hash table size: ");
		int n = keyboard.nextInt();


		ArrayList<LinkedList<Integer>> hashtable = new ArrayList<LinkedList<Integer>>();
		for (int i=0; i<n; i++)
		{
			hashtable.add(i, new LinkedList<Integer>());
		}
		//Display the arraylist of linked lists
		System.out.println("Empty lists");
		for (int i=0; i<n; i++)
		{
			System.out.print(i + ": ");
			hashtable.get(i).enumerate();
			System.out.println("null");
		}


		System.out.print("Enter the number of keys to be hashed: ");
		int keys = keyboard.nextInt();


		ArrayList<Integer> randomList = randomGenerator(keys);

		for(int i=0;i<keys;i++){
			int num = randomList.get(i);
			hashtable.get(num%n).add(num);
		}
		
		//Display the arraylist of linked lists
		System.out.println();
		System.out.println("After the keys are hashed");

		for (int i=0; i<n; i++)
		{
			System.out.print(i + ": ");
			hashtable.get(i).enumerate();
			System.out.println("--> null");
		}

		double loadFactor = keys/n;
		int maximumLength = 0,collisions = 0;

		for (int i=0;i<n;i++){
			maximumLength = Math.max(maximumLength, hashtable.get(i).size());
			collisions += Math.max(0,hashtable.get(i).size()-1);
		}

		System.out.println("Statistics:\n");

		System.out.println("Table Size: "+n);
		System.out.println("Number of Keys: "+keys);
		System.out.println("Load Factor: "+loadFactor);

		System.out.println("\nNumber of collisions: "+collisions);
		System.out.println("Longest list: "+maximumLength);



			
	}
	public static ArrayList<Integer> randomGenerator(int size){
		ArrayList<Integer> list = new ArrayList<>();
		Random random = new Random();
		Integer num;

		while(list.size()<size){
			num = random.nextInt(1000) + 1;
			list.add(num);
		}
		return  list;
	}

}
			
		
