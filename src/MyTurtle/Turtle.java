package MyTurtle;

import javafx.scene.shape.MoveTo;
import javafx.scene.shape.PathElement;

import java.util.ArrayDeque;

/**
 * Created by Gil on 4/19/2016.
 */
public class Turtle {
    private double facing;
    private double lastX, minX, maxX;
    private double lastY, minY, maxY;
    private ArrayDeque<TurtleLocation> savedLocations;
    private LineManager lineManager;
    public Turtle(){
        facing = Math.toRadians(-90);
        savedLocations = new ArrayDeque<>();
        lineManager = new LineManager();
    }

    public PathElement draw(TurtleRule rule){
        double length = rule.getLength();
        return draw(rule, length);
    }

    public PathElement draw(TurtleRule rule, double length){
        this.facing+=Math.toRadians(rule.getRotationAngle());
        if (rule.getLength()==0) {
            length = 0;
        }
        double deltaX = length*Math.cos(facing);
        if (Math.abs(deltaX)< .0000000009){
            deltaX = 0;
        }
        double deltaY = length*Math.sin(facing);
        if (Math.abs(deltaY)< .0000000009){
            deltaY = 0;
        }

        lastX += deltaX;
        if (lastX > maxX)
            maxX = lastX;
        if (lastX < minX)
            minX = lastX;

        lastY += deltaY;
        if (lastY > maxY)
            maxY = lastY;
        if (lastY < minY)
            minY = lastY;

        PathElement result;

        if (rule.isVisible()){
            result = lineManager.getLineTo(deltaX, deltaY);
        }
        else{
            result = new MoveTo(deltaX, deltaY);
        }
        result.setAbsolute(false);
        return result;
    }

    public void saveLocation(){
        TurtleLocation savedLocation = new TurtleLocation(this.lastX, this.lastY, this.facing);
        this.savedLocations.push(savedLocation);
    }

    public MoveTo returnToLast(){
        TurtleLocation returningLocation = this.savedLocations.pop();
        this.facing = returningLocation.getFacing();
        double oldY = returningLocation.getYLocation();
        double oldX = returningLocation.getXLocation();
        MoveTo result = new MoveTo(-1*this.lastX + oldX, -1*this.lastY + oldY);
        this.lastX = oldX;
        this.lastY = oldY;
        result.setAbsolute(false);
        return result;
    }

    public double getMinX() {
        //System.out.println("MinX = "+ minX);
        return minX;
    }

    public double getMaxX() {
        //System.out.println("MaxX = "+ maxX);
        return maxX;
    }

    public double getMinY() {
        //System.out.println("MinY = "+ minY);
        return minY;
    }

    public double getMaxY() {
        //System.out.println("MaxY = "+ maxY);
        return maxY;
    }
}
