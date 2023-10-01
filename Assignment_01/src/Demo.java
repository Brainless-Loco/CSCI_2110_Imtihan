import java.util.Random;

public class Demo{
    public static void main(String[] args){
        double epsilon = 0.00000001d;

        Field field = new Field(0,0,1000,1000);
        Ball ball = new Ball(100,200);
        Player player1 = new Player("Chris Hemsworth");
        Player player2 = new Player("Chris Evan");


        System.out.println("SOCCER GAME SETUP!");
        System.out.println(field.toString());
        System.out.println(ball.toString());
        System.out.println("Player 1: "+player1.toString());
        System.out.println("Player 2: "+player2.toString());
        System.out.println(""); //extra new Line
        

        int i =1;
        double prevX,prevY,newX,newY;
        double distance, angle;

        for(i=1;i<=10;i++){

            //Player 1 Kicks here
            prevX = ball.getBx(); prevY = ball.getBy();
            distance = getRandomDistance(); angle = getRandomAngle();

            System.out.println("Player "+player1.toString()+" kicks the ball for a distance of "+distance+" pixels at "+angle+" degrees");
            player1.kick(field,ball,getRandomDistance(),getRandomAngle());
            System.out.println("Ball is at ("+ball.getBx()+","+ball.getBy()+")");

            newX = ball.getBx(); newY = ball.getBy();

            if(Math.abs(newX-prevX)>epsilon || Math.abs(newY-prevY)>epsilon){
                System.out.println("The Ball is reflected");
            }
            else{
                System.out.println("The Ball is not reflected");
            }

            System.out.println(""); //extra new Line


            //Player 2 Kicks here
            prevX = ball.getBx(); prevY = ball.getBy();
            distance = getRandomDistance(); angle = getRandomAngle();

            System.out.println("Player "+player2.toString()+" kicks the ball for a distance of "+distance+" pixels at "+angle+" degrees");
            player1.kick(field,ball,getRandomDistance(),getRandomAngle());
            System.out.println("Ball is at ("+ball.getBx()+","+ball.getBy()+")");

            newX = ball.getBx(); newY = ball.getBy();

            if(Math.abs(newX-prevX)>epsilon || Math.abs(newY-prevY)>epsilon){
                System.out.println("The Ball is reflected");
            }
            else{
                System.out.println("The Ball is not reflected");
            }

            System.out.println(""); //extra new Line

        }
    }
    public static double getRandomDistance(){
//        double random = (int) (Math.random()*(max-min+1)+min);
        double random = (double) (Math.random()*(1000-0+1)+0);
        return random;
    }

    public static double getRandomAngle(){
        double random = (double) (Math.random()*(360-0+1)+0);
        return random;
    }
}