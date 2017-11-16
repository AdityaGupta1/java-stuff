import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class EquationBalancer {
    public Object balanceEquation(String equation) throws BalanceException {
        ParsedEquation parsedEquation = new ParsedEquation(equation);
        return parsedEquation;
    }
}
