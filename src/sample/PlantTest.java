package sample;

import MyTurtle.TurtleRule;

/**
 * Created by Gil on 4/20/2016.
 */
public class PlantTest extends LSystem {
    public PlantTest(){
        super(31);
        this.getRuleSet().add(new SymbolRule('X', "A-[[X]+X]+A[+AX]-X" ));
        this.getRuleSet().add(new SymbolRule('A',"AA",new TurtleRule(0,10,true)));
        this.setAxiom("X");
    }
}
