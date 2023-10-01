public class Field {
    private double xpos, ypos, length, width;

    public Field(double xpos, double ypos, double length, double width){
        this.xpos = xpos;
        this.ypos = ypos;
        this.length = length;
        this.width = width;
    }

    public double getXpos() {
        return xpos;
    }
    public double getYpos() {
        return ypos;
    }
    public double getLength() {
        return length;
    }
    public double getWidth() {
        return width;
    }

    public String toString(){
        return "Field: ["+xpos+","+ypos+"]"+length+","+width;
    }
}

