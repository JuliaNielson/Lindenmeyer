package sample;

import MyTurtle.TurtleRule;
import javafx.scene.shape.PathElement;

/**
 * Created by Gil on 4/6/2016.
 */
public class SymbolRule {
    private char symbol;
    private String rule;
    private TurtleRule drawRule;

    public SymbolRule(char s){
        this.symbol = s;
        this.rule = ""+s;
        this.drawRule = new TurtleRule(0,0,false);
    }

    public SymbolRule(char s, String r){
        this.symbol=s;
        this.rule = r;
        this.drawRule = new TurtleRule(0,0,false);
    }

    public SymbolRule(char s, String r, TurtleRule turtleRule){
        this.symbol=s;
        this.rule=r;
        this.drawRule=turtleRule;
    }

    public TurtleRule getDrawRule(){
        return this.drawRule;
    }

    public String getRule() {
        return rule;
    }

    public void setRule(String rule) {
        this.rule = rule;
    }

    public char getSymbol() {
        return symbol;
    }

    public void setSymbol(char symbol) {
        this.symbol = symbol;
    }
}
