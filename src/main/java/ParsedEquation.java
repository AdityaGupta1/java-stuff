import java.util.HashMap;
import java.util.List;

public class ParsedEquation {
    String equation;
    List<HashMap<String, Integer>> terms;
    List<HashMap<String, Integer>> elements;

    private EquationUtils utils = new EquationUtils();

    public ParsedEquation(String equation) {
        this.equation = equation;
    }

    public Object parseEquation() throws BalanceException {
        if (!equation.contains("-->")) {
            throw new BalanceException("Equation does not contain yields symbol (\"-->\")");
        }

        this.terms = utils.getTerms(equation);

        return this.terms;
    }
}
