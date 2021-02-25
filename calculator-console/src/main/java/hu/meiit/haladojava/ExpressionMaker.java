package hu.meiit.haladojava;

import hu.meiit.haladojava.logic.Expression;
import hu.meiit.haladojava.logic.Operation;

public class ExpressionMaker {

    public static final char[] acceptedOperations = new char[] {'+', '-', '*', '/'};

    private ExpressionMaker(){
        super();
    }

    public static Expression parse(String expression) throws ExpressionInvalidException {
        String[] tokens = expression.split(" ");
        double[] numericTokens;
        char operator;
        if (tokens.length != 3) {
            tokens = splitByOperator(expression);
            try{
                numericTokens = getNumericTokens(tokens);
            }
            catch (NumberFormatException e) {
                throw new ExpressionInvalidException();
            }
            operator = getOperator(expression);
        }
        numericTokens = getNumericTokens(tokens);
        operator = getOperator(expression);
        return new Expression(numericTokens[0], numericTokens[1], convertOperatorToOperation(operator));
    }

    private static String[] splitByOperator(String expression) {
        return expression.split("[\\+\\-\\*\\/]");
    }

    private static double[] getNumericTokens(String[] tokens) throws ExpressionInvalidException{
        double operand1;
        double operand2;
        if (tokens.length == 2) {
            operand1 = Double.valueOf(tokens[0]);
            operand2 = Double.valueOf(tokens[1]);
        }
        else if (tokens.length == 3) {
            operand1 = Double.valueOf(tokens[0]);
            operand2 = Double.valueOf(tokens[2]);
        }
        else {
            throw new ExpressionInvalidException();
        }
        return new double[]{operand1, operand2};
    }

    private static char getOperator(String expression) throws ExpressionInvalidException {
        String strOperand = expression.split("[0-9]")[1].trim();
        if(strOperand.length() != 1) {
            throw new ExpressionInvalidException();
        }
        char operand = strOperand.charAt(0);
        if(isAcceptedOperator(operand)) {
            return operand;
        }
        else {
            throw new ExpressionInvalidException();
        }
    }

    private static boolean isAcceptedOperator(char operator) {
        for(char acceptedOperator : acceptedOperations) {
            if (operator == acceptedOperator) {
                return true;
            }
        }
        return false;
    }

    private static Operation convertOperatorToOperation(char operator) throws ExpressionInvalidException{
        switch (operator) {
            case '+':
                return Operation.ADDITION;
            case '-':
                return Operation.SUBTRACTION;
            case '*':
                return Operation.MULTIPLICATION;
            case '/':
                return Operation.DIVISION;
            default:
                throw new ExpressionInvalidException();
        }
    }

}
