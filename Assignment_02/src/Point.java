public class Point<T> {
    private T xpos;
    private T ypos;

    // Constructor
    public Point(T xpos, T ypos) {
        this.xpos = xpos;
        this.ypos = ypos;
    }

    // Getter and Setter methods for xpos
    public T getXpos() {
        return xpos;
    }

    public void setXpos(T xpos) {
        this.xpos = xpos;
    }

    // Getter and Setter methods for ypos
    public T getYpos() {
        return ypos;
    }

    public void setYpos(T ypos) {
        this.ypos = ypos;
    }

    // toString method to display Point details
    @Override
    public String toString() {
        return "Xpos: " + xpos + " Ypos: " + ypos;
    }

}
