public class Circle {
    private double xpos,ypos,radius;
    public Circle(double xpos,double ypos, double radius){
        this.xpos = xpos;
        this.ypos = ypos;
        this.radius = radius;
    }

    public double getXpos() {
        return xpos;
    }
    public double getYpos() {
        return ypos;
    }
    public double getRadius() {
        return radius;
    }
    public void setCenter(double xpos, double ypos) {
        this.xpos = xpos;
        this.ypos = ypos;
    }
    public void setRadius(double radius) {
        this.radius = radius;
    }
    public boolean contains(Circle c){
        if(c.getXpos()+c.getRadius()<xpos+radius && c.getXpos()-c.radius>xpos-radius){
            return true;
        }
        else return false;
    }
    public boolean touches(Circle c) {
        double distance = Math.sqrt(Math.pow(xpos - c.getXpos(), 2) + Math.pow(ypos - c.getYpos(), 2));
        double sumOfRadii = radius + c.getRadius();

        return Math.abs(distance - sumOfRadii) < 1e-6; // Use a small epsilon to account for double precision errors
    }

}
