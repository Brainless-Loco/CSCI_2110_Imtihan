import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

/**
 * A main class for orchestrating a random walk.
 * @author Alex Brandt; abrandt@dal.ca
 */
public class WalkSim {

    /**
     * The main method for a random walk simulation.
     * First reads a file which encodes a Markov chain's transition matrix,
     * and then performs a random walk.
     * Command line arguments:
     *    [0]: the file containing the FloatMatrix for the Markov chain
     *    [1]: the output file to store the path produced
     *    [2]: the number of steps to simulate
     */
    public static void main(String[] args) {

        String exampleFile = "test_cases/example2.txt";
        String outputFile = "output3.txt";

        int nSteps = 200;
        int stepDuration = 30;
        if (args.length > 0) {
            exampleFile = args[0];
        }
        if (args.length > 1) {
            outputFile = args[1];
        }
        if (args.length > 2) {
            try {
                int steps = Integer.parseInt(args[2]);
                nSteps = steps;
            } catch (NumberFormatException nfe) {
                System.out.println("Could not use args[1] since it was not an integer: " + args[1]);
                System.out.printf("Defaulting to %d steps.", nSteps);
            }
        }

        String[] cardinals = {"N", "E", "S", "W"};
        FloatMatrix T1 = null;
        try {
            T1 = FloatMatrix.fromFile(exampleFile);
            assert T1.rows() == 4 : "Walker MarkovChain should have 4 states";

            MarkovChain mc = new MarkovChain(T1, cardinals);
            RandomWalker walker = new RandomWalker(mc);

            ArrayList<Coordinate> theWalk = walker.walk(nSteps);
            walker.saveWalkToFile(outputFile);

            WalkFrame walkFrame = new WalkFrame();
            walkFrame.animatePath(theWalk, stepDuration);

        } catch (FileNotFoundException fnfe) {
            System.out.println("Could not find the specified matrix file.");
            System.out.println(fnfe.toString());
            System.exit(1);

        } catch (IOException ioe) {
            System.out.println("Could not save walk to file: " + outputFile);
            System.out.println(ioe.getMessage());
            System.exit(1);

        }

    }
}
