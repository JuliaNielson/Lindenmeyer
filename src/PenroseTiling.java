import MyTurtle.TurtleRule;
import sample.LSystem;
import sample.SymbolRule;

/**
 * Created by Gil on 4/26/2016.
 */
public class PenroseTiling extends LSystem {

    public PenroseTiling(){
        super(36);
        TurtleRule aRule = new TurtleRule(0,10,true);
        this.getRuleSet().add(new SymbolRule('A',"", aRule));
        this.getRuleSet().add(new SymbolRule('M',"OA++PA----NA[-OA----MA]++"));

        this.getRuleSet().add(new SymbolRule('N',"+OA--PA[---MA--NA]+"));
        this.getRuleSet().add(new SymbolRule('O',"-MA++NA[+++OA++PA]-"));
        this.getRuleSet().add(new SymbolRule('P',"--OA++++MA[+PA++++NA]--NA"));
        this.setAxiom("[N]++[N]++[N]++[N]++[N]");
    }
}
