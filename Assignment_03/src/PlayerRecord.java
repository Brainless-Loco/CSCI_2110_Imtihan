public class PlayerRecord {
    private String name;
    private String position;
    private String teamName;
    private int gamesPlayed, goalsScored, assists, penaltiesMinutes, shotsOnGoal, gameWinningGoals;

    public PlayerRecord(String name, String position, String teamName, int gamesPlayed, int goalsScored, int assists, int penaltiesMinutes, int shotsOnGoal, int gameWinningGoals) {
        this.name = name;
        this.position = position;
        this.teamName = teamName;
        this.gamesPlayed = gamesPlayed;
        this.goalsScored = goalsScored;
        this.assists = assists;
        this.penaltiesMinutes = penaltiesMinutes;
        this.shotsOnGoal = shotsOnGoal;
        this.gameWinningGoals = gameWinningGoals;
    }
    public String getName() {
        return name;
    }
    public String getTeamName() {
        return teamName;
    }
    public String getPosition() {
        return position;
    }
    public int getAssists() {
        return assists;
    }
    public int getGamesPlayed() {
        return gamesPlayed;
    }
    public int getGameWinningGoals() {
        return gameWinningGoals;
    }
    public int getGoalsScored() {
        return goalsScored;
    }
    public int getPenaltiesMinutes() {
        return penaltiesMinutes;
    }
    public int getShotsOnGoal() {
        return shotsOnGoal;
    }
    public String toString(){
        return name+" "+position+" "+teamName+" "+gamesPlayed+" "+goalsScored+" "+assists+" "+penaltiesMinutes+" "+shotsOnGoal+" "+gameWinningGoals;
    }
}
