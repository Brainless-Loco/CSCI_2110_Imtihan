import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

public class NHLStats {
    private List<PlayerRecord> playerRecordList;
    public NHLStats(){
        playerRecordList = new List<PlayerRecord>();
    }
    public void addPlayer(PlayerRecord p){
        playerRecordList.add(p);
    }
    public void displayPlayersWithMostPoints(BufferedWriter bufferedWriter){
        int max = -1;
        ArrayList<PlayerRecord> temp = new ArrayList<PlayerRecord>();

        PlayerRecord player = playerRecordList.first();

        while (player != null) {
            int points = player.getGoalsScored() + player.getAssists();
            if (points>max) {
                max = points;
                temp.clear();
                temp.add(player);
            }
            else if (points==max) {
                temp.add(player);
            }

            player = playerRecordList.next();
        }
        try {
            bufferedWriter.write("Players with highest points and their teams:\n");
            int i, size = temp.size();
            for(i=0;i<size;i++){
                bufferedWriter.write("Player Name: "+temp.get(i).getName()+"  "+"Team Name: "+temp.get(i).getTeamName()+"\n");
            }
            bufferedWriter.write("\n");
        }
        catch (IOException e) {
            System.out.println("An error occurred.");
        }


    }
    public void displayMostAggresivePlayers(BufferedWriter bufferedWriter){
        int max = -1;
        ArrayList<PlayerRecord> temp = new ArrayList<PlayerRecord>();

        PlayerRecord player = playerRecordList.first();

        while (player != null) {
            int points = player.getPenaltiesMinutes();
            if (points>max) {
                max = points;
                temp.clear();
                temp.add(player);
            }
            else if (points==max) {
                temp.add(player);
            }

            player = playerRecordList.next();
        }
        try {
            bufferedWriter.write("Most aggressive players, their teams and their positions:\n");
            int i, size = temp.size();
            for(i=0;i<size;i++){
                bufferedWriter.write("Player Name: "+temp.get(i).getName()+"  "+"Team Name: "+temp.get(i).getTeamName()+
                        " "+ temp.get(i).getPosition()+"\n");
            }
            bufferedWriter.write("\n");
        }
        catch (IOException e) {
            System.out.println("An error occurred.");
        }
    }
    public void displayMVPPlayers(BufferedWriter bufferedWriter){
        int max = -1;
        ArrayList<PlayerRecord> temp = new ArrayList<PlayerRecord>();

        PlayerRecord player = playerRecordList.first();

        while (player != null) {
            int points = player.getGameWinningGoals();
            if (points>max) {
                max = points;
                temp.clear();
                temp.add(player);
            }
            else if (points==max) {
                temp.add(player);
            }

            player = playerRecordList.next();
        }
        try {
            bufferedWriter.write("Most valuable players and their teams:\n");
            int i, size = temp.size();
            for(i=0;i<size;i++){
                bufferedWriter.write("Player Name: "+temp.get(i).getName()+"  "+"Team Name: "+temp.get(i).getTeamName()+"\n");
            }
            bufferedWriter.write("\n");
        }
        catch (IOException e) {
            System.out.println("An error occurred.");
        }

    }
    public void displayMostPromisingPlayers(BufferedWriter bufferedWriter){
        int max = -1;
        ArrayList<PlayerRecord> temp = new ArrayList<PlayerRecord>();

        PlayerRecord player = playerRecordList.first();

        while (player != null) {
            int points = player.getShotsOnGoal();
            if (points>max) {
                max = points;
                temp.clear();
                temp.add(player);
            }
            else if (points==max) {
                temp.add(player);
            }

            player = playerRecordList.next();
        }
        try {
            bufferedWriter.write("Most promising players and their teams:\n");
            int i, size = temp.size();
            for(i=0;i<size;i++){
                bufferedWriter.write("Player Name: "+temp.get(i).getName()+"  "+"Team Name: "+temp.get(i).getTeamName()+"\n");
            }
            bufferedWriter.write("\n");
        }
        catch (IOException e) {
            System.out.println("An error occurred.");
        }
    }
    public void displayTeamsWithMostPenaltyMinutes(BufferedWriter bufferedWriter){
        HashMap<String, Integer> temp = new HashMap<>();

        PlayerRecord player = playerRecordList.first();

        while (player != null) {
            String teamName = player.getTeamName();
            int penaltyMinutes = player.getPenaltiesMinutes();

            temp.put(teamName, temp.getOrDefault(teamName, 0) + penaltyMinutes);

            player = playerRecordList.next();
        }

        int max = -1;

        for (int penaltyMinutes : temp.values()) {
            if (penaltyMinutes > max) {
                max = penaltyMinutes;
            }
        }
        try {
            bufferedWriter.write("Teams that had the most number of penalty minutes:\n");
            for (HashMap.Entry<String, Integer> entry : temp.entrySet()) {
                if (entry.getValue() == max) {
                    bufferedWriter.write("Team Name: "+entry.getKey()+" Total Penalty Minutes: "+ entry.getValue()+"\n");
                }
            }
            bufferedWriter.write("\n");
        }
        catch (IOException e) {
            System.out.println("An error occurred.");
        }

    }
    public void displayTeamsWithMostGameWinningGoals(BufferedWriter bufferedWriter){
        HashMap<String, Integer> temp = new HashMap<>();

        PlayerRecord player = playerRecordList.first();

        while (player != null) {
            String teamName = player.getTeamName();
            int gameWinningGoals = player.getGameWinningGoals();

            temp.put(teamName, temp.getOrDefault(teamName, 0) + gameWinningGoals);

            player = playerRecordList.next();
        }

        int max = -1;

        for (int gameWinningGoals : temp.values()) {
            if (gameWinningGoals > max) {
                max = gameWinningGoals;
            }
        }

        try {
            bufferedWriter.write("Teams that had the most number of game winning goals:\n");
            for (HashMap.Entry<String, Integer> entry : temp.entrySet()) {
                if (entry.getValue() == max) {
                    bufferedWriter.write("Team Name: "+entry.getKey()+" Total Game Winning Goals: "+ entry.getValue()+"\n");
                }
            }
            bufferedWriter.write("\n");
        }
        catch (IOException e) {
            System.out.println("An error occurred.");
        }
    }
}
