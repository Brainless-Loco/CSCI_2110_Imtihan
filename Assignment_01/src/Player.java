public class Player {
    private String name;
    public Player(String name){
        this.name = name;
    }
    public String toString(){
        return name;
    }

    public void kick(Field f,Ball b,double d,double r){
        double r_radians = Math.toRadians(r);
        double sinValue = Math.sin(r_radians);
        double cosValue = Math.cos(r_radians);

        double newX = b.getBx()+d*cosValue;
        double newY = b.getBy()+d*sinValue;

        double fieldX1 = f.getXpos(),fieldX2 = f.getXpos()+ f.getLength();
        double fieldY1 = f.getYpos(),fieldY2 = f.getYpos()+f.getWidth();

        if(newX<fieldX1 || newX>fieldX2) newX = b.getBx();
        if(newY<fieldY1 || newY>fieldY2) newY = b.getBy();

        b.setBx(newX);
        b.setBy(newY);

    }
}
