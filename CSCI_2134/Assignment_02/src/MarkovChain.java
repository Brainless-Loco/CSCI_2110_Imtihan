import java.util.Random;

/**
 * The MarkovChain class encodes a Makrov chain with a hidden current state
 * and some transition matrix describing the probabilties of transitioning to the next state.
 * States may have String labels to identify what each state represents.
 */
public class MarkovChain {

    private FloatMatrix transitionMat;
    private Random rand;
    int curState;
    int numStates;

    /**
     * Create a MarkovChain from a transition matrix.
     * @param matrix: the transition matrix
     */
    MarkovChain(FloatMatrix matrix) {
        assert(isValidTransitionMatrix(matrix));
	
        this.transitionMat = new FloatMatrix(matrix);
        curState = 0;
        numStates = this.transitionMat.rows();

        rand = new Random(0);    
    }


    /**
     * Get the number of states for this Markov chain.
     * It is equal to the number of columns/rows in its transition matrix.
     * @return: the number of states in this Markov chain.
     */
    public int getNumStates() {
        return transitionMat.rows();
    }

    /**
     * Get the current state of the Markov chain.
     * States are 0-indexed and fall within the range 0 <= states < getNumStates().
     * @return the current state.
     */
    public int getState() {
        return curState;
    }

    /**
     * Brutally set the internal state of the Markov chain,
     * regardless of the transition matrix.
     * States of the Markov chain are 0-indexed.
     * If state is negative or greater than or equal to the number of states
     * in this Markov chain, return false and do not change the state.
     *
     * @param state: the state number to set as the current state.
     * @return true if and only if setting the state was successful.
     */
    public boolean setState(int state) {
        if (state < 0 || state > numStates) {
            return false;
        }
        curState = state;
        return true;
    }

    /**
     * Trigger the Markov chain to transition to the next state
     * based on its transition matrix.
     * This updates the current state and returns the new state.
     * @return the new state reached after the transition.
     */
    public int nextState() {
        double r = rand.nextDouble();
        double curTotal = 0.0;
        for (int i = 0;  i < numStates; ++i) {
            curTotal += transitionMat.get(curState, i);
            if (r < curTotal) {
                curState = i;
                return i;
            }
        }

        //Based on the conditions of a valid transition matrix,
        //this should never be reached because the curTotal must
        //be equal to 1 when i = numStates-1 and r belongs to [0,1).
        return 0;
    }


    /**
     * Determines if a particular FloatMatrix is a valid transition matrix
     * for a MarkovChain object.
     * If the matrix is square and, for every row in the matrix, the sum of
     * entries in that row equals 1, return true. Otherwise, return false.
     * @param M: the matrix to test if it is valid
     * @return true if and only if the matrix M is a valid transition matrix.
     */
    public static boolean isValidTransitionMatrix(FloatMatrix M) {
        if (M == null) {
            return false;
        }
        if (M.rows() < 1) {
            return false;
        }

        int R = M.rows();
        int C = M.rows();
        if (R != C) {
            return false;
        }

        //Can assume now it is an extant square matrix.
        for (int i = 0; i < R; ++i) {
            double sum = 0.0;
            //compute a sum across the row
            for (int j = 0; j < C; ++j) {
                sum += M.get(i, j);
            }

            if (Math.abs(sum - 1.0) > FloatMatrix.EPSILON) {
                return false;
            }
            sum = 0.0;
        }

        return true;
    }

}
