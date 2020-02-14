package MyTurtle;

/**
 * Created by Gil on 4/19/2016.
 */
public class TurtleRule {

    private double rotationAngle;
    private double length;
    private boolean visible;
    private boolean special;



    public TurtleRule(){
        this(0, 0, false);
    }

    public TurtleRule(double angle, double length){
        this(angle, length, true);
    }

    public TurtleRule(double angle, double length, boolean visible){
        this.rotationAngle=angle;
        this.length=length;
        this.visible=visible;
        this.special = false;
    }

    public double getRotationAngle() {
        return rotationAngle;
    }

    public double getLength() {
        return length;
    }

    public boolean isVisible() {
        return visible;
    }

    public static TurtleRule NullTurtleRule(){
        System.out.println("Null TurtleRule Created, you probably didn't want that");
        return new TurtleRule();
    }

    public boolean isSpecial() {
        return special;
    }

}
