package MyTurtle;

import javafx.scene.shape.LineTo;

/**
 * Created by Parker Nielson on 6/10/2016.
 */
public class LineHolder {
    private LineTo lineTo;
    private double[] delta;

    public LineHolder(double deltaX, double deltaY, LineTo lineTo){
        this.delta = new double[2];
        this.delta[0] = deltaX;
        this.delta[1] = deltaY;
        this.lineTo = lineTo;
    }

    public LineTo getLineTo() {
        return lineTo;
    }

    public double getDeltaX(){
        return delta[0];
    }

    public double getDeltaY(){
        return delta[1];
    }


}
