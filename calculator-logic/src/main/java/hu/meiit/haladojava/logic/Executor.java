package hu.meiit.haladojava.logic;

public class Executor {

    public double add (Expression expression) {
        return expression.getOperand1() + expression.getOperand2();
    }

    public double subtract (Expression expression) {
        return expression.getOperand1() - expression.getOperand2();
    }

    public double multiply (Expression expression) {
        return expression.getOperand1() * expression.getOperand2();
    }

    public double divide (Expression expression) throws Exception{
        if (expression.getOperand2() == 0) {
            throw new Exception();
        }
        return expression.getOperand1() / expression.getOperand2();
    }

}
