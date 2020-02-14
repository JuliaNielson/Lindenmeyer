package MyTurtle;

import javafx.scene.shape.LineTo;

import java.util.ArrayList;

/**
 * Created by Parker Nielson on 6/9/2016.
 */
public class LineManager {
    private ArrayList<LineHolder> lineHolders;

    public LineManager(){
        this.lineHolders = new ArrayList<>();
    }

    public void add(LineHolder newLineData){
        this.lineHolders.add(newLineData);
    }

    public LineTo getLineTo(double deltaX, double deltaY){
        for (LineHolder lineHolder: lineHolders){
            if (lineHolder.getDeltaX() == deltaX && lineHolder.getDeltaY() == deltaY){
                return lineHolder.getLineTo();
            }
        }
        LineTo result = new LineTo(deltaX, deltaY);
        System.out.println("New Line Created: " + deltaX + ", " + deltaY);
        result.setAbsolute(false);
        this.lineHolders.add(new LineHolder(deltaX, deltaY, result));
        return result;
    }

}
