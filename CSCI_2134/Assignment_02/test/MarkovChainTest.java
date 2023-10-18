import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class MarkovChainTest {
    public static float[] floatArray1 = {1.0f, 0.0f, 1.0f, 0.0f};
    public static float[] floatArray2 = {1.0f, 0.0f, 1.0f, 0.0f, 1.0f};
    @Test
    void nextState() {
        FloatMatrix floatMatrix = new FloatMatrix(floatArray1, 2);

        MarkovChain markovChain = new MarkovChain(floatMatrix);
        int nextState = markovChain.nextState();

        assertTrue(nextState < markovChain.getNumStates(), "Invalid next state");
    }

    @Test
    void getState() {
        FloatMatrix floatMatrix = new FloatMatrix(floatArray1, 2);

        MarkovChain markovChain = new MarkovChain(floatMatrix);
        int currentState = markovChain.getState();

        assertTrue(currentState < markovChain.getNumStates(), "Invalid current state");
    }

    @Test
    void setState() {
        FloatMatrix floatMatrix = new FloatMatrix(floatArray1, 2);

        MarkovChain markovChain = new MarkovChain(floatMatrix);

        int state1 = 1;
        assertTrue(markovChain.setState(state1), "Failed to set a valid state");

        int state2 = 5;
        assertTrue(!markovChain.setState(state2), "Successfully set an invalid state");
    }

    @Test
    void getNumStates() {
        FloatMatrix floatMatrix = new FloatMatrix(floatArray1, 2);

        MarkovChain markovChain = new MarkovChain(floatMatrix);
        int numStates = markovChain.getNumStates();

        assertEquals(2, numStates, "Incorrect number of states");
    }

    @Test
    void isValidTransitionMatrix() {

        FloatMatrix floatMatrix1 = new FloatMatrix(floatArray1, 2);
        FloatMatrix floatMatrix2 = new FloatMatrix(floatArray2, 3);

        assertTrue(MarkovChain.isValidTransitionMatrix(floatMatrix1), "Valid transition matrix marked as invalid");
        assertTrue(!MarkovChain.isValidTransitionMatrix(floatMatrix2), "Invalid transition matrix marked as valid");
    }
}
