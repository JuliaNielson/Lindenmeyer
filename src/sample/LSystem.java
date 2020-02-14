package sample;

import MyTurtle.Turtle;
import MyTurtle.TurtleRule;
import javafx.scene.shape.Path;
import javafx.scene.shape.PathElement;

import java.util.ArrayList;

/**
 * Created by Gil on 4/6/2016.
 */
public class LSystem {
    private RuleSet ruleSet;
    private String axiom;
    private Turtle turtle;

    public LSystem(){
        this(90);
    }


    public LSystem(double angle) {
        this.axiom = "F";
        this.ruleSet = new RuleSet();

        TurtleRule fRule = new TurtleRule(0, 10, true);
        this.ruleSet.add(new SymbolRule('F', "F", fRule));

        TurtleRule plusRule = new TurtleRule(angle,0);
        this.ruleSet.add(new SymbolRule('+', "+", plusRule));

        TurtleRule minusRule = new TurtleRule(angle*-1,0);
        this.ruleSet.add(new SymbolRule('-', "-", minusRule));
        this.ruleSet.add(new SymbolRule('[',"["));
        this.ruleSet.add(new SymbolRule(']',"]"));

        this.turtle = new Turtle();
    }

    public LSystem(RuleSet ruleSet, String axiom) {
        this.ruleSet = ruleSet;
        this.axiom = axiom;
        this.turtle= new Turtle();
    }

    public ArrayList<PathElement> getPathElements(int iterations){
        ArrayList<PathElement> result = new ArrayList<>();
        String stringToDraw = this.getString(iterations);
        for(int i = 0; i < stringToDraw.length();i++){
            char c = stringToDraw.charAt(i);
            if (c == '['){
                turtle.saveLocation();
            }
            else if (c == ']'){
                result.add(turtle.returnToLast());
            }
            else{
                TurtleRule tempRule = this.getDrawRuleByChar(c);
                result.add(turtle.draw( tempRule, 20));
            }
        }

        return result;
    }


    public String getString(int iter) {
        String result = this.axiom;
        for (int i = 0; i < iter; i++)
        {
            result = this.iterateString(result);
            if (result.length()>200001){
                System.out.println("Your string was too long, and canceled. Better to fail quickly than slowly");
                return "";
            }
        }
        return result;
    }

    public String getAxiom() {
        return axiom;
    }

    public void setAxiom(String axiom) {
        this.axiom = axiom;
    }

    public RuleSet getRuleSet() {
        return ruleSet;
    }

    public void setRuleSet(RuleSet ruleSet) {
        this.ruleSet = ruleSet;
    }

    public String iterateString(String input){
        String result = "";
        for (int i = 0; i < input.length(); i++){
            int index = this.getRuleSet().getCharacters().indexOf(input.charAt(i));
            if (index>=0)
            {result += this.getRuleSet().getSymbolRules().get(index).getRule();}
            else
            {result += input.charAt(i);}
        }


        return result;
    }

    public TurtleRule getDrawRuleByChar(char c)
    {
        return this.getRuleSet().getDrawRuleByChar(c);
    }

    public double getMinX() {
        return turtle.getMinX();
    }

    public double getMaxX() {
        return turtle.getMaxX();
    }

    public double getMinY() {
        return turtle.getMinY();
    }

    public double getMaxY() {
        return turtle.getMaxY();
    }

    public double getMidX(){
        double result = (turtle.getMaxX() + turtle.getMinX())/2;
        return result;
    }
    public double getMidY(){
        double result = (turtle.getMaxY() + turtle.getMinY())/2;
        return result;
    }
    public double getTotalX(){
        double result = (Math.abs(turtle.getMaxX())+Math.abs(turtle.getMinX()));
        return result;
    }
    public double getTotalY(){
        double result = (Math.abs(turtle.getMaxY())+Math.abs(turtle.getMinY()));
        return result;
    }

}