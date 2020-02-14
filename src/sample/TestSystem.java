package sample;

import MyTurtle.TurtleRule;

/**
 * Created by Gil on 4/8/2016.
 */
public class TestSystem extends LSystem {

    public TestSystem(){
        super();
        RuleSet ruleSet = new RuleSet();
        TurtleRule fRule = new TurtleRule(0,10);
        ruleSet.add(new SymbolRule('f', "fg",fRule));

        TurtleRule gRule = new TurtleRule(35, 10);

        ruleSet.add(new SymbolRule('g', "gfh", gRule));
        TurtleRule hRule = new TurtleRule(-35, 10);
        ruleSet.add(new SymbolRule('h', "h", hRule));
        this.setRuleSet(ruleSet);
        this.setAxiom("f");

    }

}
