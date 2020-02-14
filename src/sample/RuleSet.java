package sample;

import MyTurtle.TurtleRule;

import java.util.ArrayList;

/**Intellij, you're the best.
 * Created by Gil on 4/8/2016.
 */
public class RuleSet {
    private ArrayList<SymbolRule> symbolRules;
    private ArrayList<Character> characters;

    public RuleSet(){
        this.symbolRules = new ArrayList<>(10);
        this.characters = new ArrayList<>();
    }

    public void add(SymbolRule symbolRule){
        this.symbolRules.add(symbolRule);
        this.characters.add(symbolRule.getSymbol());
    }

    public TurtleRule getDrawRuleByChar(char c){
        int index = characters.indexOf(c);
        if (index != -1){
            return symbolRules.get(index).getDrawRule();
        }

        return TurtleRule.NullTurtleRule();
    }

    public ArrayList<SymbolRule> getSymbolRules() {
        return symbolRules;
    }

    public void setSymbolRules(ArrayList<SymbolRule> symbolRules) {
        this.symbolRules = symbolRules;
    }

    public ArrayList<Character> getCharacters() {
        return characters;
    }
}
