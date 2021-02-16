package hu.meiit.haladojava.calculator;

import java.util.Scanner;

public class App 
{
    //Abban az osztályban, amiben a main van, más nem lehet.

    private static String[] parse(String expression) throws Exception {
        String[] ret = expression.split(" ");
        if (ret.length != 3) {
            String[] nums = expression.split("[\\+\\-\\*\\/]");
            if (nums.length != 2) {
                throw new Exception();
            }
            String operand = expression.split("[0-9]")[1];
        }
        return ret;
    }

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
            String[] tokens = parse(expression);
            assertTokens(tokens);
            Expression expression1 = getAsExpression(tokens);
            String result = expression1.executeExpression();
            System.out.print(result);
        }
        catch (Exception e) {
            System.out.println("-");
        }
    }
}
