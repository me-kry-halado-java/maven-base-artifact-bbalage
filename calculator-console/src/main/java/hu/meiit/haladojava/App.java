package hu.meiit.haladojava;

import hu.meiit.haladojava.logic.Expression;

import java.util.Scanner;

/**
 * Hello world!
 *
 */
public class App 
{

    private static String getExpressionFromStandardInput() {
        Scanner scanner = new Scanner(System.in);
        String expression = scanner.nextLine();
        scanner.close();
        return expression;
    }

    private static void assertTokens(String[] tokens) throws Exception {
        if (tokens.length != 3) {
            throw new Exception("Wrong input.");
        }
    }

    private static Expression getAsExpression(String[] tokens) {
        String operator = tokens[1];
        int operand1 = Integer.parseInt(tokens[0]);
        int operand2 = Integer.parseInt(tokens[2]);
        Expression expression = new Expression(operand1, operator, operand2);
        return expression;
    }

    public static void main( String[] args )
    {
        try {
            String expression = getExpressionFromStandardInput();
            Expression expression1 = ExpressionMaker.parse(expression);
            assertTokens(tokens);
            String result = expression1.executeExpression();
            System.out.print(result);
        }
        catch (Exception e) {
            System.out.println("-");
        }
    }
}
