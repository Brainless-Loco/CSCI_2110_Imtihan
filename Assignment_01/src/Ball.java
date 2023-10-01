public class Ball {
    private double bx,by;
    public Ball(double bx, double by){
        this.bx = bx;
        this.by = by;
    }

    public double getBx() {
        return bx;
    }

    public double getBy() {
        return by;
    }

    public void setBx(double bx) {
        this.bx = bx;
    }

    public void setBy(double by) {
        this.by = by;
    }

    public String toString(){
        return "Ball is at ("+bx+","+by+")";
    }
}
