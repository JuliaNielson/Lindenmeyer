package sample;

/**
 * Created by Gil on 4/19/2016.
 */
public class DragonCurve extends LSystem {

    public DragonCurve(){
        super();
        this.getRuleSet().add(new SymbolRule('X',"X+YF+"));
        this.getRuleSet().add(new SymbolRule('Y', "-FX-Y"));
        this.setAxiom("FX");
    }
}
