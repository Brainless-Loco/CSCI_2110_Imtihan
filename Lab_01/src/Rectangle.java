public class Rectangle{ //instance variables
    private int xpos, ypos, width, height;

    //constructors
    public Rectangle(){

    }
    public Rectangle(int xpos, int ypos, int width, int height){
        this.xpos=xpos;
        this.ypos=ypos;
        this.width=width;
        this.height=height;
    }
    //setters and getters
    public void setX(int xpos){
        this.xpos=xpos;
    }
    public void setY(int ypos){
        this.ypos=ypos;
    }
    public void setWidth(int width){
        this.width=width;
    }
    public void setHeight(int height){
        this.height=height;
    }
    public int getX(){
        return xpos;
    } public int getY(){
        return ypos;
    }
    public int getWidth(){
        return width;
    }
    public int getHeight(){
        return height;
    }
    //other methods: moveTo changes xpos and ypos and resize changes
    //width and height public void moveTo(int xpos, int ypos){this.xpos=xpos; this.ypos=ypos;} public void resize(int width, int height){this.width=width; this.height=height;}
    //toString method
    public String toString(){
        return "[xpos= " +xpos+","+"ypos= " + ypos+"] width: " + width+",height: "+height;
    }
}