public class Rectangle1{ //instance variables
    private int xpos, ypos, width, height;
    //constructors
    public Rectangle1(){}
    public Rectangle1(int xpos, int ypos, int width, int height){
        this.xpos=xpos; this.ypos=ypos; this.width=width; this.height=height;
    }
    //setters and getters public void setX(int xpos){this.xpos=xpos;}
    public void setY(int ypos){this.ypos=ypos;}
    public void setWidth(int width){this.width=width;}
    public void setHeight(int height){this.height=height;}
    public int getX(){return xpos;}
    public int getY(){return ypos;}
    public int getWidth(){
        return width;}
    public int getHeight(){
        return height;
    }

    //other methods: moveTo changes xpos and ypos and resize changes
    //width and height
    public void moveTo(int xpos, int ypos){
        this.xpos=xpos; this.ypos=ypos;
    }
    public void resize(int width, int height){
        this.width=width; this.height=height;
    }
    //toString method
     public String toString(){
        return "[xpos= " +xpos+","+"ypos= " + ypos+"] width: " +width+",height: "+height;
    }

    //contains method: returns true if a point (px, py) is contained within this rectangle //contains also returns true if the point touches the rectangle

    //contains method for Exercise 1
//    public boolean contains(int px, int py) {
//        return (px>=xpos && px<=xpos+width && py>=ypos && py<= ypos+height);
//    }

    //contains method: returns true if another rectangle r is contained within this rectangle //returns true if the rectangle touches the boundaries
    //it uses the point contains method
    public boolean contains(Rectangle1 r) {
        return(this.contains(r.getX(),r.getY())&&
                this.contains(r.getX() + r.getWidth(), r.getY()+r.getHeight()));
    }






    //Modification of contains method for Exercise 2
    public boolean contains(int px, int py) {
        return (px>xpos && px<xpos+width && py>ypos && py<ypos+height);
    }
    public boolean touches(Rectangle1 r) {
        if(this.contains(r)==true) return false;
        if(xpos>r.getX()+r.getHeight() || xpos+height<r.getX()) return false;
        if(ypos>r.getY()+r.getHeight() || ypos+height<r.getY()) return false;
        return true;
    }


}