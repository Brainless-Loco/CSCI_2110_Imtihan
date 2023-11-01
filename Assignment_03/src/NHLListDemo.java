import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.StringTokenizer;

public class NHLListDemo {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Please Enter the name of the input file: ");
        String filePath = input.nextLine();

        NHLStats nhlStats = new NHLStats();
        StringTokenizer tokenizer;

        try {
            File nhlstatsFile = new File(filePath);
            Scanner fileReader = new Scanner(nhlstatsFile);
            PlayerRecord tempPlayer;
            while (fileReader.hasNextLine()) {
                String data = fileReader.nextLine();
                tokenizer = new StringTokenizer(data, "\t");
                ArrayList<String> temp = new ArrayList<String>();
                while(tokenizer.hasMoreTokens()){
                    temp.add(tokenizer.nextToken());
                }
                nhlStats.addPlayer(makePlayerRecord(temp));
            }
            fileReader.close();
        }
        catch (Exception e){
            System.out.println(e);
        }
        try {
            FileWriter fileWriter = new FileWriter("nhlstatsoutput.txt");
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            bufferedWriter.write("NHL Results Summary\n");
            nhlStats.displayPlayersWithMostPoints(bufferedWriter);
            nhlStats.displayMostAggresivePlayers(bufferedWriter);
            nhlStats.displayMVPPlayers(bufferedWriter);
            nhlStats.displayMostPromisingPlayers(bufferedWriter);
            nhlStats.displayTeamsWithMostPenaltyMinutes(bufferedWriter);
            nhlStats.displayTeamsWithMostGameWinningGoals(bufferedWriter);

            bufferedWriter.close();
        }
        catch (Exception e){
            System.out.println(e);
        }


    }
    public static PlayerRecord makePlayerRecord(ArrayList<String> temp){
        String name = temp.get(0);
        String position = temp.get(1);
        String teamName = temp.get(2);
        int gamesPlayed = Integer.parseInt(temp.get(3));
        int goalsScored = Integer.parseInt(temp.get(4));
        int assists = Integer.parseInt(temp.get(5));
        int penaltiesMinutes = Integer.parseInt(temp.get(6));
        int shotsOnGoal = Integer.parseInt(temp.get(7));
        int gameWinningGoals = Integer.parseInt(temp.get(8));
        return new PlayerRecord(name,position,teamName,gamesPlayed,goalsScored,assists,penaltiesMinutes,shotsOnGoal,gameWinningGoals);
    }
}
