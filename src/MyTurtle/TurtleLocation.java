package MyTurtle;

public class TurtleLocation {
    private double xLocation, yLocation, facing;


    public TurtleLocation(double xLocation, double yLocation, double facing){
        this.xLocation = xLocation;
        this.yLocation = yLocation;
        this.facing = facing;
    }

    public double getXLocation() {
        return xLocation;
    }

    public void setxLocation(double xLocation) {
        this.xLocation = xLocation;
    }

    public double getYLocation() {
        return yLocation;
    }

    public void setyLocation(double yLocation) {
        this.yLocation = yLocation;
    }

    public double getFacing() {
        return facing;
    }

    public void setFacing(double facing) {
        this.facing = facing;
    }
}
