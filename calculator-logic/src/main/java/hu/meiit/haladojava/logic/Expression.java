package hu.meiit.haladojava.logic;

public class Expression {
    private final double operand1;
    private final double operand2;

    public Expression(double operand1, double operand2) {
        this.operand1 = operand1;
        this.operand2 = operand2;
    }

    public double getOperand1() {
        return operand1;
    }

    public double getOperand2() {
        return operand2;
    }
}
