import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ParsedEquation equation = new ParsedEquation(scanner.nextLine());

        try {
            System.out.println(equation.parseEquation());
        } catch (BalanceException e) {
            e.printStackTrace();
        }
    }
}
