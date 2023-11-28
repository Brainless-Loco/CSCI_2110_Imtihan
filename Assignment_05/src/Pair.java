public class Pair implements Comparable<Pair> {
    private char value;
    private double prob;

    // Constructor
    public Pair(char value, double prob) {
        this.value = value;
        this.prob = prob;
    }

    // Getters
    public char getValue() {
        return value;
    }

    public double getProbability() {
        return prob;
    }

    // Setters (if needed)
    public void setValue(char value) {
        this.value = value;
    }

    public void setProbability(double prob) {
        this.prob = prob;
    }

    // toString method
    @Override
    public String toString() {
        return "Pair{" +
                "value=" + value +
                ", prob=" + prob +
                '}';
    }

    // compareTo method
    @Override
    public int compareTo(Pair p) {
        return Double.compare(this.getProbability(), p.getProbability());
    }
}
