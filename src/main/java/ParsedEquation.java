import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class ParsedEquation {
    String equation;
    List<HashMap<Integer, String>> elements;
    List<HashMap<Integer, String>> terms;

    public ParsedEquation(String equation) {
        this.equation = equation;
    }

    public Object parseEquation() throws BalanceException {
        if (!equation.contains("-->")) {
            throw new BalanceException("Equation does not contain yields symbol (\"-->\")");
        }

        String[] sides = equation.split("-->");

        List<List<String>> terms = new ArrayList<>();
        for (String side : sides) {
            List<String> sideTerms = Arrays.asList(side.split("\\+"));
            List<String> tempSideTerms = new ArrayList<String>();

            for (String term : sideTerms) {
                tempSideTerms.add(term.replace(" ", ""));
            }

            sideTerms = tempSideTerms;
            terms.add(sideTerms);
        }

        return terms;
    }

    /*
      Returns the coefficient if there is one, or -1 if there isn't
     */
    private int parseCoefficient(String string) {
        String digits = "";

        for (char character : string.toCharArray()) {
            if (Character.isDigit(character)) {

            }
        }
    }
}
