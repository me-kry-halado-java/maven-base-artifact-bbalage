package hu.meiit.haladojava;

import hu.meiit.haladojava.logic.Executor;
import hu.meiit.haladojava.logic.Expression;
import hu.meiit.haladojava.logic.IExecutor;

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

    public static void main( String[] args )
    {
        try {
            String strExpression = getExpressionFromStandardInput();
            Expression expression = ExpressionMaker.parse(strExpression);
            IExecutor executor = new Executor();
            System.out.print(executor.executeExpression(expression));
        }
        catch (Exception e) {
            System.out.println("-");
        }
    }
}
