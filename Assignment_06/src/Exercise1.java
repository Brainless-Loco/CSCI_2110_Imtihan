import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Exercise1 {
    public static void main(String[] args) {
        HashMap<String,String> password = new HashMap<>();
        HashMap<String,String> fullname = new HashMap<>();
        StringTokenizer tokenizer;

        int tempSize;
        String tempUsername,tempPassword,tempFullName;
        ArrayList<String> temp;


        try {
            File inputFile = new File("src/input.txt");
            Scanner fileReader = new Scanner(inputFile);
            while (fileReader.hasNextLine()) {
                String record = fileReader.nextLine();
                tokenizer = new StringTokenizer(record, " ");
                temp = new ArrayList<String>();

                while(tokenizer.hasMoreTokens()){
                    temp.add(tokenizer.nextToken());
                }

                tempSize = temp.size();
                tempUsername = temp.get(tempSize-2);
                tempPassword = temp.get(tempSize-1);
                tempFullName= "";

                for(int i =0;i<tempSize-2;i++){
                    tempFullName += temp.get(i);
                    tempFullName += " ";
                }

                password.put(tempUsername,tempPassword);
                fullname.put(tempUsername,tempFullName);

            }
            fileReader.close();
        }
        catch (Exception e){
            System.out.println(e);
        }

        int trial = 3;
        String UsernameInput,PasswordInput;
        Scanner input = new Scanner(System.in);

        while(true){
            trial--;
            System.out.print("Login: ");
            UsernameInput = input.nextLine();
            System.out.print("Password: ");
            PasswordInput = input.nextLine();
            if(password.get(UsernameInput).equals(PasswordInput)){
                System.out.println("Login successful\nWelcome "+fullname.get(UsernameInput));
                break;
            }
            else if(trial>0){
                System.out.print("Either the username or password is incorrect. You have "+trial+" more attempt");
                if(trial>1){
                    System.out.println("s.");
                }
                else{
                    System.out.println(".");
                }
            }
            else if(trial==0){
                System.out.println("Sorry. Incorrect login. Please contact the system administrator.");
                break;
            }
        }


    }

}
