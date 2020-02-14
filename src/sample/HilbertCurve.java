package sample;

import MyTurtle.TurtleRule;

/**
 * Created by Gil on 4/19/2016.
 */
public class HilbertCurve extends LSystem{

    public HilbertCurve()
    {
        super();
        RuleSet ruleSet = this.getRuleSet();
        TurtleRule aRule = new TurtleRule(0, 0);
        ruleSet.add(new SymbolRule('A', "-BF+AFA+FB-", aRule));
        TurtleRule bRule = new TurtleRule(0, 0);
        ruleSet.add(new SymbolRule('B', "+AF-BFB-FA+", bRule));
        this.setRuleSet(ruleSet);
        this.setAxiom("A");
    }


}
