import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class EquationUtils {
    public List<HashMap<String, Integer>> getTerms(String equation) {
        String[] sides = equation.split("-->");

        List<List<String>> terms = new ArrayList<>();
        for (String side : sides) {
            List<String> sideTerms = Arrays.asList(side.split("\\+"));
            List<String> tempSideTerms = new ArrayList<>();

            for (String term : sideTerms) {
                tempSideTerms.add(term.replace(" ", ""));
            }

            sideTerms = tempSideTerms;
            terms.add(sideTerms);
        }

        List<HashMap<String, Integer>> termsHashMap = new ArrayList<>();

        for (List<String> sideTerms : terms) {
            HashMap<String, Integer> sideTermsHashMap = new HashMap<>();

            for (String term : sideTerms) {
                int coefficient = parseCoefficient(term);
                term = coefficient == -1 ? term : term.replace(String.valueOf(coefficient), "");
                sideTermsHashMap.put(term, coefficient);
            }

            termsHashMap.add(sideTermsHashMap);
        }

        return termsHashMap;
    }

    /*
      Returns the coefficient if there is one, or -1 if there isn't
     */
    private int parseCoefficient(String string) {
        String digits = "";

        for (char character : string.toCharArray()) {
            if (!Character.isDigit(character)) {
                break;
            }

            digits += character;
        }

        return digits.equals("") ? -1 : Integer.parseInt(digits);
    }
}
